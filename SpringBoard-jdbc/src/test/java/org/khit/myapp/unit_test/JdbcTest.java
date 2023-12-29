package org.khit.myapp.unit_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j // �α�(���)�� ����ϴ� ���̺귯��
public class JdbcTest {
	
	@Test //main�޼��� ó�� �����
	public void testConnection() {
		
		 String className="com.mysql.cj.jdbc.Driver";
	     String url="jdbc:mysql://localhost:3306/springdb?serverTime=Asia/Seoul";
	     String username="springuser";
	     String password="pwspring";
	     
	     try {
			Class.forName(className);
			Connection conn = DriverManager.getConnection(url, username, password);
//			System.out.println("DB connected success : " + conn);
			log.info("DB connected success : " + conn);
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
