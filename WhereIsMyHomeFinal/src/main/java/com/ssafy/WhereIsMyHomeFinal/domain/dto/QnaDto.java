package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnaDto {

    private Long qnaId;

    @NotBlank
    private String userid;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;

    private String replyState;

    private LocalDate createdDate;
}
