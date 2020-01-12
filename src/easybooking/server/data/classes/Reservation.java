package easybooking.server.data.classes;

import java.util.ArrayList;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Reservation{
	private int paymentCode;
	private String userAddress;
	private String flightCode;
	
	//constructor
	public Reservation(String flightCode, String userAddress, int paymentCode) {
		this.flightCode = flightCode;
		this.userAddress = userAddress;
		this.paymentCode = paymentCode;
	}
	
	//getter setter
	
	public int getPaymentCode() {
		return paymentCode;
	}
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	
	public String getFlightCode() {
		return flightCode;
	}
	
}
