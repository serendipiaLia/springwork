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
	
	// ���� Ŭ���� ����(������, Autowired)
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/insert")
	public @ResponseBody List<ReplyDTO> replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		// ��� ���� �Էµ� ������ ���
		log.info("ReplyDTO : " + replyDTO);
		// ��� ���� ó��
		replyService.insert(replyDTO);
		// ��� �� ��� ��� �����ͼ� (��û�� ajax�� �ִ�)detail �������� ������
		List<ReplyDTO> replyList =  replyService.getReplyList(replyDTO.getBoardId());
		return replyList;
	}
	// ��� ����
	@GetMapping("/delete")
	public String replyDelete(@RequestParam("boardId") Long boardId, @RequestParam("id") Long id) {
		// ������ �� ��� ��ȣ�� �ĸ����ͷ� ������
		replyService.delete(id);
		return "redirect:/board?id=" + boardId;
	}
	
	// ��� ���� - ��� ���� ��������
	@GetMapping("/update")
	public String updateForm(@RequestParam("boardId") Long boardId, @RequestParam("id") Long id, Model model) {
		// �ش� ��� ��������
		ReplyDTO replyDTO = replyService.findById(id);
		model.addAttribute("reply", replyDTO);
		return "/board/replyupdate";
	}

	// ��� ���� - ó�� (������Ʈ)
	@PostMapping("/update")
	public String update(@ModelAttribute ReplyDTO replyDTO) {
		log.info("" + replyDTO);
		replyService.update(replyDTO);
		return "redirect:/board?id=" + replyDTO.getBoardId();
	}
	
}
