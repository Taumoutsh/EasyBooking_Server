package easybooking.server.data.classes;

import java.util.ArrayList;
import javax.jdo.annotations.*;

@PersistenceCapable
public class User {
	private String email;
	private String password;
	private int paymentMethod, authorizationMethod;
	private Airport defaultDepartureAirport;
	@NotPersistent
	private ArrayList<Flight> chosenFlight;
	
	public User(String email, int paymentMethod, int authorizationMethod, Airport defaultDepartureAirport) {
		this.email = email;
		this.paymentMethod = paymentMethod;
		this.authorizationMethod = authorizationMethod;
		this.defaultDepartureAirport = defaultDepartureAirport;
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
	public Airport getDefaultDepartureAirport() {
		return defaultDepartureAirport;
	}
	public void setDefaultDepartureAirport(Airport defaultDepartureAirport) {
		this.defaultDepartureAirport = defaultDepartureAirport;
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
			Reservation reservation = new Reservation(passenger, flight);
		}
		return true;
	}
	
	public boolean pay() {
		return true;
	}
}
