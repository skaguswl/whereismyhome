package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.BookmarkDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;

import java.util.List;

public interface BookmarkService {

    void register(Long aptCode, UserInfo userInfo);

    void delete(Long bookmarkId, UserInfo userInfo);

    List<BookmarkDto> get(UserInfo userInfo);
}
