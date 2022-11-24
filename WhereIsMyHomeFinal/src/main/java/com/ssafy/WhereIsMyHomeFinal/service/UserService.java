package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.UserInfoDto;

public interface UserService {

    void createUser(UserInfoDto userInfoDto);

    void createAdminUser(UserInfoDto userInfoDto);
}
