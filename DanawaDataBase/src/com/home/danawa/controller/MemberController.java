package com.home.danawa.controller;

import java.util.ArrayList;
import java.util.List;

import com.home.danawa.model.dao.MemberDao;
import com.home.danawa.model.vo.Member;
import com.home.danawa.view.MemberMenu;

public class MemberController {

	
	public void insertMember(Member m) {
		
		int result = new MemberDao().insertMember(m);
		
		if(result>0) {
			new MemberMenu().displaySuccess("회원가입이 성공적으로 완료되었습니다!");
			System.out.println(m);
			
		} else {
			new MemberMenu().displayFail("가입처리가 정상 완료되지 않았습니다.");
		}
	}

	public void scanMember() {
		
		List<Member> list = new ArrayList<>();
		
	 	list = new MemberDao().scanMember();
	 	
	 	if(list.isEmpty()) {
	 		new MemberMenu().displaySuccess("조회 결과가 없습니다.");
	 	} else {
	 		new MemberMenu().disPlayMember(list);
	 	}
		
	}

	public void searchMember(String name, String ssn) {
		
		
	String id = new MemberDao().searchMember(name,ssn);
     
	if(id!=null) {
		new MemberMenu().displaySuccess("회원님의 아이디는 " + id +" 입니다.");
	} else {
		new MemberMenu().displayFail("등록되어있지 않습니다.");
	}
		
	}

	public boolean idPwdCheck(String id, String pwd) {
	 
	boolean b = new MemberDao().idPwdCheck(id,pwd);
	 
	return b;	
	}
	
	public void modifyAccount(int num , String id , String pwd , String str) {
		
		Member m = new MemberDao().mofifyAccount(num,id,pwd,str);
		
		if(m==null) {
			new MemberMenu().displayFail("변경이 정상적으로 이루어지지 않았습니다.");
		}else {
			new MemberMenu().displayResult(m);
		}
		
		
	}

}
