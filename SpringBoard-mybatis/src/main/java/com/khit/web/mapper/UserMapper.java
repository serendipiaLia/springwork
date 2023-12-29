package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserMapper {

	void insert(UserDTO userDTO);
	// 회원 목록
	List<UserDTO> findAll();
	
	// 회원 상세보기
	UserDTO findById(Long id);
	
	//로그인 처리
	UserDTO login(UserDTO userDTO);
	
}
