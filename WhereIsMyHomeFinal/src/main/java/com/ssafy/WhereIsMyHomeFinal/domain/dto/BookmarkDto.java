package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookmarkDto {

    private Long aptCode;

    private Integer buildYear;

    private String roadName;

    private String dong;

    private String jibun;

    private String apartmentName;

    private String lat;

    private String lng;
}
