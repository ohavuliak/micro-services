package com.example.quiz.dto;

import com.example.quiz.model.DifficultyLevel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private DifficultyLevel difficultylevel;
    private String category;
}