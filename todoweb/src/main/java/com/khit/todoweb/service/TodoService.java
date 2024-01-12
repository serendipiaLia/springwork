package com.khit.todoweb.service;

import java.util.List;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;

public interface TodoService {

	void insert(TodoDTO todoDTO);

	List<TodoDTO> findAll();
	// 1�� �� ����
	TodoDTO findById(Long tno);
	
	// ���� ó���ϱ�
	void update(TodoDTO todoDTO);
	
	// �����ϱ�
	void delete(Long tno);
	
	// ������ ���(��ȣ) ó��
	PageResponseDTO<TodoDTO> pagingList(PageRequestDTO pageRequestDTO);
	

}