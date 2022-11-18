package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.ReplyDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Qna;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.NotFoundException;
import com.ssafy.WhereIsMyHomeFinal.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QnaServiceImpl implements QnaService{

    private final QnaRepository qnaRepository;

    @Override
    public void register(QnaDto qnaDto) {
        qnaRepository.save(new Qna(qnaDto));
    }

    @Override
    public Page<QnaDto> getQnaList(Pageable pageable) {
        return qnaRepository.findAll(pageable).map(q -> QnaDto.builder()
                .qnaId(q.getId())
                .userid(q.getUserId())
                .subject(q.getSubject())
                .content(q.getContent())
                .replyState(q.getReplyState().getDescription())
                .createdDate(q.getCreatedDate().toLocalDate())
                .build());
    }

    @Override
    public QnaDto getQnaDto(Long qnaId) {
        Optional<Qna> qna = qnaRepository.findById(qnaId);
        if (qna.isEmpty()) {
            throw new NotFoundException("등록 처리시 문제가 발생했습니다.");
        }
        return QnaDto.builder()
                .qnaId(qna.get().getId())
                .userid(qna.get().getUserId())
                .subject(qna.get().getSubject())
                .content(qna.get().getSubject())
                .replyState(qna.get().getReplyState().getDescription())
                .createdDate(qna.get().getCreatedDate().toLocalDate())
                .build();
    }

    @Override
    public void deleteQna(Long qnaId) {
        qnaRepository.deleteById(qnaId);
    }

    @Override
    public void updateQna(QnaDto qnaDto) {
        Qna qna = qnaRepository.findById(qnaDto.getQnaId()).orElseThrow(() -> new NotFoundException("수정 처리시 문제가 발생했습니다."));
        qna.setSubject(qnaDto.getSubject());
        qna.setContent(qnaDto.getContent());
    }

    @Override
    public void registerReply(ReplyDto replyDto) {
        Qna qna = qnaRepository.findById(replyDto.getQnaId()).orElseThrow(() -> new NotFoundException("수정 처리시 문제가 발생했습니다."));
        qna.setReply(replyDto.getReply());
    }
}
