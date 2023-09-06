package com.example.quiz.dao.request;

import com.example.quiz.annotation.CategoryValidation;
import com.example.quiz.annotation.DifficultyLevelValidation;
import lombok.Data;

@Data
public class QuizRequest {
    @CategoryValidation()
    private String category;
    private Integer numQ;
    private String title;
    private Long userId;
    @DifficultyLevelValidation()
    private String difficultylevel;
}
