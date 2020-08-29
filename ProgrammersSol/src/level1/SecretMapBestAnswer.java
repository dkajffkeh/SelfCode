package level1;

public class SecretMapBestAnswer {

	public static void main(String[] args) {
		int [] arr1 = {9, 20, 28, 18, 11};
	    int [] arr2 = {30, 1, 21, 17, 28};
			
			solution(arr1.length,arr1,arr2);
		}
		
		public static String[] solution(int n, int[] arr1, int[] arr2) {

		String [] answer = new String[n];
		
		
		for(int i = 0 ; i<answer.length ; i++) {
			
			int arr = arr1[i] | arr2[i];
			
			
		}
		
		 return answer;
		}


}