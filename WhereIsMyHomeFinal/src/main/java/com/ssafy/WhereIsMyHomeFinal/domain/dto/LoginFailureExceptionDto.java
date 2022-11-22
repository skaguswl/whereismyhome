package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginFailureExceptionDto {

    private final String message;
}
