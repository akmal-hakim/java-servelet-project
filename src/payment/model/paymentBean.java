package payment.model;

import customer.model.Customer;

public class paymentBean{
	@Override
	public String toString() {
		return "paymentBean [payment_id=" + payment_id + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", payment_date=" + payment_date + ", customer_email=" + customer_email
				+ ", product_name=" + product_name + ", payment_price=" + payment_price + "]";
	}

	private int payment_id, customer_id, product_id, quantity;
	private String payment_date, customer_email, product_name;
	private double payment_price;
	
	public int getPaymentID() {
		return this.payment_id;
	}
	
	public int getCustomerID() {
		return this.customer_id;
	}
	
	public int getProductID() {
		return this.product_id;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public String getPaymentDate() {
		return this.payment_date;
	}
	
	public double getPaymentPrice() {
		return this.payment_price;
	}
	
	public String getCustomerEmail() {
		return customer_email;
	}
	
	public String getProductName() {
		return this.product_name;
	}
	
	public void setPaymentID(int payment_id) {
		this.payment_id = payment_id;
	}
	
	public void setCustomerID(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public void setProductID(int product_id) {
		this.product_id = product_id;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPaymentDate(String payment_date) {
		this.payment_date = payment_date;
	}
	
	public void setPaymentPrice(double payment_price) {
		this.payment_price = payment_price;
	}
	
	public void setCustomerEmail(String customer_email) {
		this.customer_email = customer_email;
	}
	
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
}
