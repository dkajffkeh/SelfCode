package com.home.threadTest;

public class ThreadExam {

	public static void main(String[] args) {
		
		MyThread1 mt1 = new MyThread1("*");
		MyThread1 mt2 = new MyThread1("-");
		
		mt1.start();
		mt2.start();
		
		System.out.println("main end!");
		

	}

}
