package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public interface ITVProgramAdmin extends Remote {
	public List<TVProgramDTO> getTVPrograms()throws RemoteException;
	public void newTVProgram(String acronym, String description)throws RemoteException;
	public void closeTVProgram(String acronym)throws RemoteException;
}
