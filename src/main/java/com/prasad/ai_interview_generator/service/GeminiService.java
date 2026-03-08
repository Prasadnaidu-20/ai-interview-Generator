package com.prasad.ai_interview_generator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    public String generateQuestions(String topic) {

        String prompt = "Generate 5 interview questions on " + topic;

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        String requestBody = """
        {
          "contents":[
            {
              "parts":[{"text":"%s"}]
            }
          ]
        }
        """.formatted(prompt);

        return restTemplate.postForObject(url, requestBody, String.class);
    }
}
