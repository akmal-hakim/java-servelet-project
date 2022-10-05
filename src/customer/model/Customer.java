package customer.model;

public class Customer {
	private int customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_phonenum;
	private String customer_address;
	private String customer_password;
	private boolean valid;
	
	public void Customer(int id, String name, String email, String phonenum, String address, String password) {
		customer_id = id;
		customer_name = name;
		customer_email = email;
		customer_phonenum = phonenum;
		customer_address = address;
		customer_password = password;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_phonenum() {
		return customer_phonenum;
	}
	public void setCustomer_phonenum(String customer_phonenum) {
		this.customer_phonenum = customer_phonenum;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
