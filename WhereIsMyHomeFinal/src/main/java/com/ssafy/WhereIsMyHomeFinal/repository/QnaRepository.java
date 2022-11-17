package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Qna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QnaRepository extends JpaRepository<Qna, Long> {

    Qna save(Qna qna);

    Page<Qna> findAll(Pageable pageable);

    Optional<Qna> findById(Long qnaId);
}
