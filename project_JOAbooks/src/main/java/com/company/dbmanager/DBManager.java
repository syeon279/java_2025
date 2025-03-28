package com.company.dbmanager;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection conn;
	
	public DBManager( ) {
		super();
	}
	
	public Connection getConnection() {
		try {
			Context initContext = new InitialContext(); // Context 찾겠다 Resource
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); // 환경 Context
			DataSource ds = (DataSource)envContext.lookup("jdbc/mbasic"); // pool 이동
			conn = ds.getConnection(); // db연동
			System.out.println("............시작" + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
