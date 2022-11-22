package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.entity.Bookmark;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Houseinfo;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.ResourceNotFoundException;
import com.ssafy.WhereIsMyHomeFinal.repository.BookmarkRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.HouseinfoRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final UserRepository userRepository;

    private final HouseinfoRepository houseinfoRepository;

    @Override
    public void register(Long aptCode, UserInfo userInfo) {
        Houseinfo houseinfo = houseinfoRepository.findById(aptCode).orElseThrow(() -> new ResourceNotFoundException("아파트가 없습니다"));
        bookmarkRepository.save(Bookmark.builder().userInfo(userInfo).houseinfo(houseinfo).build());
    }
}
