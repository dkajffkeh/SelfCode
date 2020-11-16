package com.home.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.home.common.JDBCTemplate.*;


import com.home.common.JDBCTemplate;
import com.home.model.dao.MemberDao;
import com.home.model.vo.Member;

public class MemberService {

	private Connection dbconn;
	
public int insertMember(Member m) {
		
		// 필요한 변수 셋팅
		/*
		int result = 0;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			result = new MemberDao().insertMember(conn, m);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		// 트랜잭션 처리
		/*
		if(result > 0) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.commit();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.rollback();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		// 다쓴자원반납
		/*
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		close(conn);
		
		
		return result;
		
	}
	
	public ArrayList<Member> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	public Member selectByUserId(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectByUserId(conn, userId);
		
		close(conn);
		
		return m;
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectByUserName(conn, keyword);
		
		close(conn);
		
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}

