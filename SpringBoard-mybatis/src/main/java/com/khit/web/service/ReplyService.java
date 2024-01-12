package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyService {
	
	// ��� ���� ó��
	void insert(ReplyDTO replyDTO);
	
	// ��� ��� ����Ʈ�� �ҷ�����
	List<ReplyDTO> getReplyList(Long boardId);
	
	// ��� ����
	void delete(Long id);
	
	// ��� ���� ��������(����)
	ReplyDTO findById(Long id);
	// ��� ���� ó��(������Ʈ) 
	void update(ReplyDTO replyDTO);
}
