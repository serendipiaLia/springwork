package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyMapper {
	
	// ��� ���� ó��
	void insert(ReplyDTO replyDTO);
	
	// ��� ��� ����
	List<ReplyDTO> getReplyList(Long boardId);

}


