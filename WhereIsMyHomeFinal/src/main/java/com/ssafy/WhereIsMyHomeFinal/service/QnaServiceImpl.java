package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.ReplyDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Qna;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.ReplyState;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.ResourceNotFoundException;
import com.ssafy.WhereIsMyHomeFinal.repository.QnaRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.UserRepository;
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

    private final UserRepository userRepository;

    @Override
    public void register(QnaDto qnaDto, UserInfo userInfo) {
        qnaRepository.save(new Qna(qnaDto, userInfo));
    }

    @Override
    public Page<QnaDto> getQnaList(Pageable pageable) {
        return qnaRepository.findAll(pageable).map(q -> QnaDto.builder()
                .qnaId(q.getId())
                .username(q.getUserInfo() == null ? "익명사용자" : q.getUserInfo().getUsername())
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
            throw new ResourceNotFoundException("등록 처리시 문제가 발생했습니다.");
        }
        return QnaDto.builder()
                .qnaId(qna.get().getId())
                .username(qna.get().getUserInfo() == null ? "익명사용자" : qna.get().getUserInfo().getUsername())
                .subject(qna.get().getSubject())
                .content(qna.get().getSubject())
                .replyState(qna.get().getReplyState().getDescription())
                .createdDate(qna.get().getCreatedDate().toLocalDate())
                .reply(qna.get().getReply())
                .build();
    }

    @Override
    public void deleteQna(Long qnaId) {
        qnaRepository.deleteById(qnaId);
    }

    @Override
    public void updateQna(QnaDto qnaDto) {
        Qna qna = qnaRepository.findById(qnaDto.getQnaId()).orElseThrow(() -> new ResourceNotFoundException("수정 처리시 문제가 발생했습니다."));
        qna.setSubject(qnaDto.getSubject());
        qna.setContent(qnaDto.getContent());
    }

    @Override
    public void reply(ReplyDto replyDto) {
        Qna qna = qnaRepository.findById(replyDto.getQnaId()).orElseThrow(() -> new ResourceNotFoundException("수정 처리시 문제가 발생했습니다."));
        qna.setReply(replyDto.getReply());
        qna.setReplyState(ReplyState.Y);
    }

    @Override
    public void deleteReply(Long qnaId) {
        Qna qna = qnaRepository.findById(qnaId).orElseThrow(() -> new ResourceNotFoundException("못찾음"));
        qna.setReply(null);
        qna.setReplyState(ReplyState.N);
    }
}
