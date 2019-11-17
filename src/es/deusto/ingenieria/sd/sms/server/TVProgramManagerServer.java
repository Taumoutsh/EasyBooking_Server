package es.deusto.ingenieria.sd.sms.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramReceiver;
import es.deusto.ingenieria.sd.sms.server.remote.TVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.TVProgramReceiver;

public class TVProgramManagerServer {

	public static void main(String[] args) {
		if (args.length != 4) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String nameAdmin = "//" + args[0] + ":" + args[1] + "/" + args[2];
		String nameReceiver = "//" + args[0] + ":" + args[1] + "/" + args[3];

		try {
			TVProgramService TVProgData = new TVProgramService();
			
			ITVProgramAdmin adminService = new TVProgramAdmin(TVProgData);			
			Naming.rebind(nameAdmin, adminService);
			System.out.println("* TVProgram Admin Service '" + nameAdmin + "' active and waiting...");
			
			ITVProgramReceiver receiverService = new TVProgramReceiver(TVProgData);
			Naming.rebind(nameReceiver, receiverService);
			System.out.println("* TVProgram Receiver Service '" + nameReceiver + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ TVProgramManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}