package com.ssafy.WhereIsMyHomeFinal.security;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class UserContext extends User {

    private final UserInfo userInfo;

    public UserContext(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        super(userInfo.getUsername(), userInfo.getPassword(), authorities);
        this.userInfo = userInfo;
    }
}
