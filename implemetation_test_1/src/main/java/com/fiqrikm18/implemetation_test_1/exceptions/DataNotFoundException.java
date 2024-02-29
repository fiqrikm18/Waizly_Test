package com.fiqrikm18.implemetation_test_1.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus code;

    public DataNotFoundException(String message) {
        this.message = message;
        this.code = HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

}
