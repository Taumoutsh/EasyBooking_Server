package easybooking.server.data.classes;

import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

public class User {
	private String email;
	private String password;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
