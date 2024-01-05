package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserMapper {

	void insert(UserDTO userDTO);
	// ȸ�� ���
	List<UserDTO> findAll();
	
	// ȸ�� �󼼺���
	UserDTO findById(Long id);
	
	//�α��� ó��
	UserDTO login(UserDTO userDTO);
	
	// ȸ�� ���� ����
	UserDTO findByUserId(String userId);
	
	// ȸ�� ���� ���� ó��
	void update(UserDTO userDTO); // void�� ��ȯ���� ���� xml���� resultType ���صε�
	
	// ȸ�� ����ó��
	void delete(Long id);
	
}
