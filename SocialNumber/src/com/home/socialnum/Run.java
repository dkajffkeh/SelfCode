package com.home.socialnum;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		SocialNumber sn = new SocialNumber();
		
		System.out.print("주민등록번호를 입력해주세요(-제외) : ");
		
		sn.socialNumber(sc.nextLine());
		
		
	}

}
