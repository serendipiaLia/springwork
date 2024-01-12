package com.khit.todoweb.mapper;

import java.util.List;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

public interface TodoMapper {
	
	public String getTime(); // 현재 시간 테스트
	
	public void insert(TodoVO todoVO); // 등록하기
	
	List<TodoVO> findAll(); // 목록
	
	// 목록보기 (페이지, 검색)
	List<TodoVO> pagingList(PageRequestDTO pageRequestDTO);
	
	// 1건 상세보기 
	public TodoVO findById(Long tno);
	
	// 글 수정 처리하기
	public void update(TodoVO todoVO);
	
	//삭제하기
	public void delete(Long tno);
	
	// 페이지 목록 처리(번호)
	public int todoCount();
}