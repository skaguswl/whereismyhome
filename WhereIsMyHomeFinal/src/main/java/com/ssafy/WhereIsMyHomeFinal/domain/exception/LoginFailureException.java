package com.ssafy.WhereIsMyHomeFinal.domain.exception;

public class LoginFailureException extends RuntimeException {

    public LoginFailureException(String message) {
        super(message);
    }
}
