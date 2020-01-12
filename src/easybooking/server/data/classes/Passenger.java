package easybooking.server.data.classes;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Passenger {
	private String name, surname;
	private Reservation reservation;

	public Passenger(String name, String surname, Reservation reservation) {
		this.name = name;
		this.surname = surname;
		this.reservation = reservation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
