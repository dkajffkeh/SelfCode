package com.home.danawa.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	private Connection dbconn;
	
	public static Connection getConnection() {
		
		Connection conn = null;
				
		String id = "DANAWA";
		String pwd= "DANAWA";
		String url= "jdbc:oracle:thin:@localhost:1521:xe"; 
				
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
