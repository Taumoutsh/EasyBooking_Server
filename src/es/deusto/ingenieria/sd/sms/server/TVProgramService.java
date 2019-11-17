package es.deusto.ingenieria.sd.sms.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import es.deusto.ingenieria.sd.sms.server.data.TVProgram;

// THIS IS THE APPLICATION SERVICE CLASS
public class TVProgramService {

	private Map<String, TVProgram> programs = new TreeMap<String, TVProgram>();

	public TVProgramService() {
		programs.put("BBR", new TVProgram("BBR", "BIG BROTHER"));
		programs.put("CGO", new TVProgram("CGO", "CELEBRITY GOSSIP"));
	}

	public synchronized void createTVProgram(String acronym, String description) {

		boolean tvProgramExists = false;
		
		for (Map.Entry<String, TVProgram> entry : programs.entrySet()) {
			if(acronym.equals(entry.getKey())) {
				tvProgramExists = true;
			}
		}
		
		if(tvProgramExists == false) {
			programs.put(acronym, new TVProgram(acronym, description));
			System.out.println("* Creating a new TV Program: " + acronym + " , " + description);
		}
		else {
			System.err.println("* The TV Program already exists !");
		}	
	}

	public synchronized void deleteTVProgram(String acronym) {
		
		for (Map.Entry<String, TVProgram> entry : programs.entrySet()) {
			if(acronym.equals(entry.getKey())) {
				programs.remove(entry.getKey(), entry.getValue());
			}
		}
		
		System.out.println("* Removing TV Program: " + acronym);
		
	}

	public synchronized List<TVProgram> getTVPrograms() {
		
		List<TVProgram> listPrograms = new ArrayList<TVProgram>();
		
		System.out.println("* Retrieving TV Programs ...");

		
		for (Map.Entry<String, TVProgram> entry : programs.entrySet()) {
			listPrograms.add(entry.getValue());
		}
		
		return listPrograms;
	}

	public synchronized void receiveMessage(String phone, String text) {
		String acronym = text.substring(0, 3);
		String mes = text.substring(4);
		boolean progExists = false;
		
		for (Map.Entry<String, TVProgram> entry : programs.entrySet()) {
			if(acronym.equals(entry.getKey())) {
				progExists = true;
				System.out.println("The message "+mes+" has been sent for the program "+acronym);
			}
		}
		
		if(progExists == false) System.out.println("A received message and has been ignored");
	}

	private synchronized TVProgram findTVProgram(String acro) {
		return programs.get(acro);
	}
}