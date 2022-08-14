package com.kdd9512.SpringMVCRE3.mapper;

import com.kdd9512.SpringMVCRE3.domain.ReplyVO;

public interface ReplyMapper {

    public int insert(ReplyVO vo);  // 댓글 삽입.

    public ReplyVO read(Long rno); // 댓글 조회.

    public int delete(Long rno); // 댓글 삭제. 정상적으로 삭제되면 1을 출력.

}
