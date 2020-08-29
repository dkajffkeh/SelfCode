package level1;

public class CreaserCipher {

	public static void main(String[] args) {
		
		CreaserCipher cc = new CreaserCipher();
		CreaserCipher cc1 = new CreaserCipher();
		CreaserCipher cc3 = new CreaserCipher();
		System.out.println(cc3.solution("KEEPUPTHEGOODWORK",3));
		
	}

	 public String solution(String s, int n) {
	        String answer = "";
	        
	        char [] carr = s.toCharArray();
     
	        for(int i = 0 ; i<carr.length ; i++) {
	        	
	        	
	        	if(carr[i]>='a'&&carr[i]<='z'&&carr[i]+n>'z') {
	              
	        	carr[i] = (char)(((carr[i]+n) -'z') + 96); 
	        		
	        	} else if(carr[i]>='a'&&carr[i]<='z'&&carr[i]+n<='z') {
	        	carr[i] = (char)(carr[i]+n);
	        	} 
	        	
	        	if(carr[i]>='A'&&carr[i]<='Z'&&carr[i]+n>'Z') {
	        		
	        	carr[i] =  (char)(((carr[i]+n) -'Z') + 64);
	        		
	        	} else if(carr[i]>='A'&&carr[i]<='Z'&&carr[i]+n<='Z') {
	        	carr[i] = (char)(carr[i]+n);
	        		
	        	} 
	        	
	        	if(carr[i]==' ') {
	        		carr[i]=' ';
	        	}
   
	        }
	       
	      for(int i = 0 ; i<carr.length ; i++) {
	    	  
	    	  answer += carr[i];
	    	  
	      }
	        
	        
	      
	        return answer;
	    }
	
}
