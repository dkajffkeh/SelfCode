package level2;

import java.util.ArrayList;

public class FunctionDevelopment {

	public static void main(String[] args) {
		
		int [] progress = new int [] {95, 90, 99, 99, 80, 99};
		int [] speeds = new int [] {1, 1, 1, 1, 1, 1};

		
		solution(progress,speeds);
	}
	
	public static int[] solution(int[] progress, int[] speeds) {
        int[] answer = {};
        int sum = 0;
        
        while(sum<progress.length) {
        	
        	for(int i = 0 ; i<progress.length; i++) {
        		
        		progress[i] += speeds[i];
        		
        		if(progress[i]>=100) {
        			
        		}
        		
        	}
        	
        	
        }
 
        return answer;

	}
}


