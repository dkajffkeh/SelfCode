package level1;
//!Not completed
public class MakingAWeirdWords {

	public static void main(String[] args) {
				
System.out.println(solution("sdfmkl sdfmklsdfi s dnfiowef sndf osdf"));
	}
	
	public static String solution(String s) {
        String answer = "";
        
        String [] tokens = s.split(" ");
  
       char ch = ' ';
      
       for(int i = 0; i<tokens.length ; i++) {
    	   
    	   for(int j=0 ; j<tokens[i].length() ; j++) {
    		   
    		   if(j%2==0) {
    			    ch = (char) (tokens[i].charAt(j)-32);
    			    answer += ch;
    		   }else {
    			    answer += (char)tokens[i].charAt(j);
    		   }
    		   
    	   }
    	  answer+=" ";
       }

        return answer.trim();
    }
}