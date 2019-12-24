package easybooking.server.payingGateway;

public class Payment {
	private int code;
	
	public void payPayPal(int code) {
		this.code = code;
	}
	
	public void payVisa(int code) {
		this.code = code;
	}
	
	public void payMastercard(int code) {
		this.code = code;
	}
}
