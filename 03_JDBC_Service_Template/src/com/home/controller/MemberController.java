package com.home.controller;

import java.util.ArrayList;

import com.home.model.service.MemberService;
import com.home.model.vo.Member;
import com.home.view.MemberMenu;

public class MemberController {
	
		
		public void insertMember(Member m) {
			
			int result = new MemberService().insertMember(m);
			
			if(result > 0) { // 성공뷰
				new MemberMenu().displaySuccess("회원가입 성공!");
			}else { // 실패뷰
				new MemberMenu().displayFail("회원가입 실패!");
			}
			
		}
		
		public void selectList() {
			
			ArrayList<Member> list = new MemberService().selectList();
			
			if(list.isEmpty()) { // 조회결과없음뷰
				new MemberMenu().displayNoData("전체 조회 결과 없습니다.");
			}else { // 조회결과있음뷰
				new MemberMenu().displayMemberList(list);
			}
			
		}
		
		public void selectByUserId(String userId) {
			
			Member m = new MemberService().selectByUserId(userId);
			
			if(m == null) { // 조회가 안되었을 경우 (일치하는 회원을 찾지 못했을 경우)
				new MemberMenu().displayNoData(userId + "에 해당되는 조회 결과 없습니다.");
			}else { // 조회가 되었을 경우
				new MemberMenu().displayMember(m);
			}
			
		}
		
		public void selectByUserName(String keyword) {
			ArrayList<Member> list = new MemberService().selectByUserName(keyword);
			
			if(list.isEmpty()) {
				new MemberMenu().displayNoData(keyword + "에 해당되는 조회 결과 없습니다.");
			}else {
				new MemberMenu().displayMemberList(list);
			}
		}
		
		public void updateMember(Member m) {
			int result = new MemberService().updateMember(m);
			
			if(result > 0) {
				new MemberMenu().displaySuccess("성공적으로 변경되었습니다.");
			}else {
				new MemberMenu().displayFail("회원 정보 변경에 실패하였습니다.");
			}
		}
		
		public void deleteMember(String userId) {
			int result = new MemberService().deleteMember(userId);
			
			if(result > 0) {
				new MemberMenu().displaySuccess("성공적으로 회원탈퇴되었습니다.");
			}else {
				new MemberMenu().displayFail("회원 탈퇴에 실패하였습니다.");
			}
		}
		
	}


