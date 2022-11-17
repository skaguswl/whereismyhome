package com.ssafy.WhereIsMyHomeFinal.controller.advice;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.InvalidFormExceptionDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.StandardExceptionDto;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidFormExceptionDto invalidFormExceptionHandler(InvalidFormException e) {
        return new InvalidFormExceptionDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardExceptionDto NotFoundExceptionHandler(NotFoundException e) {
        return new StandardExceptionDto(e.getMessage());
    }
}
