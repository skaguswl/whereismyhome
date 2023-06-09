package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;
import com.ssafy.WhereIsMyHomeFinal.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("/sido")
    public List<MapDto> sido() {
        return mapService.sido();
    }

    @GetMapping("/gugun")
    public List<MapDto> gugun(@RequestParam String regcodePattern) {
        return mapService.gugun(regcodePattern);
    }

    @GetMapping("/dong")
    public List<MapDto> dong(@RequestParam String regcodePattern) {
        return mapService.dong(regcodePattern);
    }

    @GetMapping("/loc")
    public List<LocationDto> loc(@RequestParam String regcodePattern) {
        return mapService.loc(regcodePattern);
    }

    @GetMapping("/apt")
    public List<AptDto> apt(@RequestParam("lat") String lat, @RequestParam("lng") String lng) {
        return mapService.apt(lat, lng);
    }
}