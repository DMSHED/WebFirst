package com.http.exception;

import com.http.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<Error> errorList;

    public ValidationException(List<Error> errors) {
        this.errorList = errors;
    }

    public List<Error> getErrorList() {
        return this.errorList;
    }
}
