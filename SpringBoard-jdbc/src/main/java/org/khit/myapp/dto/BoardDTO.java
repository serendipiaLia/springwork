package org.khit.myapp.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor 
@ToString
@Getter
@Setter
public class BoardDTO {
	// �ʵ�
	private Long id;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Timestamp createdTime;
}
