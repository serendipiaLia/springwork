package com.khit.todoweb.dto;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO { // 파라미터 수집용 DTO
	
	private int page = 1;
	private int size = 10; //페이지 당 게시글 수
	
	private String[] types; // 검색 유형 
	private String keyword;	// 검색어
	
	// 1pg 1번부터 , 2pg 11번부터, 3pg 21번 부터 나오도록 skip - 간격(범위)
	public int getSkip() { // == #{skip} >> mybatis에서...
		return (page -1) * 10; // 1pg : 0 / 2pg : 10
	}
	
	// 검색유형(t, w) 체크박스 
	public boolean checkType(String type) {
		// type에 체크가 없으면 반환값이 없음
		if(types == null || types.length == 0) {
			return false;
		}
		// type에 일치하는 유형을 반환
		return Arrays.stream(types).anyMatch(type::equals); 
	}
}
