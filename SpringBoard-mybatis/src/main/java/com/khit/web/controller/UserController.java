package com.khit.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.UserDTO;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// ȸ������ ������ ��û
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	
	// ȸ������ ó��
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO) {
		log.info("userDTO : " + userDTO);
		userService.insert(userDTO);
		return "redirect:/";
	}
	
	// ȸ�� ���
	@GetMapping("/")
	public String userlist(Model model) {
		List<UserDTO> userDTOList = userService.findAll();
		model.addAttribute("userList", userDTOList);
		return "/user/userlist";
	}
	
	// ȸ�� �󼼺��� - getUser() >> user?id
	@GetMapping
	public String getUser(@RequestParam("id") Long id, Model model) {
		UserDTO userDTO = userService.findById(id);
		model.addAttribute("user", userDTO);
		return "/user/userdetail";
	}
	
	// �α��� ������
	@GetMapping("/login")
	public String loginForm() {
		return "/user/login";
	}
	
	// �α��� ó��
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO, HttpSession session) { //userDTO : �ԷµȰ� 
		// �α��� ó�� ����, ����
		UserDTO loginUser = userService.login(userDTO); // loginUser : ����� �޴� ��
			if(loginUser != null) { 
				// ���ǹ߱� ( HttpSession session) 
				session.setAttribute("sessionId", userDTO.getUserId());
				return "redirect:/main"; // �α��� ������ mainȭ������ �̵�
			}else {
				return "/user/login";
			}
	}
	
	// �α׾ƿ� ó��
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //���� ����
		return "redirect:/";
	}
}
