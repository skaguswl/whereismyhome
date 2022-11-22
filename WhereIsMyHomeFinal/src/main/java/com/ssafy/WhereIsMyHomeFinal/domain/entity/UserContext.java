package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserContext extends User {

    private final UserInfo userInfo;

    public UserContext(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        super(userInfo.getUsername(), userInfo.getPassword(), authorities);
        this.userInfo = userInfo;
    }
}
