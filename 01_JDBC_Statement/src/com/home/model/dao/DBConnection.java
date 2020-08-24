package com.home.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn;
	
	public static Connection getConnection() {
		
	Connection conn = null;	
		
	String id = "JDBC";
	String pwd = "JDBC";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return conn;
	
	}
	
}
