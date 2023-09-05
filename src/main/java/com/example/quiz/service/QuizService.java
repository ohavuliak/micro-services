package com.example.quiz.service;

import com.example.quiz.exception.MessageCode;
import com.example.quiz.exception.NotFoundException;
import com.example.quiz.mapper.QuestionMapper;
import com.example.quiz.mapper.QuizMapper;
import com.example.quiz.model.Quiz;
import com.example.quiz.dao.request.QuizRequest;
import com.example.quiz.model.*;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final QuizMapper quizMapper;

    public Quiz createQuiz(QuizRequest request) {
        List<Question> questions = questionRepository
                .findRandomQuestionsByCategoryAndDifficultylevel(request.getCategory(), request.getNumQ(), request.getDifficultylevel());

        Quiz quiz = new Quiz();
        quiz.setTitle(request.getTitle());
        quiz.setQuestions(questions);
        quiz.setUserId(request.getUserId());
        quizRepository.save(quiz);

        return quiz;
    }

    public List<QuestionWrapper> getQuizQuestions(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageCode.NOT_FOUND_QUIZ));
        return questionMapper.questionToQuestionWrapper(quiz.getQuestions());
    }
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public String updateQuiz(Quiz updatedQuiz, Long id) {
        Quiz existingQuiz = quizRepository.findById(id).orElseThrow( () -> new NotFoundException(MessageCode.NOT_FOUND_QUIZ));
        quizMapper.updateEntity(existingQuiz, updatedQuiz);
        quizRepository.save(existingQuiz);
        return "Quiz was successfully updated";
    }

    public List<Quiz> findAllQuizzesByUserId(Long id) {
        return quizRepository.findAllByUserId(id);
    }
}