package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.BookmarkDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookmarkService {

    void register(Long aptCode, UserInfo userInfo);

    void delete(Long bookmarkId, UserInfo userInfo);

    Page<BookmarkDto> get(UserInfo userInfo, Pageable pageable);
}
