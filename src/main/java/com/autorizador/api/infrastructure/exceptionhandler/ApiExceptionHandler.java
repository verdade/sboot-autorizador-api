package com.autorizador.api.infrastructure.exceptionhandler;

import com.autorizador.api.application.exception.BusinessLogicException;
import com.autorizador.api.application.exception.CartaoNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<Object> handleBusinessLogicException(BusinessLogicException ex, WebRequest webRequest) {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .title(httpStatusCode.toString())
                .status(httpStatusCode.value())
                .detail(ex.getMessage())
                .build();
        log.error("Handler error business logic exception {}", errorResponse, ex);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), httpStatusCode, webRequest);
    }

    @ExceptionHandler(CartaoNotFoundException.class)
    public ResponseEntity<Object> handleBusinessLogicException(CartaoNotFoundException ex, WebRequest webRequest) {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .title(httpStatusCode.toString())
                .status(httpStatusCode.value())
                .detail(ex.getMessage())
                .build();
        log.error("Handler error business logic exception {}", errorResponse, ex);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), httpStatusCode, webRequest);
    }



}
