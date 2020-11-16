package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Product;
import com.kh.service.ProductService;
import com.kh.view.ProductMenu;

public class ProductController {

	public void insertProduct(Product p) {
		
		int result = 0;
		
		result = new ProductService().insertProduct(p);
		
		if(result>0) {
			
			new ProductMenu().displaySuccess("성공적으로 추가 되었습니다.");
			
		} else {
			
			new ProductMenu().displayFailed("오류가 발생하였습니다.");
		}
		
	}

	public void scanProducts() {
		ArrayList<Product> list = new ArrayList<>();
		
	list = 	new ProductService().scanProducts();
		
	if(list!=null) {
		new ProductMenu().scanProducts(list);
	} else {
		new ProductMenu().displayFailed("오류가 발생하였습니다.");
	}
	
		
	}
	
	public void modifyProduct(String PId) {
		
		new ProductService().modifyProduct(PId);
		
		
	}

}
