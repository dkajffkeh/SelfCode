package baseballgame;

import java.util.Arrays;

public class Hello {

	
	public static void main(String[] args) {
		
				System.out.println(sort(26));
				System.out.println(sort(55));
				System.out.println(sort(1));
	}

	private static int sort(int i) {
		
		int result = 0 ;
		int sum = 0;
		int temp = 0 ;
		
		int [] iArr=new int[2];
		
		if(i<10) {		
			iArr[0]=0;
			iArr[1]=i;
		
		} else {

		    iArr[0]=i/10;
		    iArr[1]=i%10;	
		}
		
		while(sum!=i) {
			
			temp = iArr[0] + iArr[1];
			
			if(temp>=10) {
				temp-=10;
			}
			iArr[0]=iArr[1];
			iArr[1]=temp;

			sum=(iArr[0]*10)+temp;
			result++;
			
		}

		return result;
	}	
	

}
