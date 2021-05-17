package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RegisterBoardDto;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.BoardModel;
import com.example.demo.util.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public int regist(RegisterBoardDto board, int uid) throws Exception {
       return mapper.registerBoard(board, uid);
    }

    @Override
    public BoardModel read(Integer boardId) throws Exception {
        return mapper.findBoardById(boardId);
    }

    @Override
    public void modify(BoardModel board) throws Exception {

    }

    @Override
    public int remove(Integer bno) throws Exception {
        return mapper.deleteBoard(bno);
    }

    @Override
    public List<BoardModel> listCriteria(Criteria criteria) throws Exception {

        System.out.println("\n\n" + criteria + "\n\n");
        return mapper.getBoardList(criteria.getPageStart(), criteria.getPerPageNum());
    }

    @Override
    public int countPaging() {
        return mapper.boardCount();
    }

    @Override
    public String getTime() {

        return null;
    }

    @Override
    public String getUname(String uid) {

        return null;
    }

}
