package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.BookmarkDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
@Slf4j
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/register")
    public void register(@RequestParam("aptCode") Long aptCode, @AuthenticationPrincipal UserInfo userInfo) {
        bookmarkService.register(aptCode, userInfo);
    }

    @GetMapping("/get")
    public Page<BookmarkDto> get(Pageable pageable, @AuthenticationPrincipal UserInfo userInfo) {
        return bookmarkService.get(userInfo, pageable);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("bookmarkId") Long bookmarkId, @AuthenticationPrincipal UserInfo userInfo) {
        bookmarkService.delete(bookmarkId, userInfo);
    }
}
