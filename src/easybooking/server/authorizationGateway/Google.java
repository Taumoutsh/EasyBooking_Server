package easybooking.server.authorizationGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import easybooking.server.data.classes.User;

public class Google implements IAuthorization, Cloneable {
	
	ArrayList<User> accountUser;
	User userConnected;
	
	public Google() {
		
		userConnected = new User();
		accountUser = new ArrayList<User>();
		accountUser.add(new User("1", "1", 1, 2));
		
	}

	@Override
	public User logIn(String email, String password) {
		
		for(User user : accountUser) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password))
				userConnected = new User(user.getEmail(), user.getPassword(), user.getAuthorizationMethod(), user.getPaymentMethod());
		}
		System.out.println(userConnected.getEmail()+" Google");
		return userConnected;
	}

	@Override
	public boolean signUp(String email, String password, String firstname, String lastname) {
		if(!email.isEmpty() && !password.isEmpty())
			return false;
		else
			accountUser.add(new User(email, password, 1, 1));
			return true;
	}


}
