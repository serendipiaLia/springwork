package com.khit.todoweb.service;

import java.util.List;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;

public interface TodoService {

	void insert(TodoDTO todoDTO);

	List<TodoDTO> findAll();
	// 1건 상세 보기
	TodoDTO findById(Long tno);
	
	// 수정 처리하기
	void update(TodoDTO todoDTO);
	
	// 삭제하기
	void delete(Long tno);
	
	// 페이지 목록(번호) 처리
	PageResponseDTO<TodoDTO> pagingList(PageRequestDTO pageRequestDTO);
	

}