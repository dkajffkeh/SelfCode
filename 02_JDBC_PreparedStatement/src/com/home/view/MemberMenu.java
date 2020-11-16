package com.home.view;

import java.util.Scanner;

import com.home.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
		
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
        
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 6: break;
        case 0: System.out.print("정말로 끝내시겠습니까?(y/n) :");
                if(sc.nextLine().toUpperCase().equals("Y")) {
                	System.out.println("프로그램을 종료합니다."); 
                	return;
                } else if(sc.nextLine().toUpperCase().equals("N")) {
                	break;
                } else {
                	System.out.println("잘못 입력하셨습니다.");
                }
        
       default: System.out.println("잘못 입력하셨습니다."); break; 
        }
		
		}
		
		
	}
}
