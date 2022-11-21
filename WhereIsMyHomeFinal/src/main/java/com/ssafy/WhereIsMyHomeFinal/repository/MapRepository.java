package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Dongcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MapRepository extends JpaRepository<Dongcode, Long> {

    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto(d.dongCode, d.sidoName) from Dongcode d where d.dongCode like '%00000000'")
    List<MapDto> findSido();

    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto(d.dongCode, d.gugunName) from Dongcode d where d.dongCode like concat(:regcodePattern,'__000000')")
    List<MapDto> findGugun(@Param("regcodePattern") String regcodePattern);

    @Query("select new com.ssafy.WhereIsMyHomeFinal.domain.dto.MapDto(d.dongCode, d.dongName) from Dongcode d where d.dongCode like concat(:regcodePattern,'%')")
    List<MapDto> findDong(@Param("regcodePattern") String regcodePattern);
}
