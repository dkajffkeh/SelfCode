package com.kh.model.vo;

public class Product {

 private String	productid;
 private String pName;
 private int    price;
 private String description;
 private int stock;
 
public Product(String productid, String pName, int price, String description, int stock) {

	this.productid = productid;
	this.pName = pName;
	this.price = price;
	this.description = description;
	this.stock = stock;
}

public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
	this.productid = productid;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

@Override
public String toString() {
	return "Product [productid=" + productid + ", pName=" + pName + ", price=" + price + ", description=" + description
			+ ", stock=" + stock + "]";
}
	
 
 
}
