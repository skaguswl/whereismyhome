package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.ReplyDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QnaService {

    void register(QnaDto qnaDto, UserInfo userInfo);

    List<QnaDto> getQnaList();

    QnaDto getQnaDto(Long qnaId);

    void deleteQna(Long qnaId);

    void updateQna(QnaDto qnaDto);

    void reply(ReplyDto replyDto);

    void deleteReply(Long qnaId);
}

