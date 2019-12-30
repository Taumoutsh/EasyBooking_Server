package easybooking.server.manager;

import java.rmi.Naming;

import easybooking.server.dao.IUserDAO;
import easybooking.server.dao.UserDAO;
import easybooking.server.data.classes.Airport;
import easybooking.server.data.classes.User;
import easybooking.server.remote.IBookManager;

public class BookManagerServer {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IBookManager service = new BookManager(args[2]);
			Naming.rebind(name, service);
			/*System.out.println("* Easybooking Service '" + args[2] + "' active and waiting...");
			User pascal = new User("test@gmail.com", 1, 1, new Airport("123", "Hamburg"));
			IUserDAO test = new UserDAO();
			test.signUpUser(pascal);*/
		} catch (Exception e) {
			System.err.println("$ Easybooking exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}