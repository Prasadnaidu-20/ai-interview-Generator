package com.prasad.ai_interview_generator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasad.ai_interview_generator.model.Question;
import com.prasad.ai_interview_generator.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final QuestionRepository questionRepository;

    public GeminiService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> generateQuestions(String topic) {

        try {

            String prompt =  "Generate exactly 5 interview questions on " + topic + " only as a numbered list.";

            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;


            RestTemplate restTemplate = new RestTemplate();

            String body = "{ \"contents\": [ { \"parts\": [ { \"text\": \"" + prompt + "\" } ] } ] }";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(body, headers);

            String response = restTemplate.postForObject(url, entity, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String text = root
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text") 
                    .asText();

            String[] questions = text.split("\\d+\\. ");
            
            List<Question> savedQuestions = new java.util.ArrayList<>();
            for (String qText : questions) {
                qText = qText.replaceAll("^\\d+\\.\\s*", "").trim();
                if (!qText.trim().isEmpty()) {
                    Question q = new Question(topic, qText);
                    savedQuestions.add(questionRepository.save(q));
                }
            }

            return savedQuestions;

        } catch (Exception e) {
        throw new RuntimeException("Error generating questions: " + e.getMessage());
    }
    }
}