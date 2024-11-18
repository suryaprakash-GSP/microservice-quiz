package com.pos.quizapp.service.impl;

import com.pos.quizapp.entity.Question;
import com.pos.quizapp.repo.QuestionRepo;
import com.pos.quizapp.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {

    private final QuestionRepo questionRepo;

    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
       try{
           List<Question>questions= questionRepo.findAll();
           return ResponseEntity.status(HttpStatus.OK).body(questions);
       }
       catch(Exception e){
          log.error("QuizServiceImpl:: getAllQuestions failed :: {}", e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
       }
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String topic) {
       try{
           return ResponseEntity.status(HttpStatus.OK).body(questionRepo.findByCategory(topic));
       }
       catch(Exception e){
           log.error("QuizServiceImpl:: getQuestionsByCategory failed :: {}", e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
       }
    }

    @Override
    public ResponseEntity<Object> addQuestion(Question question) {
        Map<String, String> map = new HashMap<>();
       try{
           questionRepo.save(question);
           map.put("message", "Question added successfully");
           map.put("status", "201");
           return ResponseEntity.status(HttpStatus.CREATED).body(map);
       }catch (Exception e){
           log.error("QuizServiceImpl:: addQuestion failed :: {}", e.getMessage());
           map.put("message", "Error while adding question");
           map.put("status", "500");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
       }
    }
}
