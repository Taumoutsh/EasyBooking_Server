package easybooking.server.flightsGateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import easybooking.server.data.classes.Flight;
import easybooking.server.data.dto.FlightAssembler;
import easybooking.server.data.dto.FlightDTO;
import server.IAirline;

public class AirlineRMI implements IFlightAirline {
	
	private IAirline service;
	private FlightAssembler fa;
	
	public AirlineRMI() {
		fa = new FlightAssembler();
	}
	
	public void setService() {
    	
    	String name = "//" + "127.0.0.1" + ":" + 1099 + "/" + "AirlineRMI_Server";
    	try {
    		service = (IAirline) java.rmi.Naming.lookup(name);
    		System.out.println("It works!");
    	}
    	catch(Exception e){
    		
    		System.out.println("Server not defined : ");
    		e.printStackTrace();	
    	}	
	}
	
	public IAirline getService() { 	
    	return service;
    }

	@Override
	public ArrayList<Flight> allFlights() {
		
		setService();
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
		ArrayList<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
		
		try {
			
			flightsDTO = service.allFlights();
			
			System.out.println("AirlineRMI (DTO) : "+flightsDTO.get(0).getArrivalAirportLocation());
			
			
			flights = fa.desassembleRMI(flightsDTO);
			
			System.out.println("AirlineRMI (No-DTO) : "+flights.get(0).getArrivalAirport().getLocation());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flights;
		
	}

}
