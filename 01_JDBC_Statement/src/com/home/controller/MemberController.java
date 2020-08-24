package com.home.controller;

import java.util.ArrayList;

import com.home.model.dao.MemberDao;
import com.home.model.vo.Member;
import com.home.view.MemberMenu;
// Controller : View 를 통해서 요청한 기능 처리하는 담당
// 데이터 가공이 여기서 이뤄져야함. 가공후 -->DAO 메소드 호출
// dao 로부터 반환받은 결과레 따라서 성공인지 실패인지에 대한 view 를 결정
public class MemberController {

	private MemberDao md = new MemberDao();
    
	/**
	 * 사용자의 회원가입 요청을 처리해 주는 메소드
	* @param m  --> 사용자가 입력한 정보들이 담겨있는 객체
	*/
	public void insetMember(Member m) {
		
		
		int result = new MemberDao().insertMember(m);
		
		if(result > 0) {
		new MemberMenu().dispalySuccess("회원가입을 축하드립니다!");	
		
		}else
		new MemberMenu().dispalyFail("잘못된 정보가 입력되었습니다.");	

	}

	public void selectList() {
		
	ArrayList<Member> list = new MemberDao().selectList();
		
	if(list.isEmpty()) {
	   new MemberMenu().displayNoData("조회결과가 없습니다.");
	}else
	   new MemberMenu().displayMemberList(list);		
	}

	public void selectByUSerId(String userId) {
		
		Member m = new MemberDao().selectByUserId(userId);
		
		if(m == null) {
			
			new MemberMenu().displayNoData("검색 결과가 없습니다.");
		
		} else {
			
			new MemberMenu().displayMember(m);
			
		}
		
	}

	public void selectByUserName(String userName) {
	
	ArrayList<Member> list = new MemberDao().selectByUserName(userName);
		
	if(list.isEmpty()) {
		   new MemberMenu().displayNoData("조회결과가 없습니다.");
		}else
		   new MemberMenu().displayMemberList(list);		
		}

	public void updateMember(Member m) {
		
	int result = new MemberDao().updateMember(m);
	
	
	if(result > 0) {
	new MemberMenu().dispalySuccess("변경성공!");	
	
	}else
	new MemberMenu().dispalyFail("회원 정보변경 실패");	

	}

	/**
	 * 회원 탈퇴요청 처리해주는 메소드
	 * @param inputMemberId
	 */
	public void deleteMember(String userId) {
		
		int result = new MemberDao().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().dispalySuccess("삭제가 완료되었습니다.");
		} else {
			new MemberMenu().dispalyFail("삭제가 중지되었습니다.");
		}
		
		
	}
	
}

	