package level1;

import java.util.Arrays;

public class SecretMap_level1 {

	public static void main(String[] args) {

    int [] arr1 = {9, 20, 28, 18, 11};
    int [] arr2 = {30, 1, 21, 17, 28};
		
		solution(arr1.length,arr1,arr2);
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        
		String[] answer = new String[n];
        String [][] str1 = new String [n][n];
        String [][] str2 = new String [n][n];
        int [] binary = new int [n];
        
        for(int i = n-1 ; i>=0 ; i--) {
        
        	binary[i] = (int)Math.pow(2, n-i-1);

        }
        //binary{16,8,4,2,1}
        for(int i = 0 ; i<binary.length; i++) {
        	
        	answer[i]="";
        	
        	for(int j = 0 ; j<binary.length ;j++) {
        		
        	    if(arr1[i]>=binary[j]) {
        	    	
      	    	    arr1[i]-=binary[j];
        	    	str1[i][j]="1";
        	    } else
        	    {
        	    	str1[i][j] = "0";
        	    }
	            
               if(arr2[i]>=binary[j]) {
        	    	
      	    	    arr2[i]-=binary[j];
        	    	str2[i][j]="1";
        	    } else
        	    {
        	    	str2[i][j] = "0";
        	    }

               if(str1[i][j]=="1"||str2[i][j]=="1") {
            	   
            	   answer[i]+="#";
            	   
               } 
               else if(str1[i][j]=="0" && str2[i][j]=="0")
               {   
            	   answer[i]+=" ";
               }
             
        	}
        	
        }

        for(int i = 0 ; i<binary.length; i++) {
        	System.out.println(answer[i]);
        }
        
        
        return answer;


	}
	
}
