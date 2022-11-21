package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.AptDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Houseinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseinfoRepository extends JpaRepository<Houseinfo, Long> {


    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.LocationDto(h.lng, h.lat) from Houseinfo h where h.dongcode.id = :dongCode")
    List<LocationDto> findApt(@Param("dongCode") String regcodePattern);
}
