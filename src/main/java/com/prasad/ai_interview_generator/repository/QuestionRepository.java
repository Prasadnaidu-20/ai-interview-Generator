package com.prasad.ai_interview_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prasad.ai_interview_generator.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}