package com.example.quiz.annotation;

import com.example.quiz.model.DifficultyLevel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class DifficultyLevelValidator implements ConstraintValidator< DifficultyLevelValidation, String> {
    public boolean isValid(String difficultyLevel, ConstraintValidatorContext constraintValidatorContext) {
        return difficultyLevel.equals(DifficultyLevel.EASY.name()) ||
                difficultyLevel.equals(DifficultyLevel.MEDIUM.name()) ||
                difficultyLevel.equals(DifficultyLevel.HARD.name());
    }
}
