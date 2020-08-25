package com.home.danawa.view;


import java.util.List;
import java.util.Scanner;

import com.home.danawa.controller.GenderBirthConvert;
import com.home.danawa.controller.MemberController;
import com.home.danawa.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private DanawaException de = new DanawaException();
	private GenderBirthConvert gbc = new GenderBirthConvert();
	private MemberController mc = new MemberController();
	private String id,pwd,pwd2,name,ssn,email,nick,phone;
	/**
	 * 사용자가 보게될 첫 화면.
	 */
	public void mainMenu() {
        
		int menu;
		
		while(true) {
			
			System.out.println("\n=====회원 관리 프로그램=====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
		    System.out.print("번호선택 : ");
		    
		    menu = sc.nextInt();
		    sc.nextLine();
		
		switch(menu) {
		
		case 1 : insertMember();    break;
		case 2 : mc.scanMember();   break;
		case 3 : 
			System.out.print("이름을 입력해주세요:");
			     String name = sc.nextLine();	
			System.out.println("주민등록번호를 입력해주세요:");     
		         String ssn  = sc.nextLine();
			  mc.searchMember(name,ssn);
			  break;
		case 4 : break;
		case 5 : modifyAccount();
			 
			break;
		case 6 : break;
		case 0 : return;
		default: System.out.println("잘못 입력하셨습니다."); 				
		}
		
     }

  }
	
	public void insertMember() {
				
		boolean check = false;		
				
		System.out.println("=====다나와 회원가입=====");
		
		do {
		System.out.print("아이디를 입력해주세요: ");	
		
		    id = sc.nextLine();
		
		    check = de.idFormat(id);		
		
		}while(check);				
		
		 do {			
			System.out.print("비밀번호를 입력해주세요:");
			pwd = sc.nextLine();
			System.out.print("비밀번호 확인:");
			pwd2= sc.nextLine();
						
			check = de.pwdFormant(id, pwd, pwd2);			
			}while(check);
		
		 do {			
			System.out.print("이름:");
			name = sc.nextLine();
			
			check = de.nameFormat(name);
			}while(check);
									
		    //테스트용으로 일단 블락처리
			System.out.print("주민등록번호:");
			ssn = sc.nextLine();
		
		 do {
			System.out.print("이메일:");
			email = sc.nextLine();
			
			check =de.emailFormat(email);
			}while(check);
			
		 do {
			System.out.print("닉네임(최소 3글짜 최대 7글짜):");
			nick = sc.nextLine();
			
			check = de.nickFormat(nick);
			}while(check);
		 
		 do {
			 System.out.print("핸드폰 번호 (-제외):");
			 phone = sc.nextLine();
			 
			 check = de.phone(phone);
			 
		   }while(check);
		
		     System.out.print("주소:");
		     String address = sc.nextLine();	
		  
			
        Member m = new Member(id,pwd2,name,ssn,gbc.gnederConvertor(ssn),gbc.birthdayConvertor(ssn),email,nick,phone,address);
		
        mc.insertMember(m);
	}
	
	
	private void modifyAccount() {
		
		boolean b  = false;
		String id  = null;
		String pwd = null;
		
		String sNick = "";
		
		do {
		System.out.print("아이디를 입력해주세요 :");
		id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 :");
		pwd = sc.nextLine();
		//Dao 까지 아이디와 비밀번호를 보낸다음 유효인자인지 확인
		b = mc.idPwdCheck(id,pwd);
		
		if(b) {
			System.out.println("잘못된 아이디 또는 비밀번호 입니다.");
		}
		
		}while(b);
		
		System.out.println("변경하고자 하는 정보");
		System.out.println("1)닉네임");
		System.out.println("2)주소");
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num){
		//닉네임 변경시 다시 조건검사.
		case 1: 
           do {
            System.out.print("변경할 닉네임을 입력해주세요: ");
        	   
			sNick = sc.nextLine();
			
			b = de.nickFormat(sNick);
			
					
		}while(b);		
		break;
		case 2: System.out.print("변경할 주소를 입력 해주세요:"); 
	        	   
				sNick = sc.nextLine();
			
		break;
		default : System.out.println("잘못 입력하셨습니다");break;				
		}

		mc.modifyAccount(num, id, pwd, sNick);
		
		
	}
	
	
	public void displaySuccess(String string) {
		
		System.out.println(string);
		
	}
	public void displayFail(String string) {
		
		System.out.println(string);
		
	}
	public void disPlayMember(List<Member> list) {
		
		for(Member m : list) {
			System.out.println(m);
		}
		
		
	}

	public void displayResult(Member m) {
		
		System.out.println(m);
		
	}
}
