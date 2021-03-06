package com.home.danawa.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static void commit(Connection conn) {

		try {
			if(conn!=null&&!conn.isClosed()) {

				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
