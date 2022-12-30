package com.ssafy.WhereIsMyHomeFinal.controller.advice;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.InvalidFormExceptionDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LoginFailureExceptionDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.StandardExceptionDto;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.LoginFailureException;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidFormExceptionDto invalidFormExceptionHandler(InvalidFormException e) {
        log.info("에러 발생 : {}", e.getMessage());
        return new InvalidFormExceptionDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public LoginFailureExceptionDto loginFailureExceptionHandler(LoginFailureException e) {
        log.info("에러 발생 : {}", e.getMessage());
        return new LoginFailureExceptionDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardExceptionDto NotFoundExceptionHandler(ResourceNotFoundException e) {
        log.info("에러 발생 : {}", e.getMessage());
        return new StandardExceptionDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardExceptionDto runtimeExceptionHandler(RuntimeException e) {
        log.info("에러 발생 : {}", e.getMessage());
        return new StandardExceptionDto(e.getMessage());
    }
}
