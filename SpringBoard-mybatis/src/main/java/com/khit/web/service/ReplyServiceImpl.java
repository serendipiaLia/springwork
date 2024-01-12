package com.khit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.ReplyDTO;
import com.khit.web.mapper.ReplyMapper;

@Service // 서비스를 구현하고 bean을 등록
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper replyMapper;
	
	// 댓글 저장 처리
	@Override
	public void insert(ReplyDTO replyDTO) {
		replyMapper.insert(replyDTO);
	}
	// 댓글 목록 보기
	@Override
	public List<ReplyDTO> getReplyList(Long boardId) {
		return replyMapper.getReplyList(boardId);
	}
	// 댓글삭제
	@Override
	public void delete(Long id) {
		replyMapper.delete(id);
	}
	// 댓글 내용 가져오기
	@Override
	public ReplyDTO findById(Long id) {
		return replyMapper.findById(id);
	}
	// 댓글 수정처리(업데이트)
	@Override
	public void update(ReplyDTO replyDTO) {
		replyMapper.update(replyDTO);
		
	}

}
