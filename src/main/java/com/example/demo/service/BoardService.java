package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RegisterBoardDto;
import com.example.demo.model.BoardModel;
import com.example.demo.util.Criteria;

public interface BoardService {
    int regist(RegisterBoardDto board, int uid) throws Exception;

    BoardModel read(Integer boardId) throws Exception;

    void modify(BoardModel board) throws Exception;

    int remove(Integer bno) throws Exception;

    List<BoardModel> listCriteria(Criteria criteria) throws Exception;

    int countPaging();

    String getTime();

    String getUname(String uid);
}
