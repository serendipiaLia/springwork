package com.khit.members.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	// ȸ������ ��
	@GetMapping("/join")
	public String joinForm() {
		return "/member/join";
	}
	
	// ȸ������ ó��
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("memberDTO" + memberDTO);
		// ȸ������ ó��(����)
		memberService.insert(memberDTO);
		return "/member/login";
	}
	// �α��� �� 
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	
	// �α��� ó��
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember != null) { // �α��� ���� ��, ���� �߱� 
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			return "main";
		}else {
			return "/member/login";
		}
	}
	
	// �α׾ƿ� 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // ��缼�� ����
		return "redirect:/";
	}
	
	// ȸ�� ��� ��ȸ
	@GetMapping("/")
	public String getMemberList(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "/member/list";
	}
	
	// ȸ�� �󼼺���
	@GetMapping
	public String getMember(@RequestParam("id") Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	// ȸ�� �����ϱ�
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		memberService.delete(id);
		return "redirect:/member/"; //�����ϰ� ȸ��������� ����
	}
	// ȸ�� ���� ���� ������ - ���� �߱�)
	// param���� �ѱ��� ���� ������ ����(email)���� ã������..(�������� sessionId = id��  ã��) >> sesssionId = email
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		// ȸ���� �̸���(����)�� �������� 
		String email = (String)session.getAttribute("sessionEmail"); // �����̸��� �߱�
		MemberDTO memberDTO = memberService.findByEmail(email);
		model.addAttribute("member", memberDTO);
		return "/member/update";
	}
	
	// ȸ������ ���� ó��
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
		return "redirect:/member?id=" + memberDTO.getId();
	}
	// �̸��� �ߺ��˻�
	@PostMapping("/checkemail")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		String resultText = memberService.checkEmail(email);
		return resultText; // "OK"�� "NO"��ȯ
	}
	
	
}
