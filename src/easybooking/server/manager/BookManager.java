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
import easybooking.server.data.classes.Passenger;
import easybooking.server.data.classes.Reservation;
import easybooking.server.data.classes.User;
import easybooking.server.data.dto.FlightAssembler;
import easybooking.server.data.dto.FlightDTO;
import easybooking.server.flightsGateway.AirlineRMI;
import easybooking.server.flightsGateway.AirlineSocket;
import easybooking.server.flightsGateway.Eurowings;
import easybooking.server.flightsGateway.IFlightAirline;
import easybooking.server.flightsGateway.Lufthansa;
import easybooking.server.flightsGateway.Ryanair;
import easybooking.server.payingGateway.IPaymentAdapter;
import easybooking.server.payingGateway.MastercardAdapter;
import easybooking.server.payingGateway.PayPalAdapter;
import easybooking.server.payingGateway.VisaAdapter;
import easybooking.server.remote.IBookManager;

// THIS IS THE APPLICATION SERVICE CLASS
public class BookManager extends UnicastRemoteObject implements IBookManager {
	
	private ArrayList<Flight> cacheFlights = new ArrayList<>();
	private HashMap<String, ArrayList<Flight>> allFlights = new HashMap<String, ArrayList<Flight>>();
	
	private static final long serialVersionUID = 1L;
	String serverName;
	IAuthorization authorization;
	User userConnected;
	int paymentCode;
	
	public BookManager(String serverName) throws RemoteException {
		this.serverName = serverName;
		userConnected = new User();
		paymentCode = 0;
		
	}
	
	public int pay(String payingMethod) throws RemoteException{
		
		IPaymentAdapter paymentAdapter = null;
		
		if(payingMethod.equals("Visa")){
			paymentAdapter = new VisaAdapter();
		}
		if(payingMethod.equals("Mastercard")){
			paymentAdapter = new MastercardAdapter();
		}
		if(payingMethod.equals("PayPal")){
			paymentAdapter = new PayPalAdapter();
		}
		
		this.paymentCode = paymentAdapter.pay();
		
		return paymentCode;
	}
	
	public User getUser() {
		return userConnected;
	}
	
	public boolean signUp(String authorizationService, String email, String password, String firstname, String lastname) throws RemoteException{
		
		AuthorizationGatewayFactory.getAuthorizationGatewayFactory();
		
		IAuthorization authorization = AuthorizationGatewayFactory.createGateway(authorizationService);
		
		boolean result = authorization.signUp(email,  password, firstname, lastname);
		return result;
	}
	
	public boolean logIn(String authorizationService, String email, String password) throws RemoteException{
		
		boolean connected = false;
		
		System.out.println("Bonjour");
		
		AuthorizationGatewayFactory.getAuthorizationGatewayFactory();
		
		IAuthorization authorization = AuthorizationGatewayFactory.createGateway(authorizationService);
		
		userConnected = authorization.logIn(email, password);
		
		System.out.println(userConnected.getEmail()+" BookManager");
		
		if(!(userConnected.getEmail() == null))
			connected = true;
		
		System.out.println(connected+" BookManager");
		
		return connected;
	}
	
	/*
	
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
	
	*/
	
	public HashMap<String, ArrayList<FlightDTO>> printAllFlights(){
		
		FlightAssembler fa = new FlightAssembler();
		HashMap<String, ArrayList<FlightDTO>> allFlightsDTO = new HashMap<String, ArrayList<FlightDTO>>();
		
		// Calling the Airlines Gateway
		
		IFlightAirline airlineSocket = new AirlineSocket();
		ArrayList<Flight> airlineSocketFlights = airlineSocket.allFlights();
		
		IFlightAirline airlineRMI = new AirlineRMI();
		ArrayList<Flight> airlineRMIFlights = airlineRMI.allFlights();
		
		/* IFlightAirline eurowings = new Eurowings();
		ArrayList<Flight> eurowingsFlights = eurowings.allFlights();
		
		IFlightAirline lufthansa = new Lufthansa();
		ArrayList<Flight> lufthansaFlights = lufthansa.allFlights();
		
		IFlightAirline ryanair = new Ryanair();
		ArrayList<Flight> ryanairFlights = ryanair.allFlights(); */
		
		allFlights.put("Airline Socket", airlineSocketFlights);
		allFlights.put("Airline RMI", airlineRMIFlights);
		
		//allFlights.put("Lufthansa", lufthansaFlights);
		//allFlights.put("RyanAir", ryanairFlights);
		
		allFlightsDTO = fa.assemble(allFlights);
		
		return allFlightsDTO;
	}
	
	public boolean bookFlight(String flightNumber, String name1, String surname1, String name2, String surname2) throws RemoteException{
		
		ArrayList<Passenger> arrayPassengers = new ArrayList<Passenger>();
		Flight bookedFlight = new Flight();
		
		if(!(name1.isBlank()) && !(surname1.isBlank())){
			if(!(name2.isBlank()) && !(surname2.isBlank())){
				Passenger p2 = new Passenger(name2, surname2);
				arrayPassengers.add(p2);
			}
			Passenger p1 = new Passenger(name1, surname1);
			System.out.println(name1);
			arrayPassengers.add(p1);
		}
		
		for(Map.Entry<String, ArrayList<Flight>> entry : allFlights.entrySet()) {
		    String key = entry.getKey();
		    ArrayList<Flight> value = entry.getValue();
		    
		    for(Flight flight : value) {
		    	if(flightNumber.equals(flight.getFlightNumber())){
		    		bookedFlight = new Flight(flight.getFlightNumber(), flight.getTotalSeats(), flight.getRemainingSeats(),
		    				flight.getDepartureTimeDate(), flight.getArrivalTimeDate(), flight.getPrice(),
		    				flight.getAirline(), flight.getDepatureAirport(), flight.getArrivalAirport());
		    	}
		    }
		}
		
		Reservation reservation = new Reservation(arrayPassengers, bookedFlight, userConnected, paymentCode);
		
		System.out.println("PRINT END OF PROCESS :");
		System.out.println("User connected is : "+userConnected.getEmail());
		System.out.println("The passengers are : ");
		
		for(Passenger p : arrayPassengers) {
			System.out.println(p.getName()+" "+p.getSurname());
		}
		
		System.out.println("The flight choosen is the : "+bookedFlight.getFlightNumber()+ " from "+bookedFlight.getDepatureAirport().getLocation()+" to "+bookedFlight.getArrivalAirport().getLocation());
		System.out.println("The payment code is : "+paymentCode);
		
		//TO DO -> ReservationDAO
		
		return false;
	}
}