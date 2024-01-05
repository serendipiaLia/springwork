package com.khit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper; //DAO
	
	// 글 쓰기
	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}
	
	// 글 목록
	@Override
	public List<BoardDTO> findAll() {
		return boardMapper.findAll();
	}
	
	// 글 상세보기
	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}
	
	// 조회수 증가
	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
	}
	// 글 수정 처리
	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
		
	}
	
	
	int pageLimit = 10;	// 페이지 당 글 개수
	int blockLimit = 5; // 하단에 보여줄 페이지 번호 개수 
	
	// 페이지 글 개수 구현
	@Override
	public List<BoardDTO> pagingList(int page) {
		int pageStart = (page -1)* pageLimit; // 페이지 처리 시작 번호 
		
		Map<String, Integer> pagingParam = new HashMap<>();
		pagingParam.put("limit", pageLimit);
		pagingParam.put("start", pageStart);
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam); // BoardController에서는 page넘겨주고 service에서는 List, impl에서는 Map넘겨주기
		return pagingList;
	}
	// 하단 페이지 번호 별 링크 구현
	@Override
	public PageDTO pagingParam(int page) {
		// 하단에 보여줄 페이지 (번호)블럭 계산
		int totalRow = boardMapper.boardCount(); //전체 게시글 수 	
		// 전체 페이지 개수 - 올림(Math.ceil) 43/10 = 4.3 >> 실제 페이지수 5개 이므로 5.3인데 -> int로 자료형 주기 =5
			/* 1. 전체 게시글 수 / pageLimt = 4.3
			 * 2. Math.ceil함수 사용(올림) 해서 5.3 
			 * 3. Math.ceil 5.3을 정수로 바꿔줄 자료형 int로 묶기
			 * */
		int maxPage = (int)Math.ceil((double)totalRow/pageLimit); 
		
		// 하단에 보여줄 시작 페이지 값 계산 >> ex. 5개씩 보이기 (1, 6, 11, 16 ... >> 1pg 1-5까지, 2pg 6-11까지 ...) 
		int startPage = ((int)(Math.ceil(((double)page/blockLimit)))-1) * blockLimit + 1;
		// 하단에 보여줄 마지막 페이지 값 계산(1pg -> 5 / 2pg -> 10)
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		//PageDTO 객체를 생성해서 값을 세팅해 주고 반환
		PageDTO pageDTO = new PageDTO();
			pageDTO.setPage(page);
			pageDTO.setMaxPage(maxPage);
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			return pageDTO;
		
	}
	

}