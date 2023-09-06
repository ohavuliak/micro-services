package com.example.quiz.controller;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.mapper.QuestionMapper;
import com.example.quiz.service.QuestionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Question", description = "The Quiz API. Contains all the operations that can be performed on a question.")

public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;


    @GetMapping()
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(@RequestParam(required = false) String category) {
        log.info("Fetching list of questions");
        return ResponseEntity.ok(questionMapper.toListDto(questionService.getAllQuestions(category)));
    }


    @PostMapping()
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDTO) {
        log.info("Adding a new question");
        return ResponseEntity.ok(questionMapper.toDto(questionService.addQuestion(questionMapper.toEntity(questionDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        log.info("Deleting question with ID: {}", id);
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestions(@RequestBody QuestionDTO questionDTO, @PathVariable Long id) {
        log.info("Updating question with ID: {}", id);
        return ResponseEntity.ok(questionService.updateQuestion(questionMapper.toEntity(questionDTO), id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id) {
        log.info("Fetching question with ID: {}", id);
        return ResponseEntity.ok(questionMapper.toDto(questionService.getQuestionById(id)));
    }

}