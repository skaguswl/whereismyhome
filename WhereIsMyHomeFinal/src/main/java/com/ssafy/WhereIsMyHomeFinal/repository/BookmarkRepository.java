package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select b from Bookmark b where b.userInfo.id = :userId and b.houseinfo.aptCode = :aptCode")
    Optional<Bookmark> findByUserIdAndAptCode(@Param("userId") Long userId, @Param("aptCode") Long aptCode);

    @Query(value = "select b from Bookmark b join fetch b.houseinfo where b.userInfo.id = :userId",
            countQuery = "select count(b) from Bookmark b where b.userInfo.id = :userId")
    Page<Bookmark> findByUserId(@Param("userId") Long userId, Pageable pageable);
}
