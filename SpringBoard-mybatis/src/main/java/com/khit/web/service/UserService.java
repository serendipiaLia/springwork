package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserService {

	void insert(UserDTO userDTO);

	//ȸ�� ���
	List<UserDTO> findAll();
	
	// ȸ�� �󼼺��� 
	UserDTO findById(Long id);
	
	// �α���ó��
	UserDTO login(UserDTO userDTO);
	
	// ȸ�� ���� ����
	UserDTO findByUserId(String userId);
	
	// ȸ�� ���� ���� ó��
	void update(UserDTO userDTO);
	
	// ȸ�� ���� ó�� 
	void delete(Long id);
	
	// ���̵� �ߺ��˻�
	String checkUserId(String userId);

}
