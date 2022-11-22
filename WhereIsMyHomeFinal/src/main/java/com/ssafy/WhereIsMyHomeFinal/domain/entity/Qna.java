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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false, length = 20000)
    private String content;

    @Lob
    @Column(length = 20000)
    private String reply;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @ColumnDefault("'N'")
    private ReplyState replyState;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReplyState(ReplyState replyState) {
        this.replyState = replyState;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Qna(QnaDto qnaDto) {
        this.userInfo = qnaDto.getUserInfo();
        this.subject = qnaDto.getSubject();
        this.content = qnaDto.getContent();
    }

}
