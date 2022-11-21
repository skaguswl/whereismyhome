package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Housedeal {

    @Id
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apt_code")
    private Houseinfo houseInfo;

    @Column(length = 20)
    private String dealAmount;

    private Integer dealYear;

    private Integer dealMonth;

    private Integer dealDay;

    @Column(length = 20)
    private String area;

    @Column(length = 4)
    private String floor;

    @Column(length = 1)
    private String cancelDealType;

}
