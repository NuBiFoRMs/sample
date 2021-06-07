package com.nubiform.web;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class EventIdValidator implements ConstraintValidator<EventId, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("isValid");
        return value.matches("^N[0-9]{4}$");
    }
}
