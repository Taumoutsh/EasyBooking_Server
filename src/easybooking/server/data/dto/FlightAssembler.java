package easybooking.server.data.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import easybooking.server.data.classes.Airline;
import easybooking.server.data.classes.Airport;
import easybooking.server.data.classes.Flight;

public class FlightAssembler{

	public HashMap<String, ArrayList<FlightDTO>> assemble(HashMap<String, ArrayList<Flight>> flights){
		
		HashMap<String, ArrayList<FlightDTO>> fligthDTOs = new HashMap<>();
		
		for(Map.Entry<String, ArrayList<Flight>> flightLocation : flights.entrySet()) {
			ArrayList<FlightDTO> listFlights = new ArrayList<>();
			for(Flight flight : flightLocation.getValue()) {
				FlightDTO flightDTO	= new FlightDTO(flight.getFlightNumber(), flight.getTotalSeats(), flight.getRemainingSeats(),flight.getDepartureTimeDate(), flight.getArrivalTimeDate(), flight.getPrice(), flight.getAirline().getIdAirline(), flight.getDepatureAirport().getIdAirport(), flight.getDepatureAirport().getLocation(), flight.getArrivalAirport().getIdAirport(), flight.getArrivalAirport().getLocation());
				listFlights.add(flightDTO);
			}
			fligthDTOs.put(flightLocation.getKey(), listFlights);
		}
		return fligthDTOs;
	}
	
	public ArrayList<Flight> desassembleSocket(String informations){
		
		ArrayList<Flight> flights = new ArrayList<>();
		
		StringTokenizer separateFlightTokenizer = new StringTokenizer(informations, "//");  
	     while (separateFlightTokenizer.hasMoreTokens()) {
	    	 
	    	StringTokenizer flightTokenizer = new StringTokenizer(separateFlightTokenizer.nextToken(), "#");
	    	
	    	String flightNumber = flightTokenizer.nextToken();
	 		String totalSeats = flightTokenizer.nextToken();
	 		String remainingSeats = flightTokenizer.nextToken();
	 		String departureTimeDate = flightTokenizer.nextToken();
	 		String arrivalTimeDate = flightTokenizer.nextToken();
	 		String price = flightTokenizer.nextToken();
	 		String airlineCode = flightTokenizer.nextToken();
	 		String depatureAirportLocation = flightTokenizer.nextToken();
	 		String depatureAirportCode = flightTokenizer.nextToken();
	 		String arrivalAirportLocation = flightTokenizer.nextToken();
	 		String arrivalAirportCode = flightTokenizer.nextToken();
	 		
	 		Airline airline = new Airline(airlineCode);
	 		
	 		Airport departureAirport = new Airport(depatureAirportCode, depatureAirportLocation);
	 		Airport arrivalAirport = new Airport(arrivalAirportCode, arrivalAirportLocation);
	 		
	 		Flight flight = new Flight(flightNumber, Integer.parseInt(totalSeats), Integer.parseInt(remainingSeats), departureTimeDate, arrivalTimeDate,
	 								   Integer.parseInt(price), airline, departureAirport, arrivalAirport);
	 		
	 		flights.add(flight);
	     }
	     
	     return flights;
	}
	
	public ArrayList<Flight> desassembleRMI(ArrayList<FlightDTO> flightsDTO){
		
		ArrayList<Flight> flights = new ArrayList<>();
		
		for(FlightDTO flight : flightsDTO) {
			
			String flightNumber = flight.getFlightNumber();
	 		int totalSeats = flight.getTotalSeats();
	 		int remainingSeats = flight.getRemainingSeats();
	 		String departureTimeDate = flight.getDepartureTimeDate();
	 		String arrivalTimeDate = flight.getArrivalTimeDate();
	 		int price = flight.getPrice();
	 		String airlineCode = flight.getAirlineCode();
	 		String depatureAirportLocation = flight.getDepatureAirportLocation();
	 		String depatureAirportCode = flight.getDepatureAirportCode();
	 		String arrivalAirportLocation = flight.getArrivalAirportLocation();
	 		String arrivalAirportCode = flight.getArrivalAirportCode();
	 		
	 		System.out.println("Assembler : "+depatureAirportLocation);
	 		
	 		
	 		Airline airline = new Airline(airlineCode);
	 		
	 		Airport departureAirport = new Airport(depatureAirportCode, depatureAirportLocation);
	 		Airport arrivalAirport = new Airport(arrivalAirportCode, arrivalAirportLocation);
			
			
			Flight finalFlight = new Flight(flightNumber, totalSeats, remainingSeats, departureTimeDate, arrivalTimeDate,
	 								   price, airline, departureAirport, arrivalAirport);
			
			flights.add(finalFlight);			
		}
		
		return flights;
		
	}
	
}
