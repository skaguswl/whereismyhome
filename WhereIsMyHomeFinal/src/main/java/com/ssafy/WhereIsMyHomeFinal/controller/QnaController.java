package com.ssafy.WhereIsMyHomeFinal.controller;

import com.ssafy.WhereIsMyHomeFinal.domain.dto.QnaDto;
import com.ssafy.WhereIsMyHomeFinal.domain.dto.ReplyDto;
import com.ssafy.WhereIsMyHomeFinal.domain.entity.UserInfo;
import com.ssafy.WhereIsMyHomeFinal.domain.exception.InvalidFormException;
import com.ssafy.WhereIsMyHomeFinal.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
@Slf4j
public class QnaController {

    private final QnaService qnaService;

    @GetMapping
    public List<QnaDto> getQnaList() {
        return qnaService.getQnaList();
    }

    @PostMapping
    public ResponseEntity<?> register(@Validated @RequestBody QnaDto qnaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidFormException("다시 입력해주세요");
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserInfo) {
            qnaService.register(qnaDto, (UserInfo) principal);
        } else {
            qnaService.register(qnaDto, null);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{qnaId}")
    public QnaDto getQna(@PathVariable Long qnaId) {
        return qnaService.getQnaDto(qnaId);
    }

    @DeleteMapping("/{qnaId}")
    public ResponseEntity<?> deleteQna(@PathVariable Long qnaId) {
        qnaService.deleteQna(qnaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateQna(@Validated @RequestBody QnaDto qnaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidFormException("다시 입력해주세요");
        }
        qnaService.updateQna(qnaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reply")
    public ResponseEntity<?> registerReply(@RequestBody ReplyDto replyDto) {
        qnaService.reply(replyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/reply/delete")
    public ResponseEntity<?> deleteReply(@RequestParam("qnaId") Long qnaId) {
        qnaService.deleteReply(qnaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/reply")
    public ResponseEntity<?> updateReply(@RequestBody ReplyDto replyDto) {
        qnaService.reply(replyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
