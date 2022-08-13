package com.kdd9512.SpringMVCRE3.controller;

import com.kdd9512.SpringMVCRE3.domain.SampleVO;
import com.kdd9512.SpringMVCRE3.domain.Ticket;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getText() {

        log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);

        return "SUCCESS";
    }

    @GetMapping(value="/getSample",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }) // xml 은 왜 안되나...
    public SampleVO getSample() {
        return new SampleVO(123, "성", "이름");
    }

    @GetMapping(value="/getList")
    public List<SampleVO> getList() {
        // 1~10 미만의 루프를 처리하면서 SampleVO 객체를 생성.
        return IntStream.range(1,10)
                .mapToObj(i -> new SampleVO(i, i + " First ", i + " Last ")
                ).collect(Collectors.toList());

    }
    
    @GetMapping("/getMap")
    public Map<String, SampleVO> getMap() {

        Map<String, SampleVO> map = new HashMap<>();

        map.put("First", new SampleVO(111,"성2", "이름2"));

        return map;

    }

    // REST 방식으로 호출. ResponseEntity 를 이용하여 데이터와 HTTP 헤더의 상태를 함께 전달함.
    @GetMapping(value = "/check", params={"height" , "weight"})
    public ResponseEntity<SampleVO> check (Double height, Double weight) {

        SampleVO vo = new SampleVO(0, "" + height, "" + weight);

        ResponseEntity<SampleVO> result = null;

        // height 값이 150보다 작으면 502 error / 이외는 200
        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }

        return result;
    }

    // @PathVariable 실습.
    // URL 경로 일부를 param 으로 받아 생성할 수 있다.
    // 이 annotation 을 이용하는 경우 param 값은 기본자료형으로 사용할 수 없다.
    @GetMapping(value = "/product/{cat}/{pid}")
    public String[] getPath(
            @PathVariable("cat") String cat,
            @PathVariable("pid") String pid) {

        return new String[] {"category : " + cat,", producid : " +  pid};
    }

    // @RequestBody 실습
    // 전달된 request 의 내용을 이용하여 해당 param 타입으로 형변환을 요구한다.
    // 요청받은 내용을 처리하는 방식이므로 GetMapping 이 아니라 PostMapping 을 사용해야한다.
    @PostMapping("/ticket")
    public Ticket convert(@RequestBody Ticket ticket) {

        log.info("========================Convert Ticket : " + ticket);

        return ticket;
    }


}
