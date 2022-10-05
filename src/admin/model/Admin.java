package admin.model;

public class Admin {
	private int admin_id;
	private String admin_name, admin_username;
	private String admin_password;
	private boolean valid;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}	
	
	public String getAdmin_username() {
		return admin_username;
	}
	
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
}