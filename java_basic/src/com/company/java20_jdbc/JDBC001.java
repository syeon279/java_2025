package com.company.java20_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC001 {

	public static void main(String[] args) {
		
		//1) 드라이버로딩 com.회사명.프로젝트명.jbdc.Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2) jdbc 연동
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
			if(conn!=null) {
				System.out.println("DB 연동 성공");
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // mysql -uroot -p
	}

}
