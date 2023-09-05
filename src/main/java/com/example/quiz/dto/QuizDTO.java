package com.example.quiz.dto;

import com.example.quiz.model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class QuizDTO {
    private Long id;
    private String title;
    private Long userId;
    private List<Question> questions;
}
