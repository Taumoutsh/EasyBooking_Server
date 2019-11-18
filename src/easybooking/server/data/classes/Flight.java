package easybooking.server.data.classes;

import java.sql.Date;

public class Flight {
//properties
	private String flightNumber;
	private int totalSeats, remainingSeats;
	private Date departureTimeDate, arrivalTimeDate;
	private int price;
	//should the flights have an string with the origin and destination airport's code??

	//constructor
	public Flight(String flightNumber, int totalSeats, int remainingSeats, Date departureTimeDate,
			Date arrivalTimeDate, int price) {
		this.flightNumber = flightNumber;
		this.totalSeats = totalSeats;
		this.remainingSeats = remainingSeats;
		this.departureTimeDate = departureTimeDate;
		this.arrivalTimeDate = arrivalTimeDate;
		this.price = price;
	}
	public Flight() {
	}
	public Flight(Flight f) {
		this.flightNumber = f.flightNumber;
		this.totalSeats = f.totalSeats;
		this.remainingSeats = f.remainingSeats;
		this.departureTimeDate = f.departureTimeDate;
		this.arrivalTimeDate = f.arrivalTimeDate;
		this.price = f.price;
	}
	
	//getters and setters
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
	public Date getDepartureTimeDate() {
		return departureTimeDate;
	}
	public void setDepartureTimeDate(Date departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
	}
	public Date getArrivalTimeDate() {
		return arrivalTimeDate;
	}
	public void setArrivalTimeDate(Date arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
