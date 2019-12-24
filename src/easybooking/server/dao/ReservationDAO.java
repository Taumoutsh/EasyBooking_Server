package easybooking.server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import easybooking.server.data.classes.Reservation;

public class ReservationDAO implements IReservationDAO{
	
	private PersistenceManagerFactory pmf;
	
	public ReservationDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public boolean storeReservation(Reservation reservation) {
		boolean successful = false;
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing new Reservation: " + reservation);
	       pm.makePersistent(reservation);
	       tx.commit();
	       successful = true;
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing new Reservation: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	    if(successful) {
	    	System.out.println("Endlich");	
	    }
	    return successful;
	}

	@Override
	public boolean deleteReservation(String reservationCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation getReservation(String reservationCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
