package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserService {

	void insert(UserDTO userDTO);

	//회원 목록
	List<UserDTO> findAll();
	
	// 회원 상세보기 
	UserDTO findById(Long id);
	
	// 로그인처리
	UserDTO login(UserDTO userDTO);
	
	// 회원 정보 수정
	UserDTO findByUserId(String userId);
	
	// 회원 정보 수정 처리
	void update(UserDTO userDTO);
	
	// 회원 삭제 처리 
	void delete(Long id);
	
	// 아이디 중복검사
	String checkUserId(String userId);

}
