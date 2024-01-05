package com.khit.web.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long id; // 댓글 번호(userid, boardid)
	private Long boardId;	// 게시글 번호
	private String replyer;
	private String replyContent;
	private Timestamp createdTime;
	private Timestamp updatedTime;
}
