package com.khit.web.service;

import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper boardMapper;
	
	//±Û¾²±â
	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

}
