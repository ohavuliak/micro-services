package com.example.quiz.mapper;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.model.Question;
import com.example.quiz.model.QuestionWrapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends EntityMapper<Question, QuestionDTO>{
List<QuestionWrapper> questionToQuestionWrapper(List<Question> question);
}