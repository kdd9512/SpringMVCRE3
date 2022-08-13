package com.kdd9512.SpringMVCRE3.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import com.kdd9512.SpringMVCRE3.domain.BoardVO;
import com.kdd9512.SpringMVCRE3.domain.Criteria;
import com.kdd9512.SpringMVCRE3.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register : [ " + board + " ]");

        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {

        log.info("===================================GET : [ " + bno + " ]======================================");
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify : [ " + board + " ]");

        return mapper.update(board) == 1; // true / false 를 1과 0 으로 구분하므로
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove : [ " + bno + " ]");

        return mapper.delete(bno) == 1; // true / false 를 1과 0 으로 구분하므로
    }

//    @Override
//    public List<BoardVO> getList() {
//
//        log.info("===========================getList===========================");
//        return mapper.getList();
//    }

    @Override
    public List<BoardVO> getList(Criteria cri) {

        log.info("==========================getList with Criteria [ " + cri + " ]============================");
        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        log.info("get total count======================================================");
        return mapper.getTotalCount(cri);
    }

}
