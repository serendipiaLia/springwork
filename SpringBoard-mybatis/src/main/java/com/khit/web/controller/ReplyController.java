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
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	// 서비스 클래스 주입(생성자, Autowired)
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/insert")
	public @ResponseBody List<ReplyDTO> replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		// 댓글 폼에 입력된 데이터 출력
		log.info("ReplyDTO : " + replyDTO);
		// 댓글 저장 처리
		replyService.insert(replyDTO);
		// 등록 후 댓글 목록 가져와서 (요청한 ajax가 있는)detail 페이지로 보내줌
		List<ReplyDTO> replyList =  replyService.getReplyList(replyDTO.getBoardId());
		return replyList;
	}
	// 댓글 삭제
	@GetMapping("/delete")
	public String replyDelete(@RequestParam("boardId") Long boardId, @RequestParam("id") Long id) {
		// 삭제할 땐 댓글 번호를 파리미터로 보내줌
		replyService.delete(id);
		return "redirect:/board?id=" + boardId;
	}
	
	// 댓글 수정 - 댓글 내용 가져오기
	@GetMapping("/update")
	public String updateForm(@RequestParam("boardId") Long boardId, @RequestParam("id") Long id, Model model) {
		// 해당 댓글 가져오기
		ReplyDTO replyDTO = replyService.findById(id);
		model.addAttribute("reply", replyDTO);
		return "/board/replyupdate";
	}

	// 댓글 수정 - 처리 (업데이트)
	@PostMapping("/update")
	public String update(@ModelAttribute ReplyDTO replyDTO) {
		log.info("" + replyDTO);
		replyService.update(replyDTO);
		return "redirect:/board?id=" + replyDTO.getBoardId();
	}
	
}
