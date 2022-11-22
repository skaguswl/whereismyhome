package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;

public interface BookmarkService {

    void register(Long aptCode, UserInfo userInfo);
}
