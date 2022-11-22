package com.ssafy.WhereIsMyHomeFinal.domain.dto;

import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserInfoDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    private Role role;

    @NotBlank
    private String email;
}
