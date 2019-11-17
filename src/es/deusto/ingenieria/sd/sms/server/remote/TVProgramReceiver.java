package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.ingenieria.sd.sms.server.TVProgramService;

public class TVProgramReceiver extends UnicastRemoteObject implements ITVProgramReceiver {

	private static final long serialVersionUID = 1L;
	private TVProgramService progServ;
	
	public TVProgramReceiver(TVProgramService p) throws RemoteException {
		super();
		progServ = p;
	}

	@Override
	public void receiveMessage(String phone, String text) throws RemoteException {
		progServ.receiveMessage(phone, text);	
	}
}