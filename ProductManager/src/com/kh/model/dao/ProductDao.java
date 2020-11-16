package com.kh.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Product;
import static com.kh.common.JDBCTemplate.*;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		
		try {
			String path = "resources/query.properties";
			prop.load(new FileReader(path));		
			
		}   catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insertProduct(Connection conn, Product p) {
		
		PreparedStatement pstmt = null;
		System.out.println(prop);

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertProduct"));
			pstmt.setString(1, p.getProductid());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setInt(5, p.getStock());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  close(pstmt);
		
		
		return result;
		
	}

	public ArrayList<Product> scanProducts(Connection conn) {
		
		ArrayList<Product> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("scanProducts"));
		    rs = pstmt.executeQuery();
			
		    while(rs.next()) {
		    	
		    	list.add(new Product(rs.getString("PRODUCT_ID")
		    			            ,rs.getString("P_NAME")
		    			            ,rs.getInt("PRICE")
		    			            ,rs.getString("DESCRIPTION")
		    			            ,rs.getInt("STOCK")));
		    	
	    	
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return list;
		
	}

	public void modifyProduct(String pId) {
		
		
	}

}
