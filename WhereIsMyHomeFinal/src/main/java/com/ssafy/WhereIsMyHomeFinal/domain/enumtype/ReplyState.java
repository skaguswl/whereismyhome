package com.ssafy.WhereIsMyHomeFinal.domain.enumtype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReplyState {
    Y("답변 완료"), N("미답변");

    private final String description;
}
