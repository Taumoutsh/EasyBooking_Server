package easybooking.server.flightsGateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import easybooking.server.data.classes.Flight;
import easybooking.server.data.dto.FlightAssembler;

public class AirlineSocket implements IFlightAirline {

	private String serverIP;
	private int serverPort;
	private FlightAssembler fa;
	private String data;
	
	public AirlineSocket() {
		
		serverIP = "0.0.0.0";
		serverPort = 35600;
		fa = new FlightAssembler();
		
	}

	@Override
	public ArrayList<Flight> allFlights() {
		
	
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){

				//Read response (a String) from the server
				
				String dataMain = in.readUTF();	
				
				data = dataMain;
				
				System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			} catch (UnknownHostException e) {
				System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
			} catch (EOFException e) {
				System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
			}
		
			ArrayList<Flight> flightList = fa.desassembleSocket(data);
			
			return flightList;
		
	}

	/* @Override
	public ArrayList<Flight> searchFlightDate(String depature, String destination) {
			try (Socket tcpSocket = new Socket(serverIP, serverPort);
					 //Streams to send and receive information are created from the Socket
				     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
					 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
					
					//Send request (a String) to the server
					
					System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + text + "'");
					out.writeUTF(text);

					//Read response (a String) from the server
					
					String dataMain = in.readUTF();	
					
					data = dataMain;
					
					System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
				} catch (UnknownHostException e) {
					System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
				} catch (EOFException e) {
					System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
				} catch (IOException e) {
					System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
				}
			
			return null;
	}
	*/
	
}
