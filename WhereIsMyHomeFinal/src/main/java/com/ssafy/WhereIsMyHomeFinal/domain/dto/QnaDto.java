package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
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

    private String username;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;

    private String replyState;

    private LocalDate createdDate;

    private String reply;
}
