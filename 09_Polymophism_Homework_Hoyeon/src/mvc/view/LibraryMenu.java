package mvc.view;

import java.util.List;
import java.util.Scanner;

import mvc.controller.LibraryManager;
import mvc.model.vo.Book;
import mvc.model.vo.Member;

public class LibraryMenu implements LM_Interface {

	private LibraryManager lm = new LibraryManager();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void mainMenu() {
		
		System.out.println("======Guest Checkout======");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Age:");
		int age = sc.nextInt();
		System.out.print("Gender:");
		char ch = sc.next().charAt(0);
		Member m = new Member(name,age,ch);
		lm.insertMember(m);
		while(true) {
		System.out.println("Welcom to Trinity library!");
		System.out.println("=========Menu=========");
		System.out.println("1.My page");
		System.out.println("2.Scan all books");
		System.out.println("3.Search books");
		System.out.println("4.Check-out");
		System.out.println("0.Exit Program");
		System.out.println("Please Select menu");
		int num = sc.nextInt();
		
		switch(num) {
		case 1: System.out.println(lm.myinfo()); break;
		case 2: selectAll(); break;
		case 3: searchBook(); break;
		case 4: rentBook(); break;
		case 0: return;
	
		
		}
		}	
	}
	@Override
	public void selectAll() {
		
		List<Book> mem = lm.selectAll();
	    for(int i = 0; i<mem.size();i++) {
	    	System.out.println(i+")"+mem.get(i).toString());
	    }
	   
		
	}
	@Override
	public void searchBook() {	
		
			System.out.print("Enter Key words of the book:");
			sc.nextLine();
			String keyWord = sc.nextLine();
			
			List<Book> mem =lm.searchBook(keyWord);
			for(Book a : mem) {
			System.out.println(a);
		
	}
	}
	@Override
	public void rentBook() {
		
		selectAll();
		System.out.println("Select Book list you want to check out");
		int num = sc.nextInt();
		switch(lm.rentBook(num)) {	
		case 0: System.out.println("It has been checked out successfully");break;
		case 1: System.out.println("Your age is not elidgible for this book");break;
		case 2: System.out.println("It has been checked out successfully\nWe've sent you an cooking academy coupon.\ncheck this out on\"Your Page\"\n");break;
		
		
		}
		
		
		
		}
	
	
	
}

