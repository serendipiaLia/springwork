package com.khit.todoweb.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class PageResponseDTO<E> { // ��ϰ� ������ �̵��� ���� DTO
	// <E> : ���׸����� ����� ���� .. ȸ������, �Խ��� ��ü�� ������ ó���� �� ����
	private int page;
	private int size;
	private int total; // �� ������
	
	// ���� ������ ��ȣ
	private int startPage;
	// ������ ������
	private int endPage;
	
	// ���� ������ ���� ���� (���ǹ�)
	private boolean prev;
	// ������ ���� ������ ���� ����
	private boolean next;
	
	// ��� ������ (<E> : element�� �ص� ������ �Խ����� �ü���, ȸ���� �ü��� �����Ƿ� )
	private List<E> dtoList;
	
	// ������
	@Builder(builderMethodName = "withAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		// �ϴ� - 1, 2, 3, 4, 5 ...
		this.endPage = (int)(Math.ceil((double)this.page/10))*10;
		this.startPage = this.endPage - 9;
		
		// total : �Խñ� 83���� ���, 8.3 -> 9.3 Math.ceil �� 9
		int maxPage = (int)(Math.ceil((double)total / size));
		if(endPage > maxPage)
			endPage = maxPage;
		
		// startPage�� 1���� ũ�� ������������ �̵�
		this.prev = this.startPage > 1;
		// endPage�� 
		this.next = total > this.endPage * this.size;
	}
}
