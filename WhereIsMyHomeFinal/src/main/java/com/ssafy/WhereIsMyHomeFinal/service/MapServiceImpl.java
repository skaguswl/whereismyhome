package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;
import com.ssafy.WhereIsMyHomeFinal.repository.DongcodeRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.HouseinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final DongcodeRepository dongcodeRepository;

    private final HouseinfoRepository houseinfoRepository;

    @Override
    public List<MapDto> sido() {
        return dongcodeRepository.findSido();
    }

    @Override
    public List<MapDto> gugun(String regcodePattern) {
        List<MapDto> gugun = dongcodeRepository.findGugun(regcodePattern);
        if (1 > gugun.size()) {
            return null;
        }
        return gugun.subList(1, gugun.size());
    }

    @Override
    public List<MapDto> dong(String regcodePattern) {
        List<MapDto> dong = dongcodeRepository.findDong(regcodePattern);
        if (1 > dong.size()) {
            return null;
        }
        return dong.subList(1, dong.size());
    }

    @Override
    public List<LocationDto> apt(String regcodePattern) {
        return houseinfoRepository.findApt(regcodePattern);
    }
}