package easybooking.server.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import easybooking.server.data.classes.Flight;
import easybooking.server.data.classes.Reservation;
import easybooking.server.data.dto.FlightDTO;
import easybooking.server.remote.IBookManager;

// THIS IS THE APPLICATION SERVICE CLASS
public class BookManager extends UnicastRemoteObject implements IBookManager {
	
	private static final long serialVersionUID = 1L;
	String serverName;
	
	public BookManager(String serverName) throws RemoteException {
		this.serverName = serverName;
	}
	
	public boolean pay(Reservation reservation) throws RemoteException{
		return false;
	}
	public boolean signUp(String email, String password, String firstname, String lastname)throws RemoteException{
		return false;
	}
	public boolean logIn(String email, String password) throws RemoteException{
		return false;
	}
	public boolean book(Flight flight) throws RemoteException{
		return false;
	}
	public Map<String, List<FlightDTO>> searchAirportDate(String origin, String destination, Timestamp timestampOrigin, Timestamp timestampDestination){
		return null;
	}
	public boolean chooseFlight(Flight flight) throws RemoteException{
		return false;
	}
}