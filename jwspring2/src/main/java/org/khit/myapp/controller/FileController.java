package org.khit.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	
	// 파일 업로드 폼
	@GetMapping("/file/upload")
	public String uploadForm() {
		return "/file/uploadform";
	}
	// 파일 업로드 처리
	@PostMapping("/file/upload")
	public String upload(MultipartFile filename, Model model) throws IllegalStateException, IOException {
		// 원본 파일 가져오기
		long fileSize = filename.getSize(); // 파일 크기
		String fileType = filename.getContentType(); // 파일 속성 png
		
//		log.info(originFilename);
		log.info(fileSize + "B");
		log.info(fileType);
		
		// 서버에 저장
		String savedFilename = "";
		if(!filename.isEmpty()) { // 전달된 파일이 있는 경우
			
			String filepath = "C:\\springworks\\jwspring2\\src\\main\\webapp\\upload";
			savedFilename = filename.getOriginalFilename();
			// 파일 이름 중복이 안되는 고유 ID 객체 생성
			UUID uuid = UUID.randomUUID(); // 이름이 랜덤하게 나옴
			savedFilename = uuid.toString() + "_" + savedFilename;
			
			File file = new File(filepath + "\\" + savedFilename);
			filename.transferTo(file); // 서버 폴더에 저장
		}
		
		model.addAttribute("filename", savedFilename);
		
		return "/file/uploadform";
	}
}
