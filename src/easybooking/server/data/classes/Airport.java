package easybooking.server.data.classes;


public class Airport {
	private String idAirport, location;
	public Airport(String idAirport, String location) {
		this.idAirport = idAirport;
		this.location = location;
	}

	public String getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(String idAirport) {
		this.idAirport = idAirport;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
