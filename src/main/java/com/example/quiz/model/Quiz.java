package com.example.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long userId;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "quiz_questions",
            joinColumns = @JoinColumn(
                    name = "quiz_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "questions_id", referencedColumnName = "id")
    )
    private List<Question> questions;
}
