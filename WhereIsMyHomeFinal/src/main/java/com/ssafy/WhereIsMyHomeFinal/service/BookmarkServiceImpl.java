package com.ssafy.WhereIsMyHomeFinal.service;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.BookmarkDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Bookmark;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.Houseinfo;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.ResourceNotFoundException;
import com.ssafy.WhereIsMyHomeFinal.repository.BookmarkRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.HouseinfoRepository;
import com.ssafy.WhereIsMyHomeFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final UserRepository userRepository;

    private final HouseinfoRepository houseinfoRepository;

    @Override
    public void register(Long aptCode, UserInfo userInfo) {
        Houseinfo houseinfo = houseinfoRepository.findById(aptCode).orElseThrow(() -> new ResourceNotFoundException("아파트가 없습니다"));
        if (bookmarkRepository.findByUserIdAndAptCode(userInfo.getId(), aptCode).isPresent()) {
            throw new RuntimeException("이미 등록된 북마크 입니다.");
        }
        bookmarkRepository.save(new Bookmark(userInfo, houseinfo));
    }

    @Override
    public void delete(Long bookmarkId, UserInfo userInfo) {
        Bookmark bookmark = bookmarkRepository.findById(bookmarkId).orElseThrow(() -> new ResourceNotFoundException("북마크가 없습니다."));
        if (!bookmark.getUserInfo().getUsername().equals(userInfo.getUsername())) {
            throw new RuntimeException("권한이 없습니다.");
        }
        bookmarkRepository.delete(bookmark);
    }

    @Override
    public List<BookmarkDto> get(UserInfo userInfo) {
        return bookmarkRepository.findByUserId(userInfo.getId()).stream().map(b -> BookmarkDto.builder()
                .bookmarkId(b.getId())
                .apartmentName(b.getHouseinfo().getApartmentName())
                .lat(b.getHouseinfo().getLat())
                .lng(b.getHouseinfo().getLng())
                .build()).collect(Collectors.toList());
    }
}
