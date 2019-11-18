package easybooking.server.data.classes;

import java.util.HashMap;

public class Airline {
	//properties
	private String idAirline;
	private HashMap<String,Flight> flightList;
	
	//constructors
	public Airline(String idString, HashMap<String, Flight> flightList) {
		this.idAirline = idString;
		this.flightList = flightList;
	}
	public Airline(String id) {
		this.idAirline =id;
		this.flightList = new HashMap<String, Flight>();
	}
	
	//get set
	public String getIdAirline() {
		return idAirline;
	}
	public void setIdAirline(String idAirline) {
		this.idAirline = idAirline;
	}
	public HashMap<String, Flight> getFlightList() {
		return flightList;
	}
	public Flight getFlight(String flightCode) {
		return this.flightList.get(flightCode);
	}
	public void setFlightList(HashMap<String, Flight> flightList) {
		this.flightList = flightList;
	}
	public void addFlight(Flight f) {
		this.flightList.put(f.getFlightNumber(),f);
	}
	
}
