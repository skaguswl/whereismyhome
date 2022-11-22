package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
public class Bookmark extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "bookmark_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apt_code")
    private Houseinfo houseinfo;
}
