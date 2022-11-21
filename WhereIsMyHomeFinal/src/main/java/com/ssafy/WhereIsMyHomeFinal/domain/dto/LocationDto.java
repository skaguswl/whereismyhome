package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LocationDto {

    private String apartmentName;

    private String lng;

    private String lat;
}
