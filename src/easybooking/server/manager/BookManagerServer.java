package easybooking.server.manager;

import java.rmi.Naming;

import easybooking.server.remote.IBookManage;

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
			IBookManage service = new BookManage(args[2]);
			Naming.rebind(name, service);
			System.out.println("* Easybooking Service '" + args[2] + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ Easybooking exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}