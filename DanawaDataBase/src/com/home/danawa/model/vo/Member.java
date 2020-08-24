package com.home.danawa.model.vo;

import java.sql.Date;

public class Member {
	
//USER 에게 직접 입력받아야하는 컬럼
 private int    userNo;
 private String userId;
 private String userPwd;
 private String userName;
 private String userSSN;
 private String gender;
 private String birth;
 private String userEmail;
 private String userNickName;
 private String userPhone;
 private String userAddress;
 private Date   enrollDate;
 
 public Member() {}

public Member(int userNo
		, String userId 
		, String userPwd 
		, String userName 
		, String userSSN 
		, String gender
		, String birth
		, String userEmail
		, String userNickName
		, String userPhone
		, String userAddress
		, Date enrollDate) 	
{	
	this.userNo       = userNo;
	this.userId       = userId;
	this.userPwd      = userPwd;
	this.userName     = userName;
	this.userSSN      = userSSN;
	this.gender       = gender;
	this.birth        = birth;
	this.userEmail    = userEmail;
	this.userNickName = userNickName;
	this.userPhone    = userPhone;
	this.userAddress  = userAddress;
	this.enrollDate   = enrollDate;
}
//java 에서 처리해야 하는 변수.
public Member(String userId 
		    , String userPwd 
		    , String userName 
		    , String userSSN 
		    , String gender 
		    , String birth 
		    , String userEmail 
		    , String userNickName 
		    , String userPhone 
		    , String userAddress 
		    )
{	
	this.userId       = userId;
	this.userPwd      = userPwd;
	this.userName     = userName;
	this.userSSN      = userSSN;
	this.gender       = gender;
	this.birth        = birth;
	this.userEmail    = userEmail;
	this.userNickName = userNickName;
	this.userPhone    = userPhone;
	this.userAddress  = userAddress;
	
}


public int getUserNo() {
	return userNo;
}


public void setUserNo(int userNo) {
	this.userNo = userNo;
}



public String getUserId() {
	return userId;
}



public void setUserId(String userId) {
	this.userId = userId;
}



public String getUserPwd() {
	return userPwd;
}



public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}



public String getUserName() {
	return userName;
}



public void setUserName(String userName) {
	this.userName = userName;
}



public String getUserSSN() {
	return userSSN;
}



public void setUserSSN(String userSSN) {
	this.userSSN = userSSN;
}



public String getGender() {
	return gender;
}



public void setGender(String gender) {
	this.gender = gender;
}



public String getBirth() {
	return birth;
}



public void setBirth(String birth) {
	this.birth = birth;
}



public String getUserEmail() {
	return userEmail;
}



public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}



public String getUserNickName() {
	return userNickName;
}



public void setUserNickName(String userNickName) {
	this.userNickName = userNickName;
}



public String getUserPhone() {
	return userPhone;
}



public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}



public String getUserAddress() {
	return userAddress;
}



public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}



public Date getEnrollDate() {
	return enrollDate;
}



public void setEnrollDate(Date enrollDate) {
	this.enrollDate = enrollDate;
}



@Override
public String toString() {
	
	String str = String.format("========%s========\n"
			                 + "아이디      :%s\n"
			                 + "이름         :%s\n"
			                 + "닉네임      :%s\n"
			                 + "성별         :%s\n"
			                 + "이메일      :%s\n"
			                 + "핸드폰번호 :%s\n"
			                 + "주소         :%s\n"
			                 + "가입일      :%s\n" 
			                                  ,userNo 
			                                  ,userId
			                                  ,userName
			                                  ,userNickName
			                                  ,gender
			                                  ,userEmail
			                                  ,userPhone
			                                  ,userAddress
			                                  ,enrollDate);
	return  str;
	
}
 

}
 
 