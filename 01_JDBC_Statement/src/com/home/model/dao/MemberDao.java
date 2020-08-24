package com.home.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.home.model.vo.Member;

public class MemberDao {	
	/**
	 * 사용자가 입력한 값들로 insert문 실행하는 메소드.
	 * @param m --> 사용자가 입력한 값들이 담겨있는 Member 객체
	 */
	public int insertMember(Member m) {	
				
		Connection conn = null;
		Statement stmt = null;
		int result = 0 ; // --> 처리된 결과(처리된 행 수) 를 받아줄 변수
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, "
				                              + "'" + m.getUserId()  + "',"
				                              + "'" + m.getUserPwd() + "',"
				                              + "'" + m.getUserName()+ "',"
				                              + "'" + m.getGender()  + "',"
				                              +       m.getAge()     + " ,"
				                              + "'" + m.getEmail()   + "',"
				                              + "'" + m.getPhone()   + "',"
				                              + "'" + m.getAddress() + "',"
				                              + "'" + m.getHobby()   + "',SYSDATE)";
		
		//실행할 sql 문 완성형태로 만들어주어야함.		
		try {
		conn = DBConnection.getConnection();
			//3) Statement 객체 생성
			stmt = conn.createStatement();
			//4) sql 문 실행
            result = stmt.executeUpdate(sql);	
            
            if(result>0) {
    			conn.commit();   			
    		} else {
    			conn.rollback();  			
    		}
            		
		} // 2) 
          catch (SQLException e) {
			e.printStackTrace();
		}finally {
			 try {			
				 if ( stmt != null ){stmt.close();}   
                 if ( conn != null ){conn.close();}
			 } catch(Exception e){
	                throw new RuntimeException(e.getMessage());
	         }
						
		}		
		return result;
	}

	public ArrayList<Member> selectList() {
	
    ArrayList<Member> list = new ArrayList<>();
		
	Connection conn = null; //DB연결
	Statement stmt = null;  //SQL문 실행 및 결과를 받아냄
	ResultSet rs = null;    //실행시 실행결과를  실질적으로 담길 객체
	
	String sql = "SELECT * FROM MEMBER ";
	
	try {
		
		conn = DBConnection.getConnection();
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			Member m = new Member();
			
		    m.setUserNo(rs.getInt(1));
			m.setUserId(rs.getString("USERID"));			
			m.setUserPwd(rs.getString("USERPWD"));
			m.setUserName(rs.getString("USERNAME"));
			m.setGender(rs.getString("GENDER"));
			m.setAge(rs.getInt("AGE"));
			m.setEmail(rs.getString("EMAIL"));
			m.setPhone(rs.getString("PHONE"));
			m.setAddress(rs.getString("ADDRESS"));
			m.setHobby(rs.getString("HOBBY"));
			m.setEnrollDate(rs.getDate("ENROLLDATE"));
			
			list.add(m);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	return list;
	
	}

	public Member selectByUserId(String userId) {
		
		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = "+"'"+ userId + "'";
		conn = DBConnection.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				m = new Member(
						rs.getInt(1),
						rs.getString("USERID"),			
						rs.getString("USERPWD"),
						rs.getString("USERNAME"),
						rs.getString("GENDER"),
						rs.getInt("AGE"),
						rs.getString("EMAIL"),
						rs.getString("PHONE"),
						rs.getString("ADDRESS"),
						rs.getString("HOBBY"),
						rs.getDate("ENROLLDATE")					
						      );				
			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			try {
				
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
 
				e.printStackTrace();
			}
						
		}
		
		return m;
	}

	public ArrayList<Member> selectByUserName(String userName) {
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet    rs = null;
		
		ArrayList<Member> list = new ArrayList<>();
		
		conn = DBConnection.getConnection();
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%"+userName+"%'";
	
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				list.add(new Member(						
								rs.getInt(1),
								rs.getString("USERID"),			
								rs.getString("USERPWD"),
								rs.getString("USERNAME"),
								rs.getString("GENDER"),
								rs.getInt("AGE"),
								rs.getString("EMAIL"),
								rs.getString("PHONE"),
								rs.getString("ADDRESS"),
								rs.getString("HOBBY"),
								rs.getDate("ENROLLDATE")					
								      ));					
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
						
		}
				
		return list;		
	}

	/**
	 * 사용자 정보 변경 요청을 처리해주는 메소드
	 * 
	 *
	 * @param m
	 */
	public int updateMember(Member m) {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
		
    int result = 0 ;
    
    String sql = "UPDATE MEMBER "
    		+ "SET USERPWD = '" + m.getUserPwd()+"'," 
            + "EMAIL       = '" + m.getEmail()  +"',"
            + "PHONE       = '" + m.getPhone()  +"',"
            + "ADDRESS     = '" + m.getAddress()+"'"
            + "WHERE USERID= '" + m.getUserId() +"'";
            	
    conn = DBConnection.getConnection();
    
    try {
		
    	stmt = conn.createStatement();
        result = stmt.executeUpdate(sql);
        
        if(result>0) {
        	conn.commit();
        } else {
        	conn.rollback();
        }
        
	
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
    } finally {
      	
    	try {
			
		stmt.close();
		conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   	
    }
    
    return result; 

	}

	public int deleteMember(String userId) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
	String sql = "DELETE FROM MEMBER " 
			   + "WHERE USERID = '"+userId+"'";
	
	System.out.println(sql);
	
	try {
		
		conn = DBConnection.getConnection();
		stmt = conn.createStatement();
		result = stmt.executeUpdate(sql);
		
		if(result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
	}
	return result;
		
		
	}
	
}
