package com.ssafy.WhereIsMyHomeFinal.domain.entity;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.UserInfoDto;
import com.ssafy.WhereIsMyHomeFinal.domain.enumtype.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@ToString
public class UserInfo extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

    public UserInfo(UserInfoDto userInfoDto, PasswordEncoder passwordEncoder) {
        this.username = userInfoDto.getUsername();
        this.password = passwordEncoder.encode(userInfoDto.getPassword());
        this.name = userInfoDto.getName();
        this.role = Role.USER;
        this.email = userInfoDto.getEmail();
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
