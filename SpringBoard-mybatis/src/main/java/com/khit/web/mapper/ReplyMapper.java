package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyMapper {
	
	// 댓글 저장 처리
	void insert(ReplyDTO replyDTO);
	
	// 댓글 목록 보기
	List<ReplyDTO> getReplyList(Long boardId);
	
	// 댓글 삭제
	void delete(Long id);
	
	// 댓글 내용 가져오기
	ReplyDTO findById(Long id);
	
	// 댓글 수정 처리(업데이트)
	void update(ReplyDTO replyDTO);

}


