package com.kdd9512.SpringMVCRE3.controller;

import com.kdd9512.domain.SampleVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
