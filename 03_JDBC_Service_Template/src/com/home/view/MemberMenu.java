package com.home.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.home.controller.MemberController;
import com.home.model.vo.Member;

// View : 클라이언트가 보게될 시각적인 요소(화면) == 입력 및 출력
public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	
	/**
	 *  메인페이지 == 사용자가 보게될 첫 화면
	 */
public void mainMenu() {
		
		int menu;
		while(true) {
			System.out.println("\n=== 회원 관리 프로그램 ===");
			System.out.println("1. 신규 회원 가입");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름(키워드)으로 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: insertMember(); break;
			case 2: mc.selectList(); break;
			case 3: mc.selectByUserId(inputMemberId()); break;
			case 4: mc.selectByUserName(inputMemberName()); break;
			case 5: updateMember(); break;
			case 6: mc.deleteMember(inputMemberId()); break;
			case 0: System.out.print("정말로 끝내시겠습니까?(y/n) : ");
					if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
						System.out.println("프로그램을 종료합니다.");
						return;
					}else {
						break;
					}
			default: System.out.println("번호를 잘못입력했습니다. 다시 메뉴 선택해주세요.");
			}
			
		}
		
	}
	
	
	/**
	 * 회원 아이디 입력받는 화면 (회원 아이디로검색시, 회원정보수정시, 회원탈퇴시)
	 * @return	사용자가 입력한 회원 아이디
	 */
	public String inputMemberId() {
		System.out.print("\n회원 아이디 입력 : ");
		return sc.nextLine();
	}	
	
	/**
	 * 회원 이름 입력받는 화면 (회원 이름으로 검색시)
	 * @return  사용자가 입력한 회원명(키워드)
	 */
	public String inputMemberName() {
		System.out.print("\n검색할 회원명(키워드) 입력 : ");
		return sc.nextLine();
	}
	
	/**
	 * 회원 가입 화면 (회원의 모든 정보 입력받는 화면)
	 */
	public void insertMember() {
		System.out.println("\n==== 회원 가입 ====");
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String phone = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("취미(,로 공백없이 나열) : ");
		String hobby = sc.nextLine();
		
		//  회원가입요청!! (Controller메소드 호출 - 사용자가 입력한 값들 주섬주섬담은 Member객체 통째로 전달하면서!)
		mc.insertMember(new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby));
		
	}
	
	/**
	 * 회원 정보수정 화면 (변경하고자 하는 회원아이디, 변경할정보(비번,이메일,전화번호,주소))
	 */
	public void updateMember() {
System.out.println("\n=== 회원 정보 변경 ===");
		
		Member m = new Member();
		
		m.setUserId(inputMemberId()); // 해당 회원 아이디 담기
		
		System.out.print("변경할 암호 : ");
		m.setUserPwd(sc.nextLine());
		
		System.out.print("변경할 이메일 : ");
		m.setEmail(sc.nextLine());
		
		System.out.print("변경할 전화번호(-빼고 입력) : ");
		m.setPhone(sc.nextLine());
		
		System.out.print("변경할 주소 : ");
		m.setAddress(sc.nextLine());
		
		// m : 변경하고자하는회원아이디, 변경할정보(암호, 이메일, 전화번호, 주소)
		
		// 회원정보변경 요청!! (Controller 메소드 호출)
	//	mc.updateMember(m);
	}
	
	//---------------------------------------------------------------------------------
	// 사용자가 서비스 요청 후 보게될 응답화면들 (display~~)
	
	/**
	 * 서비스 요청 성공 했을 때의 응답화면
	 * @param message		성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스 요청 실패 했을 때의 응답화면
	 * @param message		실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 없을 경우의 응답화면
	 * @param message		조회결과없음 메세지
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 "한행"이였을 경우의 응답화면
	 * @param m		조회결과에 해당하는 한 회원 객체
	 */
	public void displayMember(Member m) {
		System.out.println("\n조회된 회원 정보는 다음과 같습니다.\n");
		System.out.println(m/*.toString()*/);
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 "여러행"이였을 경우의 응답화면
	 * @param list
	 */
	public void displayMemberList(ArrayList<Member> list) {
		System.out.println("\n조회된 회원 정보는 다음과 같습니다.\n");
		/* for loop문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		*/
		// for each문(향상된 for문)
		for(Member m : list) { // 변수 = list.get(0);	 --> 변수 = list.get(1); --> .... --> 변수 = list.get(마지막인덱스);
			System.out.println(m);
		}
	}
	
	
	

}










