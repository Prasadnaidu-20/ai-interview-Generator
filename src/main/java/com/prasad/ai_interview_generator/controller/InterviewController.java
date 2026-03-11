package com.prasad.ai_interview_generator.controller;

import java.util.List;
import com.prasad.ai_interview_generator.model.Question;
import com.prasad.ai_interview_generator.repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;
import com.prasad.ai_interview_generator.service.GeminiService;

@RestController
@RequestMapping("/api")
public class InterviewController {

    private final GeminiService geminiService;
    private final QuestionRepository questionRepository;

    public InterviewController(GeminiService geminiService,QuestionRepository questionRepository) {
        this.geminiService = geminiService;
        this.questionRepository = questionRepository;
    }


    @GetMapping("/history")
    public List<Question> getHistory() {
        return questionRepository.findAll();
    }

    @GetMapping("/generate")
    public List<Question> generateQuestions(@RequestParam String topic) {
        return geminiService.generateQuestions(topic);
    }
}
