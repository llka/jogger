package ru.ilka.jogger.exception;

import org.springframework.http.HttpStatus;

public class RestExceptionNotFound extends RestException {
    public RestExceptionNotFound() {
        setHttpStatus(HttpStatus.NOT_FOUND);
    }
}
