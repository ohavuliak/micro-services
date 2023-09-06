package com.example.quiz.controller;

import com.example.quiz.dao.request.QuizRequest;
import com.example.quiz.dto.QuizDTO;
import com.example.quiz.mapper.QuestionMapper;
import com.example.quiz.mapper.QuizMapper;
import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.service.QuestionService;
import com.example.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/quiz")
@RequiredArgsConstructor
@Tag(name = "Quiz", description = "The Quiz API. Contains all the operations that can be performed on a quiz.")
@Slf4j
public class QuizController {

    private final QuizService quizService;
    private final QuizMapper quizMapper;


    @PostMapping()
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody QuizRequest request) {
        log.info("Adding a new quiz");
        return ResponseEntity.ok(quizMapper.toDto(quizService.createQuiz(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){
        log.info("Fetching list of quiz's questions");
        return ResponseEntity.ok(quizService.getQuizQuestions(id));
    }

    @GetMapping
    public ResponseEntity<List<QuizDTO>> getAllQuizzes(){
        log.info("Fetching list of quizzes");
        return ResponseEntity.ok(quizMapper.toListDto(quizService.getAllQuizzes()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id){
        log.info("Deleting quiz with with ID: {}", id);
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuiz(@RequestBody QuizDTO quizDTO, @PathVariable Long id) {
        log.info("Updating question with ID: {}", id);
        return ResponseEntity.ok(quizService.updateQuiz(quizMapper.toEntity(quizDTO), id));
    }

    @GetMapping("/get-quizzes/user-id/{id}")
    public ResponseEntity<List<QuizDTO>> findAllQuizzes(@PathVariable Long id){
        return ResponseEntity.ok(quizMapper.toListDto(quizService.findAllQuizzesByUserId(id)));
    }

}
