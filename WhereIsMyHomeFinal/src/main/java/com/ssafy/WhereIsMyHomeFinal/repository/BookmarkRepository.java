package com.ssafy.WhereIsMyHomeFinal.repository;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select b from Bookmark b where b.userInfo.id = :userId and b.houseinfo.aptCode = :aptCode")
    Optional<Bookmark> findByUserIdAndAptCode(@Param("userId") Long userId, @Param("aptCode") Long aptCode);

    @Query("select b from Bookmark b join fetch b.houseinfo where b.userInfo.id = :userId")
    List<Bookmark> findByUserId(@Param("userId") Long userId);
}
