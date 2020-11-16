import java.util.Scanner;

public class ChannelgeAccepted {

    static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	      
		      int num;
		      int [] add = new int[2];
	      
		      System.out.print("학생 번호 입력 >>");
		      num = scan.nextInt();
		      System.out.print("1. 국어 점수 입력 >>");
		      add[0] += scan.nextInt();
		      System.out.print("2. 수학 점수 입력 >>");	      
		      add[0] += scan.nextInt();
		      System.out.print("3. 영어 점수 입력 >>");		     
		      add[0] += scan.nextInt();
		      
		      System.out.println(num + "번 학생의 점수 합계?" + add[0] +"점");

		      System.out.print("학생 번호 입력 >>");
		      num = scan.nextInt();
		      System.out.print("1. 국어 점수 입력 >>");	      
		      add[1] += scan.nextInt();
		      System.out.print("2. 수학 점수 입력 >>");		      
		      add[1] += scan.nextInt();
		      System.out.print("3. 영어 점수 입력 >>");		     
		      add[1] += scan.nextInt();

		      System.out.println(num + "번 학생의 점수 합계?" + add[1] +"점");
		      
		      System.out.println("두 학생의 평균 점수는? "+ (add[0]+add[1])/6 +"점");
		      
		
	}
}