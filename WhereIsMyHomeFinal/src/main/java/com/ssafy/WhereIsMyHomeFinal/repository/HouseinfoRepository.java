package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Houseinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseinfoRepository extends JpaRepository<Houseinfo, Long> {


    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto(h.lat, h.lng) from Houseinfo h where h.dongcode.id = :dongCode")
    List<LocationDto> findLoc(@Param("dongCode") String regcodePattern);

    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto(h.aptCode, h.buildYear, h.roadName, h.dong, h.jibun, h.apartmentName, hd.dealAmount, h.lat, h.lng, hd.dealYear, hd.dealMonth, hd.dealDay)" +
            " from Housedeal hd join hd.houseInfo h where h.lat = :lat and h.lng = :lng")
    List<AptDto> findApt(@Param("lat") String lat, @Param("lng") String lng);
}
