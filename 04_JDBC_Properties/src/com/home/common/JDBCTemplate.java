package com.home.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCTemplate {

	
	//Singleton
	public static Connection getConnection() {
	
		Properties prop = new Properties();
		
		try {
				prop.load(new FileReader("resources/Driver.properties"));
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		Connection conn = null;

			try {
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url")
						                          ,prop.getProperty("username")
						                          ,prop.getProperty("password"));
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
					
		
		return conn;
		
	}
	
	public static void commit(Connection conn) {
		
		try {
		if(conn!=null&&!conn.isClosed()) {
			
				conn.commit();
		 }
		} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
    public static void rollback(Connection conn) {
    	
    	try {
			if(conn!= null && !conn.isClosed()) {
				
				conn.rollback();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	    	
    	
    }
    
    public static void close(Connection conn) {
    	
    	
    	try {
			if(conn!=null&&!conn.isClosed()) {
				
				conn.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
    }
    
    public static void close(Statement stmt) {
    	
    	try {
			if(stmt!=null&&!stmt.isClosed()) {
				
				stmt.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    public static void close(ResultSet rs) {
    	
    	try {
			if(rs!=null&&!rs.isClosed()) {
				
				rs.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    }

}
