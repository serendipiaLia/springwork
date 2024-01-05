package com.khit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.UserDTO;
import com.khit.web.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insert(UserDTO userDTO) {
		userMapper.insert(userDTO);
	}

	@Override
	public List<UserDTO> findAll() {
		return userMapper.findAll();
	}

	@Override
	public UserDTO findById(Long id) {
		return userMapper.findById(id);
	}
	// 로그인 처리
	@Override
	public UserDTO login(UserDTO userDTO) {
		return userMapper.login(userDTO);
	}
	
	// 회원 정보 수정
	@Override
	public UserDTO findByUserId(String userId) {
		return userMapper.findByUserId(userId);
	}
	// 회원 정보 수정 처리
	@Override
	public void update(UserDTO userDTO) {
		userMapper.update(userDTO);
	}
	// 회원 삭제
	@Override
	public void delete(Long id) {
		userMapper.delete(id);
	}
	// 아이디 중복검사
	@Override
	public String checkUserId(String userId) {
		UserDTO user = userMapper.findByUserId(userId);
		if(user == null) { // DB에 저장된 객체가 없으면(=userId에 저장된 객체)
			return "usable"; // 사용
		}else {
			return "not_usable";
		}
		
	}
	
}
