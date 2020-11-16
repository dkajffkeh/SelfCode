package level0;

public class StartStacking {

	public static void main(String[] args) {
		
		for(int i = 0 ; i<5 ; i ++) {		
			//* i = 0 을 보내주면 j =0 주번째 for 문이 총 0, 1, 2, 3 -> 4번 실행됨
			//* i = 1 을 보내주면 j =0 주번째 for 문이 총 1, 2, 3 -> 3번 실행됨
			//* i = 2 을 보내주면 j =0 주번째 for 문이 총 2, 3 -> 2번 실행됨
			//* i = 3 을 보내주면 j =0 주번째 for 문이 총 3 ->1번 실행됨
			for(int j = i ; j<4 ; j++) {
				System.out.print("*");
			}
			//한번 사이클이 끝날때마다 개행으로 칸내림.
			System.out.println("");
		}
		
		for(int i = 0 ; i<5 ; i ++) {			
			for(int j = 0 ; j<i ; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
			
				
		for(int i = 4; i>0 ; i-- ) {
			
			for(int j = 0; j<5 ; j++) {
				if(i>j) {
					System.out.print(" ");
				} else {
					System.out.println("*");
				}
			}
			System.out.println("");
			
		}

	}

}
