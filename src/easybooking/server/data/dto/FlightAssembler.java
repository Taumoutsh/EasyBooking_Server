package easybooking.server.data.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
}
