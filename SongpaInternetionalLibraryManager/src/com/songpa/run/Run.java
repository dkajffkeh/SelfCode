package com.songpa.run;

import java.io.IOException;

import com.songpa.menu.BookMenu;

public class Run {

	public static void main(String[]args) {
		
		
		BookMenu bm = new BookMenu();
		try {
			bm.mainMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//?
	
}
