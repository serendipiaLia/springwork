package com.khit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService; // 댓글
	
	// 글쓰기 페이지 요청
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	// 글쓰기
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO : " + boardDTO );
		boardService.insert(boardDTO);
		return "redirect:/board/paging"; 
	}
	
	// 글목록 
	@GetMapping("/") // /board/
	public String getList(Model model) { // model이 받아줌
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList); // (값(key), 객체value)
		return "/board/boardlist";
	}
	
	// 글 목록(페이지 처리)
	// 요청할 때 : /board/paging?page=2
	// @RequestParam(required=true/false) -> false는 필수 아님
	@GetMapping("/paging")
	public String getPageList(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		log.info("page : " + page);
		// 페이지와 글 개수 구현 
		List<BoardDTO>pagingList =  boardService.pagingList(page);
		log.info("pagingList : " + pagingList);
		
		model.addAttribute("boardList", pagingList);
		
		// 화면 하단의 번호 별 링크 구현 (PageDTO 활용)
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("paging", pageDTO); // 페이지에 관련된 걸 넘기기 pageDTO
		
		return "/board/pagelist";
	}
	
	
	// 글 상세보기
	@GetMapping // /board?id=
	public String getBoard(@RequestParam("id") Long id, @RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		// 조회수 증가
		boardService.updateHit(id);
		// 글 상세보기
		BoardDTO boardDTO = boardService.findById(id);
		// 댓글 목록 보기 >> service는 ReplyService에서
		replyService.getReplyList(id);
		List<ReplyDTO> replyDTOList = replyService.getReplyList(id);
		
		model.addAttribute("board", boardDTO);
		model.addAttribute("replyList", replyDTOList); // 댓글 목록보기 
		model.addAttribute("page", page); 
		
		return "/board/detail";
	}
	
	// 글 삭제
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	
	// 글 수정 페이지
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model model) { // detail.jsp에서 수정부분 ?로 받았기에
		// 수정 할 게시글 가져오기
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);				
		return "/board/boardupdate";
	}
	
	// 글 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/update?id=" + boardDTO.getId();
	}
}
