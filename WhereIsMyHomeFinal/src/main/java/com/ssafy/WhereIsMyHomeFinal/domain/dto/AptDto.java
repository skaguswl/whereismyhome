package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AptDto {

    private Long aptCode;

    private Integer buildYear;

    private String roadName;

    private String dong;

    private String jibun;

    private String apartmentName;

    private String lng;

    private String lat;

    public AptDto(String apartmentName, String lng, String lat) {
        this.apartmentName = apartmentName;
        this.lng = lng;
        this.lat = lat;
    }
}
