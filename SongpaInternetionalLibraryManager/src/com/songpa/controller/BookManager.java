package com.songpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.songpa.model.vo.Book;

public class BookManager {

	private List<Book> bList = new ArrayList<>();
	private List<Book> delList = new ArrayList<>();
	
	public BookManager() {}
	
	public int insertBook(Book book) {	
	//북 Number 중복 방지 코드	
	int count = 0;	

	//Forced return so as to avoid processing codes down below.
	if(bList.isEmpty()) {
		bList.add(book);
		return 0;
	}
	for(int i = 0; i<bList.size(); i++) {
		
		if(bList.get(i).getbNo()==book.getbNo()) {
			count = 1;
		}	
	}
	
	if(count==0) {
		bList.add(book);
	}
	
	return count;
	
		}
	public void deleteBook(int bNo) {
		

		for(int i =0 ; i<bList.size() ; i++) {
			
			if(bList.get(i).getbNo()==bNo) {
				//Back up List.
				delList.add(bList.get(i));
				bList.remove(i);
				i--;
				
			}
			// Back up List is over 500 Clear automatically
			
			if(delList.size()>500) {
				delList.clear();
			}
		}

	}

	public List<Book> searchBook(String keyWords){
		
		List<Book> searchList = new ArrayList<>();
		//Garbage collection 
		System.gc();
		
		for(int i = 0 ; i<bList.size() ; i++) {
			
			if(bList.get(i).getTitle().contains(keyWords)
			||bList.get(i).getAuthor().contains(keyWords)) {
			
			 searchList.add(bList.get(i));
				
		}
	
	}
		return searchList;
	
	}
	
    public List<Book> searchBook(int bNo){
		
    	List<Book> searchList = new ArrayList<>();
    	
    	System.gc();
    	
    	for(Book m : bList) {
    		
    		if(m.getbNo()==bNo) {
    			searchList.add(m);
    		}
    	}
		return searchList;
	
	}

  public List<Book> selectList(){
	  
	  
	  return bList;
	  
  }
	
}
