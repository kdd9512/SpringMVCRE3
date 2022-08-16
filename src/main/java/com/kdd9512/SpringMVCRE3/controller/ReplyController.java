package com.kdd9512.SpringMVCRE3.controller;

import com.kdd9512.SpringMVCRE3.domain.ReplyVO;
import com.kdd9512.SpringMVCRE3.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    private ReplyService service;


    @PostMapping(value = "/new",
            consumes = "application/json",
            produces = { MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(
            // JSON 데이터를 @ResponseBody 를 적용한 타입(ReplyVO)으로 형변환한다.
            @RequestBody ReplyVO vo) {

        log.info("ReplyVO : " + vo);

        int insertCnt = service.register(vo);

        log.info("Reply InsertCnt : " + insertCnt);

        return insertCnt == 1 ?
                new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }

}
