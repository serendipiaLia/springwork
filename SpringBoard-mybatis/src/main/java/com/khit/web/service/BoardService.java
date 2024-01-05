package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;

public interface BoardService {
	// 글 쓰기
	void insert(BoardDTO boardDTO);
	
	// 글 목록
	List<BoardDTO> findAll();
	
	// 글 상세보기 
	BoardDTO findById(Long id);
	
	// 조회수 증가
	void updateHit(Long id);
	
	// 글 삭제
	void delete(Long id);
	
	// 글 수정 처리
	void update(BoardDTO boardDTO);
	
	// 페이지 글 개수 구현
	List<BoardDTO> pagingList(int page);
	// 하단 페이지 번호 별 링크 구현
	PageDTO pagingParam(int page);

}
