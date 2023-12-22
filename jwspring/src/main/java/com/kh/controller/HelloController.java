package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 클래스를 사용할 객체(beans) 생성 : new 한것과 같음!
public class HelloController {
	
	// 경로 설정(servlet)
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; //hello.jsp
	}
}
