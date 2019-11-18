package easybooking.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import easybooking.server.data.classes.Airline;

public class AirlineAssembler {

		public List<AirlineDTO> assemble(List<Airline> airlines) {
			List<AirlineDTO> airlineDTO = new ArrayList<>();

			for (Airline a : airlines) {
				airlineDTO.add(new AirlineDTO(a.getIdAirline()));
			}

			System.out.println("* Assembling TV Programs ...");
			
			return airlineDTO;
	}
}
