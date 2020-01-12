package easybooking.server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import easybooking.server.data.classes.Passenger;

public class PassengerDAO implements IPassengerDAO{
	
	private PersistenceManagerFactory pmf;
	
	public PassengerDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public boolean storePassenger(Passenger passenger) {
		boolean successful = false;
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing new Reservation: " + passenger);
	       pm.makePersistent(passenger);
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
	    
	    return successful;
	}

}
