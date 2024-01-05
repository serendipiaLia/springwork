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
	// �α��� ó��
	@Override
	public UserDTO login(UserDTO userDTO) {
		return userMapper.login(userDTO);
	}
	
	// ȸ�� ���� ����
	@Override
	public UserDTO findByUserId(String userId) {
		return userMapper.findByUserId(userId);
	}
	// ȸ�� ���� ���� ó��
	@Override
	public void update(UserDTO userDTO) {
		userMapper.update(userDTO);
	}
	// ȸ�� ����
	@Override
	public void delete(Long id) {
		userMapper.delete(id);
	}
	// ���̵� �ߺ��˻�
	@Override
	public String checkUserId(String userId) {
		UserDTO user = userMapper.findByUserId(userId);
		if(user == null) { // DB�� ����� ��ü�� ������(=userId�� ����� ��ü)
			return "usable"; // ���
		}else {
			return "not_usable";
		}
		
	}
	
}
