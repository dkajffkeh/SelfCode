package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;


public class ArraySum {

	public static void main(String[] args) {
		
		int [] numbers = {2,2};
		int [] numbers2 = {5,0,2,7};
		
		sum(numbers);
		/* sum(numbers2); */
		

	}
	
	public static int[] sum(int [] number) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		

		for(int i = 0 ; i<number.length ; i++) {
			
			for(int j = i+1 ; j<number.length ; j++ ) {
				list.add(number[i]+number[j]);
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0 ; i<list.size()-1 ; i ++) {
			
			if(list.get(i).equals(list.get(i+1))) {
				list.remove(i);
				i--;
			}
		}
		int [] answer = new int[list.size()];
		
		for(int i = 0 ; i<list.size() ; i ++) {
			answer[i]=list.get(i);
		}
		
		
		return answer;
	}

}
