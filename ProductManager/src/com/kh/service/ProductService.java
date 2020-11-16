package com.kh.service;

import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;


public class ProductService {

	public int insertProduct(Product p) {
		
		int result = 0;
		Connection conn = null;
		
		conn = getConnection();
				
		result = new ProductDao().insertProduct(conn,p);
		
		if(result>0) {
			commit(conn);
		} else {
		    rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Product> scanProducts() {
		
		ArrayList<Product> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = new ProductDao().scanProducts(conn);
		
		close(conn);
		return list;
		
	}

	public void modifyProduct(String pId) {
		
		new ProductDao().modifyProduct(pId);
		
	}

}
