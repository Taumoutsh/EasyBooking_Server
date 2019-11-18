package easybooking.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import easybooking.server.data.classes.Flight;
import easybooking.server.data.classes.Reservation;
import easybooking.server.data.dto.FlightDTO;

public interface IBookManager extends Remote {
	public boolean pay(Reservation reservation) throws RemoteException;
	public boolean signUp(String email, String password, String firstname, String lastname)throws RemoteException;
	public boolean logIn(String email, String password) throws RemoteException;
	public boolean book(Flight flight) throws RemoteException;
	public Map<String, List<FlightDTO>> searchAirportDate(String origin, String destination, Timestamp timestampOrigin, Timestamp timestampDestination);
	public boolean chooseFlight(Flight flight) throws RemoteException;
}
