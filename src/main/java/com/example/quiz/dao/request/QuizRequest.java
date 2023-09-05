package com.example.quiz.dao.request;

import lombok.Data;

@Data
public class QuizRequest {
    private String category;
    private Integer numQ;
    private String title;
    private Long userId;
    private String difficultylevel;
}
