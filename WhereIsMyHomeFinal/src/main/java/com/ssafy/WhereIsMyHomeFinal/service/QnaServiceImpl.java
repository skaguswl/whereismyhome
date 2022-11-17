package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Qna;
import com.ssafy.WhereIsMyHomeFinal.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService{

    private final QnaRepository qnaRepository;

    @Override
    public void register(QnaDto qnaDto) {
        Qna qna = new Qna(qnaDto);
        qnaRepository.save(qna);
    }
}
