package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;

import java.util.List;

public interface MapService {

    public List<MapDto> sido();

    public List<MapDto> gugun(String regcodePattern);

    public List<MapDto> dong(String regcodePattern);
}
