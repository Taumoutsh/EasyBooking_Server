package es.deusto.ingenieria.sd.sms.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.server.data.TVProgram;

public class TVProgramAssembler {

	public List<TVProgramDTO> assemble(List<TVProgram> programs) {
		List<TVProgramDTO> programsDTO = new ArrayList<>();

		for (TVProgram t : programs) {
			programsDTO.add(new TVProgramDTO(t.getAcronym(), t.getDescription()));
		}

		System.out.println("* Assembling TV Programs ...");
		
		return programsDTO;
	}
}
