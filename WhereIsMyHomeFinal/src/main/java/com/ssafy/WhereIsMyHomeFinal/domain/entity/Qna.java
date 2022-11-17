package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.ReplyState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
public class Qna extends BaseEntity {

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

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @ColumnDefault("'N'")
    private ReplyState replyState;

    public Qna(QnaDto qnaDto) {
        this.userid = qnaDto.getUserid();
        this.subject = qnaDto.getSubject();
        this.content = qnaDto.getContent();

    }

}
