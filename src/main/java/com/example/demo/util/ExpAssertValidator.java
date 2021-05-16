package com.example.demo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpAssertValidator implements ConstraintValidator<ExpAssert, Object> {

    private Expression exp;

    @Override
    public void initialize(ExpAssert constraintAnnotation) {
        ExpressionParser parser = new SpelExpressionParser();
        exp = parser.parseExpression(constraintAnnotation.value());

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return exp.getValue(value, Boolean.class);
    }

}
