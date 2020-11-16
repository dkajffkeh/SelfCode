package com.home.sha;

import java.security.MessageDigest;

public class SHA256 {

	
	public static String getSHA256(String input) {
		
		StringBuffer result = new StringBuffer(); //비동기 처리에 유리하며 String 값을 더하는데 있어 매우 유리 
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); //암호화 형식을 SHA-256으로 하겠다.
			byte [] salt = "Hello This is a Salt".getBytes(); // 유니코드 문자열을 바이트단위로 인코딩함.
			digest.reset();  //후에 사용할 digest 가 있을 수 있기때문에 한번 리셋해줌.
			digest.update(salt); // salt 로 입력된 유니코드를 digest hash 값을 업데이트

			byte[] chars = digest.digest(input.getBytes("UTF-8"));  //utf8로입력된 Hash 값 chars 배열에 담음.
			for(int i =0 ; i<chars.length ; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				
				if(hex.length()==1) result.append("0");
				
				result.append(hex);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return result.toString();
	}
	
}
