package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.UserInfoDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.Role;
import com.ssafy.WhereIsMyHomeFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserInfoDto userInfoDto) {
        userRepository.save(new UserInfo(userInfoDto, passwordEncoder));
    }

    @Override
    public void createAdminUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo(userInfoDto, passwordEncoder);
        userInfo.setRole(Role.ADMIN);
        userRepository.save(userInfo);
    }
}
