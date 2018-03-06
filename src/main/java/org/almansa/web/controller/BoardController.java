package org.almansa.web.controller;

import java.util.List;

import org.almansa.app.core.board.Board;
import org.almansa.app.service.boardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	ModelAndView index() {
		List<Board> boards = service.getBoardList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardlist");
		mv.addObject("boards", boards);
		mv.addObject("count", boards.size());
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add() {
		List<Board> boards = service.getBoardList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardadd");
		mv.addObject("boards", boards);
		return mv;
	}	
}
