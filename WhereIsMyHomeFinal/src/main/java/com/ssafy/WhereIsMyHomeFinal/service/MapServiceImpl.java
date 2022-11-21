package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;
import com.ssafy.WhereIsMyHomeFinal.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    @Override
    public List<MapDto> sido() {
        return mapRepository.findSido();
    }

    @Override
    public List<MapDto> gugun(String regcodePattern) {
        List<MapDto> gugun = mapRepository.findGugun(regcodePattern);
        if (1 > gugun.size()) {
            return null;
        }
        return gugun.subList(1, gugun.size());
    }

    @Override
    public List<MapDto> dong(String regcodePattern) {
        List<MapDto> dong = mapRepository.findDong(regcodePattern);
        if (1 > dong.size()) {
            return null;
        }
        return dong.subList(1, dong.size());
    }
}
