package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InvalidFormExceptionDto {

    private final String message;
}
