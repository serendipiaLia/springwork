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
	
	// 회원 정보 수정
	UserDTO findByUserId(String userId);
	
	// 회원 정보 수정 처리
	void update(UserDTO userDTO); // void라 반환값이 없음 xml에서 resultType 안해두됨
	
	// 회원 삭제처리
	void delete(Long id);
	
}
