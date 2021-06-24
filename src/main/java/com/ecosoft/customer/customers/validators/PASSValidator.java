package com.ecosoft.customer.customers.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class PASSValidator implements ConstraintValidator<PASS, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.length() == 16;
    }
}