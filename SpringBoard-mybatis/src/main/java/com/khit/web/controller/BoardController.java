package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.BoardDTO;
import com.khit.web.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {

	private BoardService boardService;
	
	// �۾��� ������ ��û
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	// �۾���
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO : " + boardDTO );
		boardService.insert(boardDTO);
		return "redirect:/board/"; //list.jsp�� �̵�
	}
	
	// �۸��
	@GetMapping("/")
	public String getList() {
		return "/board/boardlist";
	}
	
}
