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
	
	private Connection conn = getConnection();
	
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
		
		int result = new MemberDao().insertMember(this.conn, m);
		
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
			commit(this.conn);
		}else {
			rollback(this.conn);
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
		close(this.conn);
		
		
		return result;
		
	}
	
	public ArrayList<Member> selectList() {
		
		
		ArrayList<Member> list = new MemberDao().selectList(this.conn);
		
		close(this.conn);
		
		return list;
		
	}
	
	public Member selectByUserId(String userId) {
		
		
		Member m = new MemberDao().selectByUserId(this.conn, userId);
		
		close(this.conn);
		
		return m;
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		
		
		ArrayList<Member> list = new MemberDao().selectByUserName(this.conn, keyword);
		
		close(this.conn);
		
		return list;
	}
	
	public int updateMember(Member m) {
		
		
		int result = new MemberDao().updateMember(this.conn, m);
		
		if(result > 0) {
			commit(this.conn);
		}else {
			rollback(this.conn);
		}
		
		close(this.conn);
		
		return result;
	}
	
	public int deleteMember(String userId) {
		
		
		int result = new MemberDao().deleteMember(this.conn, userId);
		
		if(result > 0) {
			commit(this.conn);
		}else {
			rollback(this.conn);
		}
		
		close(this.conn);
		
		return result;
	}

	public String loginMember(String id, String pwd) {
		
	String name = new MemberDao().loginMember(id,pwd,this.conn);
		
	close(this.conn);
	
		return name;
		
		
		
		
	}

}

