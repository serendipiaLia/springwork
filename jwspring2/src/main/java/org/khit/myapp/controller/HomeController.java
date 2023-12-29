package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // component
public class HomeController {
	
	// http://localhost:8080/
	@RequestMapping("/")
	public String home() { // 파일이름을 반환!(보내줌)
		
		
		return "index"; // home.jsp 
	}
	
}
