package com.uni.boot2.controller;

import com.uni.boot2.dto.BoardDto;
import com.uni.boot2.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@Slf4j //log
@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping()
    public String main(){
        return "redirect:/board/boardListView";
    }

    @GetMapping("/boardListView")
    public void selectBoardAll(Model model){
        model.addAttribute("boards", boardService.selectBoardAll()); //view에서 boards로 받고있음
    }

    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable long id){ //path로 들어온 값 받기, 공백이면 에러, "."을 넣으면 중간에 잘리거나 함
        log.info("id 확인 ---" + id);
        boardService.deleteById(id);
        return "redirect:/board/boardListView";
    }

    @GetMapping("/insertForm")
    public String insertForm(){
        return "board/boardEnroll";
    }

    @PostMapping("/insert")
    public String insertBoard(@ModelAttribute BoardDto board/*, Model model*/){

        boardService.insertBoard(board);
//        model.addAttribute("boards", boardService.selectBoardAll());
//        return "board/boardListView";

        return "redirect:/board/boardListView";
    }

    @GetMapping("/detail/{id}")
    public String selectBoard(@PathVariable long id, Model model){

        log.info("detail_id 확인 ---" + id);

        model.addAttribute("board", boardService.selectBoard(id));
        return "board/boardDetail";

//        boardService.selectBoard(id);
//        return "redirect:/board/boardDetail";
    }

    @PostMapping("/update")
    public String updateBoard(@ModelAttribute BoardDto board){

        boardService.updateBoard(board);

        return "redirect:/board/boardListView";
    }
}
