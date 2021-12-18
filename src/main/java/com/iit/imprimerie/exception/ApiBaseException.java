package com.iit.imprimerie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public abstract class ApiBaseException extends RuntimeException {
    public ApiBaseException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode();
}
