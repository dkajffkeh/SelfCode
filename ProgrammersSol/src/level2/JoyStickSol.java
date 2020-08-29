package level2;

public class JoyStickSol {

	public static void main(String[] args) {
		
		System.out.println(solution("ABABABABAB"));
		
	}
	//두번째 인덱스부터의 A 를 제거해주는 메소드
	
	public static int solution(String name) {
		
		int answer = 0;
		int moveMax = name.length()-1;
		

		char [] names = name.toCharArray();
		
		for(int i =0 ; i<names.length ; i++) {
			
			if(names[i]<='N') {
				answer += names[i]%65;
			} else {
				answer += 91-names[i];
			}
		}
		//뒤부터 돌아가는 경우
		//AAA 일때 여기서 실행은 안됨
		if(name.contains("A")) {
			
			int moveCount = 0;
			
			int aCount = 1;
			for(int i = 1 ;i<name.length() ; i++) {
				
				if(names[i]=='A') {
					
				   aCount++;
				} else {
					break;
				}			
			}				
			moveCount = name.length()-aCount;
			if(moveCount < moveMax) moveMax=moveCount;
			
		 //뒤부터 갔다가 다시 앞으로 오는경우	
			for(int i = 0 ; i<name.length() ; i++) {
				
				if(names[i]=='A') {
				
				int bCount = i+1;
				
				boolean whileStopper = true;
				//딱 한번만 실행되도록 변경
				while(whileStopper==true&&bCount<name.length()&&names[bCount]=='A') {
					
					bCount ++ ;
					
				}
				if(bCount>1) {whileStopper = false;}
						
				
                if(bCount==name.length()) {
					
                	moveCount = i - 1;
                	
				} else {
					
					moveCount = (i-1)*2+name.length()-bCount;
					
				}
			
				if(moveCount<moveMax) {moveMax=moveCount;}
				}
			}
		}
		
		System.out.println(moveMax);
        if(moveMax<0) moveMax=0; 
		
		return answer + moveMax;	
	}
       	
        
	}





/*
  public static int sol() {
		
		int answer = 0;
		
		List<Character> list2 = new ArrayList<Character>(delA("JAEAROAN"));
		
			for(Character l :  list2) {
				System.out.println(l);
			}
		
		int [] arr = new int [] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
		
		for(char i = 'A' ; i<='Z' ; i++) {
		char [] crr = {i};
	 }
		
		for(int i = 0; i<list2.size() ; i++) {
						
	    
			
		}		
		
		return answer;
		
	}
*/

