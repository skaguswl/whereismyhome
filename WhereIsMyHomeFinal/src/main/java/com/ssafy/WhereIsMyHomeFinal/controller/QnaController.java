package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnaController {

    private final QnaService qnaService;

    @GetMapping
    public Page<QnaDto> getQnaList(Pageable pageable) {
        return qnaService.getQnaList(pageable);
    }

    @PostMapping
    public ResponseEntity<?> register(@Validated @RequestBody QnaDto qnaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidFormException("다시 입력해주세요");
        }
        qnaService.register(qnaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{qnaId}")
    public QnaDto getQna(@RequestParam Long qnaId) {
        return qnaService.getQnaDto(qnaId);
    }
}
