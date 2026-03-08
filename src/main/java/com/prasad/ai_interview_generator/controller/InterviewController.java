package com.prasad.ai_interview_generator.controller;

import org.springframework.web.bind.annotation.*;
import com.prasad.ai_interview_generator.service.GeminiService;

@RestController
@RequestMapping("/api")
public class InterviewController {

    private final GeminiService geminiService;

    public InterviewController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/questions")
    public String getQuestions(@RequestParam String topic) {
        return geminiService.generateQuestions(topic);
    }
}
