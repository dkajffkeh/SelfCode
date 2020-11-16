package staticTest;

import static staticTest.staticTest1.StaticTest1.*;
import staticTest.staticTest1.StaticTest1;

public class StaticTest {
	
	private StaticTestSub st = new StaticTestSub();
	private StaticTest1 st1 = new StaticTest1();
	

	public static void main(String[] args) {
		
		abc();
		subMain();


	}
	public static void subMain() {
		StaticTestSub.test1();
	}

}
