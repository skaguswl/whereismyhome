package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.ReplyDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QnaService {

    void register(QnaDto qnaDto, UserInfo userInfo);

    Page<QnaDto> getQnaList(Pageable pageable);

    QnaDto getQnaDto(Long qnaId);

    void deleteQna(Long qnaId);

    void updateQna(QnaDto qnaDto);

    void registerReply(ReplyDto replyDto);
}

