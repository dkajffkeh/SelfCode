package com.home.danawa.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import static com.home.danawa.model.dao.JDBCTemplate.*;
import static com.home.danawa.model.dao.DBConnector.*;

import com.home.danawa.model.vo.Member;

public class MemberDao {

	Properties prop = new Properties();

	public MemberDao() {

		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public int insertMember(Member m) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;	

		conn = getConnection();

		try {

			pstmt = conn.prepareStatement(prop.getProperty("insertMember"));

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserSSN());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getBirth());
			pstmt.setString(7, m.getUserEmail());
			pstmt.setString(8, m.getUserNickName());
			pstmt.setString(9, m.getUserPhone());
			pstmt.setString(10, m.getUserAddress());

			result = pstmt.executeUpdate();

			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		close(pstmt);	    
		close(conn);


		return result;

	}

	public List<Member> scanMember() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Member> list = new ArrayList<>();


		conn = getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("scanMember"));

			while(rs.next()) {

				Member m = new Member();
				m.setUserNo(rs.getInt("USERNO"));	
				m.setUserId(rs.getString("USERID"));
				m.setUserPwd(rs.getString("USERPWD"));
				m.setUserName(rs.getString("USERNAME"));
				m.setUserSSN(rs.getString("USERSSN"));
				m.setGender(rs.getString("GENDER"));
				m.setBirth(rs.getString("B_DAY"));
				m.setUserEmail(rs.getString("USERMAIL"));
				m.setUserNickName(rs.getString("USERN_NAME"));
				m.setUserPhone(rs.getString("USERPHONE"));
				m.setUserAddress(rs.getString("USERADDRESS"));
				m.setEnrollDate(rs.getDate("ENROLLDATE"));

				list.add(m);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		close(rs);
		close(stmt);	    
		close(conn);

		return list;
	}

	public boolean idInspector(String string) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("idInspector"));
			rs = pstmt.executeQuery();

			while(rs.next()) {

				if(string.equals(rs.getString("USERID"))) {
					return true;
				};						

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} 

		close(rs);
		close(pstmt);	    
		close(conn);

		return false;

	}

	public boolean nickInspector(String string) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;



		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("nickInspector"));
			rs = pstmt.executeQuery();


			while(rs.next()) {

				if(string.equals(rs.getString("USERN_NAME"))) {
					return true;
				};						

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		close(rs);
		close(pstmt);	    
		close(conn);    

		return false;		
	}

	public String searchMember(String name, String ssn) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String id = null;

		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchMember"));
			pstmt.setString(1, name);
			pstmt.setString(2, ssn);			
			rs = pstmt.executeQuery();

			while(rs.next()) {

				if(name.equals(rs.getString("USERNAME"))&&ssn.contentEquals(rs.getString("USERSSN"))) {

					id = rs.getString("USERID");
					break;					
				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}  

		close(rs);
		close(pstmt);	    
		close(conn);

		return id;
	}

	public boolean idPwdCheck(String id, String pwd) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnector.getConnection();


		try {
			pstmt = conn.prepareStatement(prop.getProperty("idPwdCheck"));
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				if(id.equals(rs.getString("USERID"))&&pwd.equals(rs.getString("USERPWD"))) {
					return false;
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} 

		close(rs);
		close(pstmt);	    
		close(conn);	    

		return true;

	}

	public Member mofifyAccount(int num, String id, String pwd, String str) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;

		int result = 0;

		String select = "";

		switch(num) {

		case 1 : select += "SET USERN_NAME = ?" ; break;
		case 2 : select += "SET USERADDRESS = ?"; break;

		}

		String sql = "UPDATE MEMBER   "
				+   select
				+   " WHERE USERID =? "
				+   " AND USERPWD  =? ";

		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, str);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);

			result = pstmt.executeUpdate();

			if(result>0) {			
				conn.commit();

				String sql2 = "SELECT * FROM MEMBER WHERE USERID= ?";
				pstmt = conn.prepareStatement(sql2);

				pstmt.setString(1, id);

				rs = pstmt.executeQuery();
				while(rs.next()) {

					m = new Member();

					m.setUserNo(rs.getInt("USERNO"));	
					m.setUserId(rs.getString("USERID"));
					m.setUserPwd(rs.getString("USERPWD"));
					m.setUserName(rs.getString("USERNAME"));
					m.setUserSSN(rs.getString("USERSSN"));
					m.setGender(rs.getString("GENDER"));
					m.setBirth(rs.getString("B_DAY"));
					m.setUserEmail(rs.getString("USERMAIL"));
					m.setUserNickName(rs.getString("USERN_NAME"));
					m.setUserPhone(rs.getString("USERPHONE"));
					m.setUserAddress(rs.getString("USERADDRESS"));
					m.setEnrollDate(rs.getDate("ENROLLDATE"));

				}

			} else {
				conn.rollback();
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		close(rs);
		close(pstmt);	    
		close(conn);

		return m;

	}


}
