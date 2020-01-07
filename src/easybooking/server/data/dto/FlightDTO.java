package easybooking.server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class FlightDTO  implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6399389947707251421L;
	public FlightDTO(String flightNumber, int totalSeats, int remainingSeats, String departureTimeDate,
			String arrivalTimeDate, int price, String airlineCode, String depatureAirportLocation,
			String depatureAirportCode, String arrivalAirportLocation, String arrivalAirportCode) {
		super();
		this.flightNumber = flightNumber;
		this.totalSeats = totalSeats;
		this.remainingSeats = remainingSeats;
		this.departureTimeDate = departureTimeDate;
		this.arrivalTimeDate = arrivalTimeDate;
		this.price = price;
		this.airlineCode = airlineCode;
		this.depatureAirportLocation = depatureAirportLocation;
		this.depatureAirportCode = depatureAirportCode;
		this.arrivalAirportLocation = arrivalAirportLocation;
		this.arrivalAirportCode = arrivalAirportCode;
	}
	
	private String flightNumber;
	private int totalSeats, remainingSeats;
	private String departureTimeDate, arrivalTimeDate;
	private int price;
	private String airlineCode;
	private String depatureAirportLocation, depatureAirportCode;
	private String arrivalAirportLocation, arrivalAirportCode;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	public String getDepartureTimeDate() {
		return departureTimeDate;
	}
	public void setDepartureTimeDate(String departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
	}
	public String getArrivalTimeDate() {
		return arrivalTimeDate;
	}
	public void setArrivalTimeDate(String arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getDepatureAirportLocation() {
		return depatureAirportLocation;
	}
	public void setDepatureAirportLocation(String depatureAirportLocation) {
		this.depatureAirportLocation = depatureAirportLocation;
	}
	public String getDepatureAirportCode() {
		return depatureAirportCode;
	}
	public void setDepatureAirportCode(String depatureAirportCode) {
		this.depatureAirportCode = depatureAirportCode;
	}
	public String getArrivalAirportLocation() {
		return arrivalAirportLocation;
	}
	public void setArrivalAirportLocation(String arrivalAirportLocation) {
		this.arrivalAirportLocation = arrivalAirportLocation;
	}
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	
	

}
