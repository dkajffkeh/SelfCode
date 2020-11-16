package com.home.sha;

import java.security.MessageDigest;

public class SHA256 {

	
	public static String getSHA256(String input) {
		
		StringBuffer result = new StringBuffer(); //�񵿱� ó���� �����ϸ� String ���� ���ϴµ� �־� �ſ� ���� 
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); //��ȣȭ ������ SHA-256���� �ϰڴ�.
			byte [] salt = "Hello This is a Salt".getBytes(); // �����ڵ� ���ڿ��� ����Ʈ������ ���ڵ���.
			digest.reset();  //�Ŀ� ����� digest �� ���� �� �ֱ⶧���� �ѹ� ��������.
			digest.update(salt); // salt �� �Էµ� �����ڵ带 digest hash ���� ������Ʈ

			byte[] chars = digest.digest(input.getBytes("UTF-8"));  //utf8���Էµ� Hash �� chars �迭�� ����.
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
