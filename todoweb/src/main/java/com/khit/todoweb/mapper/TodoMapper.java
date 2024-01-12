package com.khit.todoweb.mapper;

import java.util.List;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

public interface TodoMapper {
	
	public String getTime(); // ���� �ð� �׽�Ʈ
	
	public void insert(TodoVO todoVO); // ����ϱ�
	
	List<TodoVO> findAll(); // ���
	
	// ��Ϻ��� (������, �˻�)
	List<TodoVO> pagingList(PageRequestDTO pageRequestDTO);
	
	// 1�� �󼼺��� 
	public TodoVO findById(Long tno);
	
	// �� ���� ó���ϱ�
	public void update(TodoVO todoVO);
	
	//�����ϱ�
	public void delete(Long tno);
	
	// ������ ��� ó��(��ȣ)
	public int todoCount();
}