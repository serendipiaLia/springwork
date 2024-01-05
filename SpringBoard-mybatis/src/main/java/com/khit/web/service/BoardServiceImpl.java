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
	
	// �� ����
	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}
	
	// �� ���
	@Override
	public List<BoardDTO> findAll() {
		return boardMapper.findAll();
	}
	
	// �� �󼼺���
	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}
	
	// ��ȸ�� ����
	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
	}
	// �� ���� ó��
	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
		
	}
	
	
	int pageLimit = 10;	// ������ �� �� ����
	int blockLimit = 5; // �ϴܿ� ������ ������ ��ȣ ���� 
	
	// ������ �� ���� ����
	@Override
	public List<BoardDTO> pagingList(int page) {
		int pageStart = (page -1)* pageLimit; // ������ ó�� ���� ��ȣ 
		
		Map<String, Integer> pagingParam = new HashMap<>();
		pagingParam.put("limit", pageLimit);
		pagingParam.put("start", pageStart);
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam); // BoardController������ page�Ѱ��ְ� service������ List, impl������ Map�Ѱ��ֱ�
		return pagingList;
	}
	// �ϴ� ������ ��ȣ �� ��ũ ����
	@Override
	public PageDTO pagingParam(int page) {
		// �ϴܿ� ������ ������ (��ȣ)�� ���
		int totalRow = boardMapper.boardCount(); //��ü �Խñ� �� 	
		// ��ü ������ ���� - �ø�(Math.ceil) 43/10 = 4.3 >> ���� �������� 5�� �̹Ƿ� 5.3�ε� -> int�� �ڷ��� �ֱ� =5
			/* 1. ��ü �Խñ� �� / pageLimt = 4.3
			 * 2. Math.ceil�Լ� ���(�ø�) �ؼ� 5.3 
			 * 3. Math.ceil 5.3�� ������ �ٲ��� �ڷ��� int�� ����
			 * */
		int maxPage = (int)Math.ceil((double)totalRow/pageLimit); 
		
		// �ϴܿ� ������ ���� ������ �� ��� >> ex. 5���� ���̱� (1, 6, 11, 16 ... >> 1pg 1-5����, 2pg 6-11���� ...) 
		int startPage = ((int)(Math.ceil(((double)page/blockLimit)))-1) * blockLimit + 1;
		// �ϴܿ� ������ ������ ������ �� ���(1pg -> 5 / 2pg -> 10)
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		//PageDTO ��ü�� �����ؼ� ���� ������ �ְ� ��ȯ
		PageDTO pageDTO = new PageDTO();
			pageDTO.setPage(page);
			pageDTO.setMaxPage(maxPage);
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			return pageDTO;
		
	}
	

}