package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<Qna, Long> {

    Qna save(Qna qna);
}
