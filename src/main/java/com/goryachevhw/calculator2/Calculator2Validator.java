package com.goryachevhw.calculator2;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class Calculator2Validator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Calculator2Request.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Calculator2Request request = (Calculator2Request) target;
        if (request.getNum1() == null || request.getNum2() == null) {
            errors.reject("missing.parameters", "оба параметра должны быть указанны.");
        }
    }
}
