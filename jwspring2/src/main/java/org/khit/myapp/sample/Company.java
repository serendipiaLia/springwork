package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 매개변수 있는 생성자 (=생성자 주입, new한 것과 같음)
@ToString
@Component
public class Company {
	// 필드(객체 필드) 
	private Employee employee;
}
