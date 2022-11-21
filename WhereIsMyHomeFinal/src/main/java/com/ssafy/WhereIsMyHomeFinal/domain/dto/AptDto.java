package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AptDto {

    private Long aptCode;

    private Integer buildYear;

    private String roadName;

    private String dong;

    private String jibun;

    private String apartmentName;

    private String dealAmount;

    private String lat;

    private String lng;

    private int dealYear;

    private int dealMonth;

    private int dealDay;
}