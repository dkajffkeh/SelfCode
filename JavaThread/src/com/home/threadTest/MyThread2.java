package com.home.threadTest;

public class MyThread2 extends Thread {
	
	String str; 
	
	public MyThread2(String str) {
		this.str=str;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(str);
		}
		
		try {
			Thread.sleep((int)Math.random()*10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
