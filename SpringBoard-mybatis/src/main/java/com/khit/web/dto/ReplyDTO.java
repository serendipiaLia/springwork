package com.khit.web.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long id; // ��� ��ȣ(userid, boardid)
	private Long boardId;	// �Խñ� ��ȣ
	private String replyer;
	private String replyContent;
	private Timestamp createdTime;
	private Timestamp updatedTime;
}
