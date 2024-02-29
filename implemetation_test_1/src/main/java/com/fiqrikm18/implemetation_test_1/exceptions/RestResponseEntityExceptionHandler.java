package com.fiqrikm18.implemetation_test_1.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    protected ResponseEntity<Object> handleInternalServerError(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    public static class ErrorResponse {

        private HttpStatus code;
        private String msg;

        public ErrorResponse(HttpStatus code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public HttpStatus getCode() {
            return code;
        }

        public void setCode(HttpStatus code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
