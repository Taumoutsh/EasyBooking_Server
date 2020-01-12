package easybooking.server.authorizationGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import easybooking.server.data.classes.User;

public class Facebook implements IAuthorization {
	
	ArrayList<User> accountUser;
	User userConnected;
	public Facebook() {
		userConnected = new User();
		accountUser = new ArrayList<User>();
		accountUser.add(new User("merger.pascal@gmail.com", "Deusto"));
		
	}

	@Override
	public User logIn(String email, String password) {
		
		for(User user : accountUser) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password))
				userConnected = new User(user.getEmail(), user.getPassword());
		}
		
		return userConnected;
	}

	@Override
	public boolean signUp(String email, String password, String firstname, String lastname) {
		if(!email.isEmpty() && !password.isEmpty())
			return false;
		else
			accountUser.add(new User(email, password));
			return true;
	}

}
