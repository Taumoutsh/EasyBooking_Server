package easybooking.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import easybooking.server.data.dto.FlightDTO;

public interface IBookManager extends Remote {
	public int pay(String payingMethod) throws RemoteException;
	public boolean signUp(String authorizationService, String email, String password, String firstname, String lastname)throws RemoteException;
	public boolean logIn(String authorizationService, String email, String password) throws RemoteException;
	public boolean bookFlight(String flightNumber, String name1, String surname1, String name2, String surname2) throws RemoteException;
	public HashMap<String, ArrayList<FlightDTO>> searchFlight(String origin, String destination) throws RemoteException;
	public HashMap<String, ArrayList<FlightDTO>> printAllFlights() throws RemoteException;
}
