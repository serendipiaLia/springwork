package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyService {
	
	// 댓글 저장 처리
	void insert(ReplyDTO replyDTO);
	
	// 댓글 목록 리스트로 불러오기
	List<ReplyDTO> getReplyList(Long boardId);
}
