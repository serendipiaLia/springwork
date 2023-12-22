package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString ///��ü�� ������ ���ڿ��� ���
@NoArgsConstructor // �⺻������
@AllArgsConstructor // �Ű������� �ִ� ������ ( @AllArgs�� �ĵ� ����..)
@Getter
@Setter
public class UserDTO {

	//�ʵ�
	private String name;
	private int age;
	
}
