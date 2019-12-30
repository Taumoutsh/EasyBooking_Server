package easybooking.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import easybooking.server.data.classes.Flight;
import easybooking.server.data.classes.Reservation;
import easybooking.server.data.dto.FlightDTO;

public interface IBookManager extends Remote {
	public boolean pay() throws RemoteException;
	public boolean signUp(String email, String password, String firstname, String lastname)throws RemoteException;
	public boolean logIn(String email, String password) throws RemoteException;
	public boolean bookFlight(FlightDTO flight) throws RemoteException;
	public HashMap<String, ArrayList<FlightDTO>> searchFlight(String origin, String destination) throws RemoteException;
}
