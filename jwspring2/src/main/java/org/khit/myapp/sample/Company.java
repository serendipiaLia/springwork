package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // �Ű����� �ִ� ������ (=������ ����, new�� �Ͱ� ����)
@ToString
@Component
public class Company {
	// �ʵ�(��ü �ʵ�) 
	private Employee employee;
}
