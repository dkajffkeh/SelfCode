package com.home.sha;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES256 {

	private static volatile AES256 INSTANCE;
	final static String secretKey = "12345678912345678900!@#$%^&*()25"; //32bit
	static String IV = secretKey.substring(0,16); //16bit
		
	
	public static AES256 getInstance() {
		
		if(INSTANCE==null) {
			
			synchronized (AES256.class) { //���� �ٸ� �����尡 AES256 �� ������ϰ�� �ٸ� �����尡 ����Ҽ�  ������ ����.
				
				if(INSTANCE==null) {
					INSTANCE = new AES256();
					
				}				
			}	
		}		
		return INSTANCE;
	}
	//��ȣȭ
	public static String AES_Encode(String str) {
		
		byte [] keyDate = secretKey.getBytes();
		String enStr="";
		
		  SecretKey secureKey = new SecretKeySpec(keyDate, "AES");
		  
		  
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));	
			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			
			enStr= new String(Base64.encodeBase64(encrypted));
			
		} catch (Exception e) {			
			e.printStackTrace();
		} 		
		return enStr;
		
	}	
	//��ȣȭ 
	public static String AES_Decode(String str) {
		
		byte[] keyDate = secretKey.getBytes();
		String enStr = null;
		
		SecretKey secureKey = new SecretKeySpec(keyDate,"AES");
		
		try {
			Cipher c= Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));		
			
			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			
			enStr = new String(c.doFinal(byteStr), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return enStr;	
	}
	
}
