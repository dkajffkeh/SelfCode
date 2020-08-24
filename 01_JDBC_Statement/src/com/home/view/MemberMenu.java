package com.home.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.home.controller.MemberController;
import com.home.model.vo.Member;

public class MemberMenu {

	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);
	
	/**  --> Alt+Shift+J
	 * 사용자가 보게될 첫 화면
	 */
	public void mainMenu() {
	
		int menu;
		
		while(true) {
			
			System.out.println("\n=====회원 관리 프로그램=====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
		    System.out.print("번호선택 : ");
		    
		    menu = sc.nextInt();
		    sc.nextLine();
		
		switch(menu) {
		
		 case 1 : insertMember();  break;
		 case 2 : mc.selectList(); break;
		 case 3 : String userId = inputMemberId(); 
		         mc.selectByUSerId(userId);
	     		break;
	     		
	   	 case 4 : String userName = inputMemberName(); 
		         mc.selectByUserName(userName);
	        	break;
	        	
		 case 5 : updateMember(); break;
		 case 6 : mc.deleteMember(inputMemberId()); break;
		 case 0 : System.out.println("프로그램을 종료합니다."); return;
	    default : System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				
		}			
		} 
	}
	

	public void insertMember()
	{
		System.out.println("=====회원가입=====");
		
		System.out.print("아이디 :");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 :");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 :");
		String userName = sc.nextLine();
		
		System.out.print("성별 ('M'/'F') :");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 :");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이메일 :");
		String email = sc.nextLine();
		
		System.out.print("전화번호 (- 제외):");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미 (,로 공백없이 나열) : ");
		String hobby = sc.nextLine();
		
		//Controller 회원가입 요청.
        	
	Member m = new Member(userId,userPwd,userName,gender,age,email,phone,address,hobby);
	mc.insetMember(m);
	
	}
	
	/** 사용자의 아이디를 리턴함.
	 * @return
	 */
	private String inputMemberId() {
				
		System.out.print("아이디를 입력해주세요:");
		return sc.nextLine();

    }
	
	private String inputMemberName() {
		
		System.out.print("이름을 입력해주세요:");
		return sc.nextLine();
	}
	
	
	/**
	 * @param 사용자가 요청한 결과를 보게되는 메소드
	 */	
	public void dispalySuccess(String message) {
		
		System.out.println(message);
						
	}

	public void dispalyFail(String message) {
		System.out.println(message);
		
	}


	public void displayNoData(String message) {
		System.out.println(message);
		
	}
	/**
	 * @param 조회 결과 출력
	 */
	public void displayMemberList(ArrayList<Member> list) {
		
		System.out.println("\n조회된 데이터는 다름과같습니다.\n");
		
		for(int i = 0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}

	public void displayMember(Member m) {
		
		System.out.println(m);		
		
	}
	

	/**
	 * 사용자에게 변경할 정보들 (비밀번호 ,이메일,전화번호,주소)
	 * 해당 회원의 아이디 입력받는 장면.
	 */
	private void updateMember() {
		
		System.out.println("\n===회원 정보 변경===");
		
		Member m = new Member();
		m.setUserId(inputMemberId()); // 해당회원 아이디 담기
        
		System.out.print("변경할 암호: ");
		m.setUserPwd(sc.nextLine());
		
		System.out.print("변경할 이메일: ");
		m.setEmail(sc.nextLine());
		
		System.out.print("변경할 전화번호 (-제외) : ");
		m.setPhone(sc.nextLine());
		
		System.out.print("변경할 주소: ");
		m.setAddress(sc.nextLine());
		
	//m 에는 아이디 담겨있고 
		
		mc.updateMember(m);
		
	}
	
}
