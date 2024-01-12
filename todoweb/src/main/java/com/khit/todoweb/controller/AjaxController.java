package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.todoweb.dto.AjaxDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController { // ajax 처리하는 컨트롤러

		@GetMapping("/ex01")
		public String ex01() {
			log.info("GET 요청 처리");
			return "/ajax-ex/main"; //main.jsp 
		}
		// 문자열로 반환 : @ResponseBody 사용
		@PostMapping("/ex02")
		public @ResponseBody String ex02() {
			log.info("POST 요청 처리");
			return "/ajax-ex/main"; //main.jsp 
		}
		
		@GetMapping("/ex03")
		public @ResponseBody String ex03(@RequestParam("greet") String greet, 
										 @RequestParam("num") int num)  {
			log.info("greet: " + greet);
			log.info("num: " + num);
			return "success";
		}
		
		// ajaxDTO : object(객체)이므로 json(자바스크립트데이터)으로 변환하려면 jackson-databind를 pom.xml에 주입해줘야함! 
		@PostMapping("/ex04")
		public @ResponseBody AjaxDTO ex04(@ModelAttribute AjaxDTO ajaxDTO) {
			log.info("ajaxDTO =" + ajaxDTO);
			return ajaxDTO; //객체 보내기
		}
		
		
}
