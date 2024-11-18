package com.pos.quizapp.service;

import com.pos.quizapp.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface QuizService {

ResponseEntity<List<Question>> getAllQuestions();
ResponseEntity<List<Question>> getQuestionsByCategory(String topic);
ResponseEntity<Object> addQuestion(Question question);
}
