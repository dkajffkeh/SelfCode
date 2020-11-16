package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductMenu {

	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();
	
	public void mainMenu() {
	
		while(true) {
		int num;
		
		System.out.println("1.제품 전체조회");
		System.out.println("2.상품 추가 하기");
		System.out.println("3.상품 수정 하기");
	    System.out.println("4.상품 삭제 하기");
     	System.out.println("5.상품 검색 하기");
     	System.out.println("0.제품 전체조회");
     	System.out.println("메뉴선택");
     	num = sc.nextInt();
     	sc.nextLine();
	switch(num) {
	
	case 1 : pc.scanProducts(); break;
	case 2 : insertProduct(); break;
	case 3 : modifyProduct(); break;
	case 4 : break;
	case 5 : break;
	case 0 : return;
	}
		}
	
	}

	

	private void insertProduct() {
		
		System.out.print("품번을 입력하시오:");
		String id = sc.nextLine();
		System.out.print("제품명을 입력하시오:");
		String name = sc.nextLine();
		System.out.print("가격을 입력하시오:");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("종류를 넣으시오:");
		String des = sc.nextLine();
		System.out.print("재고를 입력하시오");
		int stock = sc.nextInt();
		
		Product p = new Product(id,name,price,des,stock);
		pc.insertProduct(p);
		
		
		
	}
	private void modifyProduct() {
	
		System.out.println("변경할 제품명을 입력하시오");
		String PId = sc.nextLine();
		
		pc.modifyProduct(PId);		
		
	}

	public void displaySuccess(String message) {
		System.out.println(message);
		
	}

	public void displayFailed(String message) {
		System.out.println(message);
		
	}

	public void scanProducts(ArrayList<Product> list) {
		
		for(Product p : list) {
			System.out.println(p);
		}
		
	}



}
