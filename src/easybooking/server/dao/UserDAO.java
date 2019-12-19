package easybooking.server.dao;

import easybooking.server.data.classes.User;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class UserDAO implements IUserDAO {
	
	private PersistenceManagerFactory pmf;
	
	public UserDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public boolean signUpUser(User user) {
		boolean successful = false;
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing new User: " + user);
	       pm.makePersistent(user);
	       tx.commit();
	       successful = true;
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing new User: " + ex.getMessage());
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
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(String email, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
