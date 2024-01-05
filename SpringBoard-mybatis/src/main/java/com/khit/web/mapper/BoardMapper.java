package com.khit.web.mapper;

import java.util.List;
import java.util.Map;

import com.khit.web.dto.BoardDTO;

//BoardMapper.xml에서 구현 됨
public interface BoardMapper {
	// 글쓰기
	void insert(BoardDTO boardDTO);

	// 글 목록 
	List<BoardDTO> findAll();
	
	// 글 상세보기
	BoardDTO findById(Long id);

	// 조회수 증가
	void updateHit(Long id);
	
	// 글삭제
	void delete(Long id);
	
	// 글 수정 처리
	void update(BoardDTO boardDTO);
	
	// 페이지 글 수 처리
	List<BoardDTO> pagingList(Map<String, Integer> pagingParam);
	// 하단 페이지 번호 별 링크 구현
	int boardCount();
	
}
