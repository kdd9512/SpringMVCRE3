package com.kdd9512.SpringMVCRE3.mapper;

import com.kdd9512.SpringMVCRE3.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Log4j
public class ReplyMapperTests {

    // 이하 번호의 게시물이 실제로 존재해야 작동한다. 반드시 DB 상에 존재하는지 확인해야 함.
    // 이 Array 에 있는 게시물 번호의 게시글들에 도합 RangeClosed 에서 설정한 만큼의 합의 댓글이 나뉘어 달릴 것.
    private Long[] bnoArr = {3L,4L,5L,6L,21L};

    @Setter(onMethod_ = {@Autowired})
    private ReplyMapper mapper;

    @Test
    public void testCreate(){

        IntStream.rangeClosed(1,10).forEach(i -> {

            ReplyVO vo = new ReplyVO();

            // 게시물번호
            vo.setBno(bnoArr[i % 5]);
            vo.setReply("test reply " + i);
            vo.setReplier("test replier " + i);

            mapper.insert(vo);

        });

    }

    @Test
    public void testRead(){

        Long targetRno = 10L;

        ReplyVO vo = mapper.read(targetRno);

        log.info(vo);

    }

    @Test
    public void testDelete(){

        Long targetRno = 10L;

        mapper.delete(targetRno);

    }

}
