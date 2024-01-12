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
public class PageRequestDTO { // �Ķ���� ������ DTO
	
	private int page = 1;
	private int size = 10; //������ �� �Խñ� ��
	
	private String[] types; // �˻� ���� 
	private String keyword;	// �˻���
	
	// 1pg 1������ , 2pg 11������, 3pg 21�� ���� �������� skip - ����(����)
	public int getSkip() { // == #{skip} >> mybatis����...
		return (page -1) * 10; // 1pg : 0 / 2pg : 10
	}
	
	// �˻�����(t, w) üũ�ڽ� 
	public boolean checkType(String type) {
		// type�� üũ�� ������ ��ȯ���� ����
		if(types == null || types.length == 0) {
			return false;
		}
		// type�� ��ġ�ϴ� ������ ��ȯ
		return Arrays.stream(types).anyMatch(type::equals); 
	}
}
