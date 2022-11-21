package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;

import java.util.List;

public interface MapService {

    List<MapDto> sido();

    List<MapDto> gugun(String regcodePattern);

    List<MapDto> dong(String regcodePattern);

    List<LocationDto> loc(String regcodePattern);

    List<AptDto> apt(String lat, String lng);

}
