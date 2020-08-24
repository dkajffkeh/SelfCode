package com.songpa.model.vo;

public class Book {

	private int bNo;
	private String title;
	private int category;
	private String author;
	
	public Book() {}
	
	public Book(int bNo, String title, int category, String author) {
		
		this.bNo = bNo;
		this.title = title;
		this.category = category;
		this.author = author;
	}
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		
		String category = "";
		
		switch(this.category) {
		case 1:category = "Humaities"; break;
		case 2:category = "Nature Science"; break;
		case 3:category = "Medical"; break;
		case 4:category = "other"; break;
		default : System.out.println("Wrong category");
	
		}
	
		return category + " => Title: " + title + " Author: " + author; 
				
				
				
	}
	//Humanities
	//Science
	//Medical
	//etc..
	//Natural Science
	
	
	
	
}
