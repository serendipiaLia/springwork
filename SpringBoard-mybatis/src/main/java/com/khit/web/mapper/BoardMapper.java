package com.khit.web.mapper;

import java.util.List;
import java.util.Map;

import com.khit.web.dto.BoardDTO;

//BoardMapper.xml���� ���� ��
public interface BoardMapper {
	// �۾���
	void insert(BoardDTO boardDTO);

	// �� ��� 
	List<BoardDTO> findAll();
	
	// �� �󼼺���
	BoardDTO findById(Long id);

	// ��ȸ�� ����
	void updateHit(Long id);
	
	// �ۻ���
	void delete(Long id);
	
	// �� ���� ó��
	void update(BoardDTO boardDTO);
	
	// ������ �� �� ó��
	List<BoardDTO> pagingList(Map<String, Integer> pagingParam);
	// �ϴ� ������ ��ȣ �� ��ũ ����
	int boardCount();
	
}
