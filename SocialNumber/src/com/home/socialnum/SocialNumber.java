package com.home.socialnum;

public class SocialNumber {

	
	public int socialNumber(String social) {
		
		int [] iarr = new int[] {2,3,4,5,6,7,8,9,2,3,4,5};
		int sum = 0;
		 
		if(social.length()!=13) {
			System.out.println("잘못 입력하셨습니다.");
			return 0;
		}
		
		for(int i = 0 ; i<iarr.length; i++) {
			
			sum += iarr[i]*Integer.parseInt(String.valueOf(social.charAt(i)));
			
		}
		
		sum%=11;
		sum=11-sum;

		
		if(sum==Integer.parseInt(social.substring(12))) {
			System.out.println("올바른 번호입니다!");
			return 1;
		} else {
			System.out.println("잘못입력하셨습니다.");
			return 0;
		}
		
		
		
	
		
		
		
		
	}
	
	
}
