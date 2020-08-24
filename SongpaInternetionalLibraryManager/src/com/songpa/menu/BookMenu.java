package com.songpa.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.songpa.controller.BookManager;
import com.songpa.model.vo.Book;

public class BookMenu {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private BookManager bm = new BookManager();
	
	public BookMenu() {}
	
	public void mainMenu() throws IOException {
				
		while(true) {
		System.out.println("***PAH Book manager***");
		System.out.println("1. Add new books");
		System.out.println("2. Delete");
		System.out.println("3. Search books");
		System.out.println("4. Print all");
		System.out.println("0. Quit");

		int num = 0;
		try {
		   num = Integer.parseInt(br.readLine());
		}  catch (IOException e) {		
			e.printStackTrace();
		}
		
		switch(num) {
		
		case 1: insertBook(); break;
		case 2: deleteBook();break;
		case 3: searchBook();break;
		case 4: selectList();break;
		case 0: return;
		
		}
		}
	}

	public void insertBook() throws IOException {
		
		System.out.println("==========Inser Menu==========");
		
		System.out.print("Enter BookNumber: ");
		int bNo = Integer.parseInt(br.readLine());
		System.out.print("Enter Book title");
		String title = br.readLine();
		int category = 0;
		while(true) {
		System.out.print("Enter Category of the book");
		
		category = Integer.parseInt(br.readLine());
		
			if(category<=4 && category>0) {
				break;
			} else {
				System.out.println("Wrong number typed");
			}

		}
		System.out.print("Enter the author of the book");
		String author = br.readLine();
		
		
		
		if(bm.insertBook(new Book(bNo,title,category,author))==0) {
			System.out.println(bm.searchBook(bNo) + " Created!");
		} else {
			System.out.println("Book number shouldn't conflict!");
		}
		
	}

	public void deleteBook() throws NumberFormatException, IOException {
	
		System.out.println("==========Deleting Book menu==========");
		
		selectList();
		System.out.println("Enter the number of the book you want to delete");
		int bNo = Integer.parseInt(br.readLine());
		
		
		if(bm.searchBook(bNo).isEmpty()) {
			System.out.println("The book doesn't exsist");
		} else {
			// Scan the matched book.
			System.out.println(bm.searchBook(bNo));
			System.out.println("You still want to delete that list? \nthis one can not be undone!\n(Y)");
			
			char ch = br.readLine().toUpperCase().charAt(0);
			
			switch(ch) {
			
			case 'Y' : bm.deleteBook(bNo); System.out.println("Deleted!"); break;
			default : System.out.println("Canceled!"); return;
			
			}						
		}
	}
//?
    public void searchBook() throws IOException {
    	
    	System.out.println("=====Search Book menu=====");
    	System.out.print("Search : ");
    	String keywords = br.readLine();
    	
    	for(Book b : bm.searchBook(keywords)) {
    		System.out.println(b);
    	}
    	System.out.println(" ");
    
    }
    public void selectList() {
    	
    	for(Book b : bm.selectList()) {
    		System.out.println(b.getbNo()+")"+b);
    	}
    	System.out.println(" ");
    	
    }


}
