package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    private Role role;

    @NotBlank
    @Email
    private String email;

    public UserInfoDto(UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
    }
}
