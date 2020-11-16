import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Module {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[]args) {		
		int j = 0; 
		int [] iarr = new int [3];				
		while(j<3) {
			System.out.println("정수 값을 입력하시오 ");
			iarr[j] = sc.nextInt();
			j++;
		}		
		Arrays.sort(iarr);
		System.out.println(iarr[iarr.length-1]);
		
		
		
	}

}
