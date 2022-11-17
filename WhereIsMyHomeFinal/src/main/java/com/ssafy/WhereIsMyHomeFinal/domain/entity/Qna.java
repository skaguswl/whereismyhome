package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Qna {

    @Id
    @GeneratedValue
    @Column(name = "qna_id")
    private Long id;

    @Column(nullable = false, updatable = false)
    private String userid;

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false, length = 20000)
    private String content;

    public Qna(QnaDto qnaDto) {
        this.userid = qnaDto.getUserid();
        this.subject = qnaDto.getSubject();
        this.content = qnaDto.getContent();
    }
}
