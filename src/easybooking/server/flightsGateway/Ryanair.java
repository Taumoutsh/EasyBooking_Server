package easybooking.server.flightsGateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import easybooking.server.data.classes.Airline;
import easybooking.server.data.classes.Airport;
import easybooking.server.data.classes.Flight;

public class Ryanair implements IFlightAirline {

	private HashMap<String, ArrayList<Flight>> allFlights = new HashMap<String, ArrayList<Flight>>();
	ArrayList<Flight> arrayFlights = new ArrayList<Flight>();
	
	public Ryanair() {
	
	Airline ai1 = new Airline("Eurowings");

	Airport a1 = new Airport("CDG", "Paris Charles De Gaulle");
	Airport a2 = new Airport("NYC", "New-York John Fidzgerald Kennedy");
	Airport a3 = new Airport("BIO", "Bilbao Aeropuerto");
	Airport a4 = new Airport("LON", "London Gatwick");
	Airport a5 = new Airport("AMS", "Amsterdam Schipol Airport");
	
	Flight f1 = new Flight("AF102", 100, 80, new Date(), new Date(), 30, ai1, a1, a2);
	Flight f2 = new Flight("AF202", 100, 80, new Date(), new Date(), 30, ai1, a1, a5);
	
	arrayFlights.add(f1);
	arrayFlights.add(f2);
	
	}
	
	public ArrayList<Flight> allFlights() {
		return arrayFlights;
	}
	
	public ArrayList<Flight> searchFlightDate(String depature, String destination) {
		
		ArrayList<Flight> flightByLocation = new ArrayList<Flight>();
		
		for(Flight flight : arrayFlights) {
			
			if(flight.getDepatureAirport().getLocation().equals(depature) || depature == null) {
				if(flight.getArrivalAirport().getLocation().equals(destination) || destination == null) {
					flightByLocation.add(flight);
				}
			}
			
		}
		
		return flightByLocation;
	}

}
