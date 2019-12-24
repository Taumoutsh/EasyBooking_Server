package easybooking.server.payingGateway;

public interface IPayment {
	
	public void payPayPal(int code);
	public void payVisa(int code);
	public void payMastercard(int code);
	
}
