package com.home.sha;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
	
		String id = "dkajffkeh";
		String add = "성내천로 87 송파구 오금동 우방아파트";
				
		
		AES256 a256 = AES256.getInstance();
	
		
		System.out.println(a256.AES_Encode(id).equals("7joGPUEKSKhQeRNTaMePxA=="));
	}

}
