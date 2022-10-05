package product.model;

import java.util.*;

import admin.model.Admin;

public class ProductBean extends Admin{
	private int product_id;
	private String product_name;
	private double product_price;
	private String product_description;
	private int product_count;
	
	public int getProductID() {
		return this.product_id;
	}
	
	public String getProductName() {
		return this.product_name;
	}
	
	public Double getProductPrice() {
		return this.product_price;
	}
	
	public String getProductDesc() {
		return this.product_description;
	}
	
	public int getProductCount() {
		return this.product_count;
	}
	
	public void setProductID(int product_id) {
		this.product_id = product_id;
	}
	
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
	
	public void setProductPrice(double product_price) {
		this.product_price = product_price;
	}
	
	public void setProductDesc(String product_description) {
		this.product_description = product_description;
	}
	
	public void setProductCount(int product_count) {
		this.product_count = product_count;
	}
}
