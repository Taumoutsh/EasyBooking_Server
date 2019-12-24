package easybooking.server.data.classes;

import java.util.ArrayList;
import java.util.Scanner;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")

public class Reservation{
	private int paymentCode, numberOfSeats;
	private ArrayList<Passenger> passenger;
	private Flight flight;
	
	//constructor
	public Reservation(ArrayList<Passenger> passenger, Flight flight) {
		this.paymentCode = -1;// this means the reservation is not paid, once the method pay() is used the payment code is changed
		this.numberOfSeats = passenger.size();
		this.passenger = passenger;
		this.flight = flight;
	}
	
	//getter setter
	public int getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public ArrayList<Passenger> getPassengers() {
		return passenger;
	}
	public void setPassengers(Passenger passenger) {
		this.passenger.add(passenger);
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return flight;
	}

	//method
	public void pay() {
		
		
		
		//This code should be used in payingGateway without Scanner, the information will be handeled by the supplier
		
		//choose the payment service
		/* int selection;
		 int paymentCode = 0;
		 Scanner entradaEscaner = new Scanner (System.in); //Creaci�n de un objeto Scanner
		do {
			 System.out.println ("Choose the service, please enter the number");
			 System.out.println ("1-VISA 2-MasterCard 3-PayPal");
			 selection = entradaEscaner.nextInt();
		} while (selection>4);

		if(selection == 1) {
			//use visa
			//ask for data
			System.out.println("insert credit card number: ");
			int cardNumber = entradaEscaner.nextInt();
			System.out.println("insert Name: ");
			String UserName = entradaEscaner.next();
			System.out.println("insert Surname: ");
			String UserSurname = entradaEscaner.next();
			System.out.println("insert credit card expiration month: ");
			int expirationMonth = entradaEscaner.nextInt();
			System.out.println("insert credit card expiration year: ");
			int expirationYear = entradaEscaner.nextInt();
			System.out.println("insert credit card criptogram: ");
			int criptogram = entradaEscaner.nextInt();
			//use the method
			paymentCode = payVisa(cardNumber, UserName, UserSurname, expirationMonth, expirationYear, criptogram);
			
		}else if(selection == 2) {
			//use Mastercard
			//ask for data
			System.out.println("insert credit card number: ");
			int cardNumber = entradaEscaner.nextInt();
			System.out.println("insert Name: ");
			String UserName = entradaEscaner.next();
			System.out.println("insert Surname: ");
			String UserSurname = entradaEscaner.next();
			System.out.println("insert credit card expiration month: ");
			int expirationMonth = entradaEscaner.nextInt();
			System.out.println("insert credit card expiration year: ");
			int expirationYear = entradaEscaner.nextInt();
			System.out.println("insert credit card criptogram: ");
			int criptogram = entradaEscaner.nextInt();
			//use the method
			paymentCode = payMasterCard(cardNumber, UserName, UserSurname, expirationMonth, expirationYear, criptogram);
			
		}else if(selection==3) {
			//use Paypal
			//ask for data
			System.out.println("insert email: ");
			String email = entradaEscaner.next();
			System.out.println("insert password: ");
			String password = entradaEscaner.next();
			//use the method
			paymentCode = payPayPal(email, password);
			
		}else {
			System.err.println("there has been a problem selecting the payment method");
		}
		
		this.paymentCode = paymentCode;//change the payment code*/
		
	}
	
	
	/*public int payPayPal(String email, String password) {
		//paypal authorizates the account
		System.out.println("acceding to the account of "+email);
		return (int) (Math.random()*Integer.MAX_VALUE);//this can cause repetition of paymentCode
	}

	public int payMasterCard(int cardNumber, String UserName, String UserSurname, int expirationMonth,
			int expirationYear, int criptogram) {
		return  (int) (Math.random()*Integer.MAX_VALUE);
	}

	public int payVisa(int cardNumber, String UserName, String UserSurname, int expirationMonth, int expirationYear,
			int criptogram) {
		return  (int) (Math.random()*Integer.MAX_VALUE);
	}*/
	
}
