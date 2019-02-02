package ru.ilka.jogger.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.ilka.jogger.exception.RestException;

import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static Logger logger = LogManager.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(RestException.class)
    public ResponseEntity<Object> handleRestException(RestException exception) {
        logger.info("Exception Handler caught an exception.");
        return new ResponseEntity<>(jsonMediaTypeHeader(), Optional.ofNullable(exception.getHttpStatus()).orElse(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception exception) {
        logger.error("Exception Handler caught an exception.  {}", ExceptionUtils.getStackTrace(exception));
        return new ResponseEntity<>(jsonMediaTypeHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private HttpHeaders jsonMediaTypeHeader() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return responseHeaders;
    }

}
