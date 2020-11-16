package level1;

public class BlindPhonenNmber {

	public static void main(String[] args) {
		
		System.out.println(solution("238492783489273849"));
		

	}

	public static String solution(String phone_number) {
		
		String answer = "";
		
		for(int i = 0 ; i<phone_number.length()-4; i++) {
			
			answer +="*";
			
		}
		
        return answer+phone_number.substring(phone_number.length()-4);
		
		
	}
	
}
