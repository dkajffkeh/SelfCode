package level2;

public class JoyStickSol {

	public static void main(String[] args) {
		
		System.out.println(solution("ABABABABAB"));
		
	}
	//�ι�° �ε��������� A �� �������ִ� �޼ҵ�
	
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
		//�ں��� ���ư��� ���
		//AAA �϶� ���⼭ ������ �ȵ�
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
			
		 //�ں��� ���ٰ� �ٽ� ������ ���°��	
			for(int i = 0 ; i<name.length() ; i++) {
				
				if(names[i]=='A') {
				
				int bCount = i+1;
				
				boolean whileStopper = true;
				//�� �ѹ��� ����ǵ��� ����
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

