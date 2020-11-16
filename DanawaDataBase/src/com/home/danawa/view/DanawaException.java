package com.home.danawa.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.home.danawa.model.dao.MemberDao;

public class DanawaException {
	
private boolean back = false;


	
	public boolean idFormat(String id)  {

	if(new MemberDao().idInspector(id)) {		
	   System.out.println("이미 사용중인 아이디 입니다.");
	   return true;		
	}
	
		
	if(id.length()<=5||id.length()>=15) {		
		System.out.println("5~15자 이내의 아이디만 가능합니다.");
		return true;
	}
	
	boolean id_check = Pattern.matches("^[a-zA-Z0-9]*$", id);
	
	if(!id_check) {
		System.out.println("아이디는 영문과 숫자만 사용하실 수 있습니다.");
		return true;
	}
	
	return back;
	
	}
	
	public boolean pwdFormant(String id, String pwd , String pwd2)  {
		
		boolean pwd_check = Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{7,25}$", pwd);
		
		if(pwd.length()<=7||pwd.length()>=25) {
			System.out.println("비밀번호는 최소 7자 이상, 25자 이내여야 합니다.");
			return true;
		}
		
		if(!pwd_check) {
			System.out.println("비밀번호는 대소문자와 숫자와 문자를 최소 1개 이상 포함해야만합니다.");
			return true;
		}
		
		
		if(!pwd.equals(pwd2)) {
			System.out.println("서로 일치하지 않습니다.");
			return true;
		}
		
		for(int i = 0 ; i<id.length()-5 ; i++) {
			
		if(pwd2.contains(id.substring(i,i+5))) {			
			System.out.println("아이디와 비슷한 비밀번호는 사용할수 없습니다.");
			return true;			
		}
			
		}
		
		return back;
	}
	
	public boolean nameFormat(String name) {
		
	boolean name_check = Pattern.matches("^[가-힣]*$", name);
		
	if(!name_check) {
		System.out.println("이름은 한글 입력만 가능합니다.");
		return true;
	}
		
		
		return back;
	}

	public boolean ssnFormat(String social) {
		
		int [] iarr = new int[] {2,3,4,5,6,7,8,9,2,3,4,5};
		int sum = 0;
		 
		if(social.length()!=13) {
			System.out.println("주민등록번호는 13자리 숫자만 입력하실 수 있습니다.");
			return true;
		}
		
		for(int i = 0 ; i<iarr.length; i++) {
			
			sum += iarr[i]*Integer.parseInt(String.valueOf(social.charAt(i)));
			
		}
		
		sum%=11;
		sum=11-sum;
	
		if(sum!=Integer.parseInt(social.substring(12))) {
			System.out.println("올바른 주민등록번호가 아닙니다.");
			return true;
		}
		
		
		
		return back;
	}

	public boolean emailFormat(String email) {
		
		boolean mailFormat = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email);
		
		if(!mailFormat) {
			System.out.println("잘못된 이메일입니다.");
			return true;		
		}
		
		return false;
	}

	public boolean nickFormat(String nick) {
		
		
		   if(new MemberDao().nickInspector(nick)) {		
			   System.out.println("이미 사용중인 아이디 입니다.");
			   return true;		
			}
		
		
		boolean name_check = Pattern.matches("^[가-힣]*$", nick);
			
		if(!name_check||nick.length()<3||nick.length()>7) {
			System.out.println("한글 또는 3~7 글짜만 입력가능합니다.");
			return true;
	
	}
		return back;

	}

	public boolean phone(String phone) {
		
		boolean num_check = Pattern.matches("^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$",phone);
		
		if(!num_check) {
			System.out.println("잘못된 번호입니다.");
			return true;
		}
		
		return back;
	}
}
