package com.example.quiz.mapper;

import com.example.quiz.dto.QuizDTO;
import com.example.quiz.model.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper extends  EntityMapper<Quiz, QuizDTO> {
}
