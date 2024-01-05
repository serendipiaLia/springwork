package com.khit.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO { // 게시글의 하단 페이지 번호 별 링크 구현할 자료형 클래스!
	private int page; // 현재 페이지
	private int maxPage; // 최대 페이지(게시글 총 개수에 따른 페이지)
	private int startPage; // 현재 페이지 기준 시작 페이지 값
	private int endPage; // 현재 페이지 기준 마지막 페이지 값
}
