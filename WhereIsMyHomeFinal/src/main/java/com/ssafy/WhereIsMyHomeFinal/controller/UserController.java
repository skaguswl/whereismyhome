package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.UserInfoDto;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
