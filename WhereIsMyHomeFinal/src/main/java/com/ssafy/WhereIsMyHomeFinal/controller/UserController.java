package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.UserInfoDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody UserInfoDto userInfoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidFormException("다시 입력해주세요");
        }
        userService.createUser(userInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@Validated @RequestBody UserInfoDto userInfoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidFormException("다시 입력해주세요");
        }
        userService.createAdminUser(userInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public UserInfoDto get(@AuthenticationPrincipal UserInfo userInfo) {
        return new UserInfoDto(userInfo);
    }
}
