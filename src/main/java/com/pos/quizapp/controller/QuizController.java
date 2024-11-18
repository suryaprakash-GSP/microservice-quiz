package com.pos.quizapp.controller;


import com.pos.quizapp.entity.Question;
import com.pos.quizapp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {



    private final QuizService quizService;

    @GetMapping
    ResponseEntity<List<Question>> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    @GetMapping("/category/{topic}")
    ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String topic) {
        return quizService.getQuestionsByCategory(topic);
    }
    @PostMapping
    ResponseEntity<Object> addQuestion(@RequestBody Question question) {
        return quizService.addQuestion(question);
    }



}
