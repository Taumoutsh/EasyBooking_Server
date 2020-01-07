package easybooking.server.authorizationGateway;

import easybooking.server.data.classes.User;

public interface IAuthorization {
	public User logIn(String email, String password);
	public boolean signUp(String email, String password, String firstname, String lastname); 
}
