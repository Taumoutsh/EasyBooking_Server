package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITVProgramReceiver extends Remote {
    public void receiveMessage(String phone, String text) throws RemoteException;
}
