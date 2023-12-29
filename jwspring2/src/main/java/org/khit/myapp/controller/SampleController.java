package org.khit.myapp.controller;

import org.khit.myapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
@Controller
public class SampleController {
	
//	@RequestMapping("/join")
	@GetMapping("/join")
	public String joinForm() { // 가입 폼
		return "user/join"; // join.jsp
	}
	// 
	@PostMapping("/join")
	public String joinPost(UserDTO userDTO) {
		System.out.println("userDTO = " + userDTO);
		return "redirect:/"; //redirect는 경로 입력, index로 강제 이동
	}
	
	
	/*============================ Practice =================================*/
	//가입 처리
	@GetMapping("join2")
	public String join(UserDTO userDTO) {
		// 스프링은 파라미터(함수의 매개변수)로 name속성을 받음 *request 사용하지 않음!
		System.out.println(userDTO);
		return "index"; // name=손흥민&age=31 Console에 가져옴
	}
	
	//가입 처리 - name하나만 가져오기
	@GetMapping("join3")
	public String join(@RequestParam("name") String name) {
		System.out.println("이름 : "  + name);
		return "index";
	}
	
}
