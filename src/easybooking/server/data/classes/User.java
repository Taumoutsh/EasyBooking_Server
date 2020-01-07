package easybooking.server.data.classes;

import java.util.ArrayList;

public class User {
	private String email;
	private String password;
	private int paymentMethod, authorizationMethod;
	private ArrayList<Flight> chosenFlight;
	
	public User(String email, String password, int paymentMethod, int authorizationMethod) {
		this.email = email;
		this.password = password;
		this.paymentMethod = paymentMethod;
		this.authorizationMethod = authorizationMethod;
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
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getAuthorizationMethod() {
		return authorizationMethod;
	}
	public void setAuthorizationMethod(int autorizationMethod) {
		this.authorizationMethod = autorizationMethod;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void signUp() {
		
	}
	
	public void login() {
		
	}
	
	public boolean choseFlight(Flight flight) {
		chosenFlight.add(flight);
		return true;
	}
	
	public boolean bookFlight(ArrayList<Passenger> passenger) {
		for(Flight flight : chosenFlight) {
			//Later for every reservation method call pay()
			//Reservation reservation = new Reservation(passenger, flight);
		}
		return true;
	}
	
	public boolean pay() {
		return true;
	}
}
