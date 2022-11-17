package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QnaDto {

    private Long qnaId;

    @NotBlank
    private String userid;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
