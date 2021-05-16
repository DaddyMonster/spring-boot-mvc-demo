package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.BoardModel;
import com.example.demo.model.PageMakerModel;
import com.example.demo.service.BoardService;
import com.example.demo.util.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/board/*")
public class BoardController {

    @Autowired
    BoardService board_srv;

    @GetMapping("board")
    public String boardPage(Model model, Criteria cri) throws Exception {
        PageMakerModel pageMaker = new PageMakerModel();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(board_srv.countPaging());
        List<BoardModel> list = board_srv.listCriteria(cri);
        System.out.println("\n\n" + list + "\n\n");
        model.addAttribute("boardList", list);
        model.addAttribute("pageMaker", pageMaker);

        return "board";
    }
}
