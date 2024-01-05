package com.khit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		// ��� ���� �Էµ� ������ ���
		log.info("ReplyDTO : " + replyDTO);
		// ��� ���� ó��
		replyService.insert(replyDTO);
		return "redirect:/board?id=" + replyDTO.getBoardId();
	}
}
