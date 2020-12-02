package level1;

public class PracticeExam {

	public static void main(String[] args) {
		
		int random = (int)(Math.random()*10000+1);
		int [] answers = new int[random];
		
		for(int i = 0; i<answers.length ; i++) {
			answers[i] = (int)(Math.random()*5+1);
			
		}
		solution(answers);

	}
	
	public static int[] solution(int[] answers) {
		
		int[] answer = new int[3];
		int [] first = {1,2,3,4,5};
		int [] second = {2,1,2,3,2,4,2,5};
		int [] third = {3,3,1,1,2,2,4,4,5,5};
		
		int countA = 0;
		int countB = 0;
		int countC = 0;
		
		for(int i = 0 ; i<answers.length ; i++) {
			
			if(first[i%first.length]==answers[i]) {
				countA++;
			}
			if(second[i%second.length]==answers[i]) {
				countB++;
			}
			if(third[i%third.length]==answers[i]) {
				countC++;
			}
		}
		
		
		
		return answer;
		
	}

}
