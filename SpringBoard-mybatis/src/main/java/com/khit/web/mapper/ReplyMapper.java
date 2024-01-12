package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyMapper {
	
	// ��� ���� ó��
	void insert(ReplyDTO replyDTO);
	
	// ��� ��� ����
	List<ReplyDTO> getReplyList(Long boardId);
	
	// ��� ����
	void delete(Long id);
	
	// ��� ���� ��������
	ReplyDTO findById(Long id);
	
	// ��� ���� ó��(������Ʈ)
	void update(ReplyDTO replyDTO);

}


