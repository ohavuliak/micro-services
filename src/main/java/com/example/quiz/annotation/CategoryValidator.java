package com.example.quiz.annotation;

import com.example.quiz.repository.QuestionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CategoryValidator implements ConstraintValidator<CategoryValidation, String> {
    private final QuestionRepository questionRepository;
    public boolean isValid(String category, ConstraintValidatorContext constraintValidatorContext) {
        return !questionRepository.findByCategory(category).isEmpty();
    }
}
