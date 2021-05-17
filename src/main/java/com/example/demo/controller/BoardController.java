package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.demo.dto.RegisterBoardDto;
import com.example.demo.interceptor.SessionNames;
import com.example.demo.model.BoardModel;
import com.example.demo.model.DemoUserModel;
import com.example.demo.model.PageMakerModel;
import com.example.demo.service.BoardService;
import com.example.demo.util.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        /*
         * System.out.println("\n\n LIST : " + list + "\n\n");
         * System.out.println("\n\n TotalCount : " + pageMaker.getTotalCount() +
         * "\n\n"); System.out.println("\n\n END PAGE" + pageMaker.getEndPage() +
         * "\n\n"); System.out.println("\n\n Get Start Page" + pageMaker.getStartPage()
         * + "\n\n"); System.out.println("\n\n Get Cri" + pageMaker.getCri() + "\n\n");
         * System.out.println("\n\n IS PREV" + pageMaker.isPrev() + "\n\n");
         * System.out.println("\n\n IS NEXT" + pageMaker.isNext() + "\n\n");
         */
        model.addAttribute("boardList", list);
        model.addAttribute("pageMaker", pageMaker);

        return "board/index";
    }

    @GetMapping("board/read/{boardId}")
    public String readPost(@PathVariable int boardId, Model model) throws Exception {
        BoardModel content = board_srv.read(boardId);
        model.addAttribute("content", content);
        return "board/read";
    }

    @GetMapping("board/write")
    public String writePage(Model model) {
        model.addAttribute("registerBoardDto", new RegisterBoardDto());
        return "board/write";
    }

    @PostMapping("board/write-submit")
    public String writeSubmit(@Valid @ModelAttribute("registerBoardDto") RegisterBoardDto dto,
            BindingResult bindingResult, HttpSession session, HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return "board/write";
        }
        try {
            DemoUserModel loginUser = (DemoUserModel) session.getAttribute(SessionNames.LOGIN);
            System.out.println("\n\n" + loginUser.toString() + "\n\n");
            System.out.println("\n\n" + bindingResult.toString() + "\n\n");
            board_srv.regist(dto, loginUser.getId());
            response.sendRedirect("/board");
            return null;
        } catch (Exception e) {
            System.out.println("\n\n ERROR : " + e + "\n\n");
            return "error";
        }

    }

    @PostMapping("board/delete/{boardId}")
    public String removeBoard(@PathVariable int boardId) throws Exception {
        int result = board_srv.remove(boardId);
        if (result == 0) {
            return "board";
        }
        return "error";

    }

    @GetMapping("board/modify/{boardId}")
    public String modifyBoard(@PathVariable int boardId, Model model) throws Exception {
        BoardModel target = board_srv.read(boardId);
        RegisterBoardDto dto = new RegisterBoardDto(target.getTitle(), target.getDescription());
        model.addAttribute("boardDto", dto);
        return "board/modify";
    }
}
