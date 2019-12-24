package easybooking.server.dao;

import easybooking.server.data.classes.User;

public interface IUserDAO {
	
	public boolean signUpUser (User user);
	public User getUser (String email);
	public boolean updateUser (String email, User user);
	public boolean deleteUser (String email);
}
