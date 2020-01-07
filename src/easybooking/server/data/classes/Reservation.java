package easybooking.server.data.classes;

import java.util.ArrayList;
import java.util.Scanner;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
public class Reservation{
	private int paymentCode, numberOfSeats;
	private ArrayList<Passenger> passenger;
	private User user;
	private Flight flight;
	
	//constructor
	public Reservation(ArrayList<Passenger> passenger, Flight flight, User user, int paymentCode) {
		this.paymentCode = -1;// this means the reservation is not paid, once the method pay() is used the payment code is changed
		this.numberOfSeats = passenger.size();
		this.passenger = passenger;
		this.flight = flight;
		this.user = user;
	}
	
	//getter setter
	
	public int getPaymentCode() {
		return paymentCode;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public ArrayList<Passenger> getPassengers() {
		return passenger;
	}
	public void setPassengers(Passenger passenger) {
		this.passenger.add(passenger);
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
}
