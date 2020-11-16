package level1;

import java.util.HashSet;
import java.util.Set;

public class ArraySumBestAnswer {
	
public static void main(String[] args) {
		
		int [] numbers = {2,2,2,234,134,34,6456,568,234,23,123};
		
		
	
		

	}
	
	
	public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
