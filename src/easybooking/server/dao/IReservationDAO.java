package easybooking.server.dao;

import easybooking.server.data.classes.Reservation;

public interface IReservationDAO {
	
	public boolean storeReservation (Reservation reservation);
	
}
