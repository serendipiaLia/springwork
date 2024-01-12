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
	
	// 회원가입 폼
	@GetMapping("/join")
	public String joinForm() {
		return "/member/join";
	}
	
	// 회원가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("memberDTO" + memberDTO);
		// 회원가입 처리(저장)
		memberService.insert(memberDTO);
		return "/member/login";
	}
	// 로그인 폼 
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	
	// 로그인 처리
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember != null) { // 로그인 성공 시, 세션 발급 
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			return "main";
		}else {
			return "/member/login";
		}
	}
	
	// 로그아웃 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 모든세션 삭제
		return "redirect:/";
	}
	
	// 회원 목록 조회
	@GetMapping("/")
	public String getMemberList(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "/member/list";
	}
	
	// 회원 상세보기
	@GetMapping
	public String getMember(@RequestParam("id") Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	// 회원 삭제하기
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		memberService.delete(id);
		return "redirect:/member/"; //삭제하고 회원목록으로 가기
	}
	// 회원 정보 수정 페이지 - 세션 발급)
	// param으로 넘기지 않은 이유는 세션(email)으로 찾으려고..(이전에는 sessionId = id로  찾음) >> sesssionId = email
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		// 회원을 이메일(세션)로 가져오기 
		String email = (String)session.getAttribute("sessionEmail"); // 세션이메일 발급
		MemberDTO memberDTO = memberService.findByEmail(email);
		model.addAttribute("member", memberDTO);
		return "/member/update";
	}
	
	// 회원정보 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
		return "redirect:/member?id=" + memberDTO.getId();
	}
	// 이메일 중복검사
	@PostMapping("/checkemail")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		String resultText = memberService.checkEmail(email);
		return resultText; // "OK"나 "NO"반환
	}
	
	
}
