package com.khit.web.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {

	private Long id;
	private String boardTitle;
	private String userId; // boardWriter ���.. 
	private String boardContent;
	private Integer hit;
	private Timestamp createdTime;
	private Timestamp updatedTime;
}
