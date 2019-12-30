package easybooking.server.authorizationGateway;

public interface IAuthorization {
	public boolean logIn(String email, String password);
	public boolean signUp(String email, String password, String firstname, String lastname); 
}
