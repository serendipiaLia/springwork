package com.khit.todoweb.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class PageResponseDTO<E> { // 목록과 페이지 이동을 위한 DTO
	// <E> : 제네릭으로 만드는 이유 .. 회원정보, 게시판 객체를 페이지 처리할 수 있음
	private int page;
	private int size;
	private int total; // 총 페이지
	
	// 시작 페이지 번호
	private int startPage;
	// 마지막 페이지
	private int endPage;
	
	// 이전 페이지 존재 여부 (조건문)
	private boolean prev;
	// 있으면 다음 페이지 존재 여부
	private boolean next;
	
	// 목록 데이터 (<E> : element로 해둔 이유는 게시판이 올수도, 회원이 올수도 있으므로 )
	private List<E> dtoList;
	
	// 생성자
	@Builder(builderMethodName = "withAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		// 하단 - 1, 2, 3, 4, 5 ...
		this.endPage = (int)(Math.ceil((double)this.page/10))*10;
		this.startPage = this.endPage - 9;
		
		// total : 게시글 83개일 경우, 8.3 -> 9.3 Math.ceil 로 9
		int maxPage = (int)(Math.ceil((double)total / size));
		if(endPage > maxPage)
			endPage = maxPage;
		
		// startPage가 1보다 크면 이전페이지로 이동
		this.prev = this.startPage > 1;
		// endPage가 
		this.next = total > this.endPage * this.size;
	}
}
