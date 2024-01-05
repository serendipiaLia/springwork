package com.khit.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.SampleDTO;

@Controller // RestController(문자json) 반환
public class SampleController {

	@GetMapping("/exam01")
	public String exam01(Model model) {
		Date date = new Date();
		model.addAttribute("serverTime", date);
		return "/sample/exam01"; 
	}
	
	// exam02?name=이나경&age=26
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO sampleDTO) {
		return "/sample/exam02";
	}
	
	@GetMapping("/exam03")
	public @ResponseBody SampleDTO exam03() {
		SampleDTO dto = new SampleDTO();
		dto.setName("이나경");
		dto.setAge(26);
		return dto;
	}
}
