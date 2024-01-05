package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.ReplyDTO;

public interface ReplyMapper {
	
	// ´ñ±Û ÀúÀå Ã³¸®
	void insert(ReplyDTO replyDTO);
	
	// ´ñ±Û ¸ñ·Ï º¸±â
	List<ReplyDTO> getReplyList(Long boardId);

}


