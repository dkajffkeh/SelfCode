package baseball;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

	while(true) {
		 System.out.println("게임을시작하지...");
		 System.out.println("1.나혼자 하기");
		 System.out.println("2.여려명이서 하기");
		 System.out.println("3.게임종료");
		 System.out.print("입력:");
		 
		 switch(sc.nextInt()) {
		 case 1 : baseball(1); break;
		 case 2 : baseball(2); break;
		 case 3 : System.exit(0); break;
		 default : System.out.println("잘못 입력.");
		 }
	}
			}	

	public static void baseball(int num) {
		
		char [] userInput = new char[4];
		int hit = 0;
		int ball = 0;
		int out =0;
		int strike = 0;
		int parsing = 0;
		boolean lStop = true;
		//1000~9999 난수발생기
		String random = null;
		switch(num) {
		case 1 : random = Integer.toString((int)(Math.random()*9999+0)); break;
		case 2 : do {
			System.out.print("숫자는 0~9999 까지 입력해주세요:");
			parsing = sc.nextInt();
			
			if(parsing<=9999&&parsing>=0) {
				//
				random = Integer.toString(parsing);
				lStop = false;
			}
			
			if(lStop) {
				System.out.println("잘못입력했습니다.\n\n");
			}		
		}while(lStop);
		}
		
		if(random.length()==1) {
			random = "000" + random;
		} else if(random.length()==2) {
			random = "00"  + random;
		}else if(random.length()==3) {
			random = "0"   + random;
		}		
		//random String 값을 쪼개넣음.
        char [] sysInput = random.toCharArray();

        System.out.println("게임을 시작해볼까...");
        int outCount = 0;
        
		while(outCount<5) {
			
			System.out.print("번호입력 0000~9999 :");
			userInput = sc.next().toCharArray();
			outCount++;
			
			//깊은복사로 턴 돌때마다 temp 배열 리셋
			char [] sysTemp = sysInput.clone();
			char[] userTemp = userInput.clone();
			
			for(int i = 0; i<4 ; i++) {

				for(int j = 0 ; j<4 ; j++) {
					
					//중복된 숫자에서 ball보다는 hit 가 우선이므로 찾아서 먼저 지워주는 과정 필요
					if(userInput[i]==sysTemp[j]) {					

						for(int k = 0 ; k<4 ; k++) {

							for(int l = 0 ; l<4 ; l++) {

								if(sysTemp[k]==userTemp[l]) {
									//아래 코드에서 ball 카운트 할시 둘다 x 일경우 또 ball 가운트가 올라갈경우 때문에 서로 다른 값으로 초기화.
									if(k==l) {
										sysTemp[k]='x';
										userTemp[l]='y';
										hit++;
										break;											
									}

								}
							}
						}
						//순환하면서 ball 찾아줘야함. 위에서 hit 를 모두 걸렀기 때문에 아래에서 ball 만 찾아주면 됨.
						for(int k = 0 ; k<4 ; k++) {

							for(int l = 0 ; l<4 ; l++) {

								if(sysTemp[k]==userTemp[l]) {
								//ball도 중복값이 내려옴으로 초기화과정 필요.
								if(k!=l) {
									sysTemp[k]='x';
									userTemp[l]='y';
									ball++;
									break;											
								}

							}
						}
					}
					
				}
				
				}
				//indeoxOf 존재할시 index값 없으면 -1반환
				if(random.indexOf(userInput[i])==-1) {
					strike++;
				}				
				
			}
			
			if(hit==4) {
				System.out.println("!!홈런!!\n\n\n");
				return;
			}
      		System.out.println("히트==>>" + hit + " 볼==>>" + ball + " 스트라이크==>>" + strike + " 목숨==>>" + (5-outCount) +" 개 남음" );
		
			hit = 0;
			ball = 0; 
			strike =0;			
	
		}
		
		System.out.println("======Game Over======");
		System.out.println("정답: ["+random+"]......." );
		return;

	}


}
