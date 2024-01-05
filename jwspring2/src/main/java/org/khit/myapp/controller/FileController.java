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
	
	// ���� ���ε� ��
	@GetMapping("/file/upload")
	public String uploadForm() {
		return "/file/uploadform";
	}
	// ���� ���ε� ó��
	@PostMapping("/file/upload")
	public String upload(MultipartFile filename, Model model) throws IllegalStateException, IOException {
		// ���� ���� ��������
		long fileSize = filename.getSize(); // ���� ũ��
		String fileType = filename.getContentType(); // ���� �Ӽ� png
		
//		log.info(originFilename);
		log.info(fileSize + "B");
		log.info(fileType);
		
		// ������ ����
		String savedFilename = "";
		if(!filename.isEmpty()) { // ���޵� ������ �ִ� ���
			
			String filepath = "C:\\springworks\\jwspring2\\src\\main\\webapp\\upload";
			savedFilename = filename.getOriginalFilename();
			// ���� �̸� �ߺ��� �ȵǴ� ���� ID ��ü ����
			UUID uuid = UUID.randomUUID(); // �̸��� �����ϰ� ����
			savedFilename = uuid.toString() + "_" + savedFilename;
			
			File file = new File(filepath + "\\" + savedFilename);
			filename.transferTo(file); // ���� ������ ����
		}
		
		model.addAttribute("filename", savedFilename);
		
		return "/file/uploadform";
	}
}
