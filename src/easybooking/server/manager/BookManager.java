package easybooking.server.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import easybooking.server.authorizationGateway.AuthorizationGatewayFactory;
import easybooking.server.authorizationGateway.IAuthorization;
import easybooking.server.data.classes.Airline;
import easybooking.server.data.classes.Airport;
import easybooking.server.data.classes.Flight;
import easybooking.server.data.classes.Reservation;
import easybooking.server.data.dto.FlightAssembler;
import easybooking.server.data.dto.FlightDTO;
import easybooking.server.flightsGateway.Eurowings;
import easybooking.server.flightsGateway.IFlightAirline;
import easybooking.server.flightsGateway.Lufthansa;
import easybooking.server.flightsGateway.Ryanair;
import easybooking.server.remote.IBookManager;

// THIS IS THE APPLICATION SERVICE CLASS
public class BookManager extends UnicastRemoteObject implements IBookManager {
	
	private ArrayList<Flight> cacheFlights = new ArrayList<>();
	private HashMap<String, ArrayList<Flight>> allFlights = new HashMap<String, ArrayList<Flight>>();
	
	private static final long serialVersionUID = 1L;
	String serverName;
	IAuthorization authorization;
	
	public BookManager(String serverName) throws RemoteException {
		this.serverName = serverName;
		
	}
	
	public boolean pay() throws RemoteException{
		return false;
	}
	
	public boolean signUp(String email, String password, String firstname, String lastname) throws RemoteException{
		
		AuthorizationGatewayFactory.getAuthorizationGatewayFactory();
		
		IAuthorization authorization = AuthorizationGatewayFactory.createGateway("Google");
		
		boolean result = authorization.signUp(email,  password, firstname, lastname);
		return result;
	}
	
	public boolean logIn(String email, String password) throws RemoteException{
		
		AuthorizationGatewayFactory.getAuthorizationGatewayFactory();
		
		IAuthorization authorization = AuthorizationGatewayFactory.createGateway("Google");
		
		boolean result = authorization.logIn(email,  password);
		return result;
	}
	
	public HashMap<String, ArrayList<FlightDTO>> searchFlight(String origin, String destination){
		
		FlightAssembler fa = new FlightAssembler();
		HashMap<String, ArrayList<FlightDTO>> allFlightsDTO = new HashMap<String, ArrayList<FlightDTO>>();
		
		// Calling the Airlines Gateway
		
		IFlightAirline eurowings = new Eurowings();
		ArrayList<Flight> eurowingsFlights = eurowings.searchFlightDate(origin, destination);
		
		IFlightAirline lufthansa = new Lufthansa();
		ArrayList<Flight> lufthansaFlights = lufthansa.searchFlightDate(origin, destination);
		
		IFlightAirline ryanair = new Ryanair();
		ArrayList<Flight> ryanairFlights = ryanair.searchFlightDate(origin, destination);
		
		allFlights.put("Eurowings", eurowingsFlights);
		allFlights.put("Lufthansa", lufthansaFlights);
		allFlights.put("RyanAir", ryanairFlights);
		
		allFlightsDTO = fa.assemble(allFlights);
		
		return allFlightsDTO;
		
	}
	
	public HashMap<String, ArrayList<FlightDTO>> printAllFlights(){
		
		FlightAssembler fa = new FlightAssembler();
		HashMap<String, ArrayList<FlightDTO>> allFlightsDTO = new HashMap<String, ArrayList<FlightDTO>>();
		
		// Calling the Airlines Gateway
		
		IFlightAirline eurowings = new Eurowings();
		ArrayList<Flight> eurowingsFlights = eurowings.allFlights();
		
		IFlightAirline lufthansa = new Lufthansa();
		ArrayList<Flight> lufthansaFlights = lufthansa.allFlights();
		
		IFlightAirline ryanair = new Ryanair();
		ArrayList<Flight> ryanairFlights = ryanair.allFlights();
		
		allFlights.put("Eurowings", eurowingsFlights);
		allFlights.put("Lufthansa", lufthansaFlights);
		allFlights.put("RyanAir", ryanairFlights);
		
		allFlightsDTO = fa.assemble(allFlights);
		
		return allFlightsDTO;
	}
	
	public boolean bookFlight(FlightDTO flight) throws RemoteException{
		
		
		
		return false;
	}
	
	//This class is used to receive an Flight object for booking process because the user only receives an DTO object.
	private Flight findFlightInCache (FlightDTO flightDTO) {
		Flight returnFlight = new Flight();
		for(Flight flight : cacheFlights) {
			if(flight.getFlightNumber().equals(flightDTO.getFlightNumber())) {
				returnFlight = flight;
			}
		}
		return returnFlight;
	}
}