package easybooking.server.flightsGateway;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import easybooking.server.data.classes.Flight;

public interface IFlightAirline {
	public ArrayList<Flight> allFlights();
	// public ArrayList<Flight> searchFlightDate(String depature, String destination);
}
