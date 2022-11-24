package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookmarkDto {

    private Long bookmarkId;

    private String apartmentName;

    private String lat;

    private String lng;
}
