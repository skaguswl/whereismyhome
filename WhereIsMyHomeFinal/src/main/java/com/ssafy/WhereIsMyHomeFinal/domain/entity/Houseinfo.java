package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Houseinfo {

    @Id
    private Long aptCode;

    private Integer buildYear;

    @Column(length = 40)
    private String roadName;

    @Column(length = 5)
    private String roadNameBonbun;

    @Column(length = 5)
    private String roadNameBubun;

    @Column(length = 2)
    private String roadNameSeq;

    @Column(length = 1)
    private String roadNameBasementCode;

    @Column(length = 7)
    private String roadNameCode;

    @Column(length = 40)
    private String dong;

    @Column(length = 4)
    private String bonbun;

    @Column(length = 4)
    private String bubun;

    @Column(length = 5)
    private String sigunguCode;

    @Column(length = 5)
    private String eubmyundongCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dong_code")
    private Dongcode dongcode;

    @Column(length = 1)
    private String landCode;

    @Column(length = 40)
    private String apartmentName;

    @Column(length = 10)
    private String jibun;

    @Column(length = 30)
    private String lng;

    @Column(length = 30)
    private String lat;
}
