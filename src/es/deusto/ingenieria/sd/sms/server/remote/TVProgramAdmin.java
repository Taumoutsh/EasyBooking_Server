package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.server.TVProgramService;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramAssembler;

public class TVProgramAdmin extends UnicastRemoteObject implements ITVProgramAdmin {

	private static final long serialVersionUID = 1L;
	private TVProgramService progServ;
	private TVProgramAssembler pA;

	public TVProgramAdmin(TVProgramService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		pA = new TVProgramAssembler();
	}

	@Override
	public void newTVProgram(String acronym, String description) throws RemoteException {

			progServ.createTVProgram(acronym, description);

	}

	@Override
	public void closeTVProgram(String acronym) throws RemoteException {
		
		progServ.deleteTVProgram(acronym);

	}

	public List<TVProgramDTO> getTVPrograms() throws RemoteException {
		
		List<TVProgramDTO> programs = new ArrayList<>();
		programs = pA.assemble(progServ.getTVPrograms());
		
		return programs;
	}
}
