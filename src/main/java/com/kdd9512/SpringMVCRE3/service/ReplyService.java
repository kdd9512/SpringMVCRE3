package com.kdd9512.SpringMVCRE3.service;

import com.kdd9512.SpringMVCRE3.domain.Criteria;
import com.kdd9512.SpringMVCRE3.domain.ReplyPageDTO;
import com.kdd9512.SpringMVCRE3.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVO vo);

    public ReplyVO get(Long rno);

    public int modify(ReplyVO vo);

    public int remove(Long rno);

    public ReplyPageDTO getList(Criteria cri, Long bno);

}
