package com.khit.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO { // �Խñ��� �ϴ� ������ ��ȣ �� ��ũ ������ �ڷ��� Ŭ����!
	private int page; // ���� ������
	private int maxPage; // �ִ� ������(�Խñ� �� ������ ���� ������)
	private int startPage; // ���� ������ ���� ���� ������ ��
	private int endPage; // ���� ������ ���� ������ ������ ��
}
