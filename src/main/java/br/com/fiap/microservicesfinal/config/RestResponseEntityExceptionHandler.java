package br.com.fiap.microservicesfinal.config;

import br.com.fiap.microservicesfinal.exception.InvalidTransactionException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleServerError(Exception ex, WebRequest request) {
        String bodyOfResponse = "Erro no servidor";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { InvalidTransactionException.class })
    protected ResponseEntity<Object> handleOrderNotFoundException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, StringUtils.EMPTY, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }
}