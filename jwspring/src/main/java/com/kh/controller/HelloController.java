package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Ŭ������ ����� ��ü(beans) ���� : new �ѰͰ� ����!
public class HelloController {
	
	// ��� ����(servlet)
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; //hello.jsp
	}
}