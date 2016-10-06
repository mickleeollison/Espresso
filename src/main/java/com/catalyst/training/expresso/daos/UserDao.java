package com.catalyst.training.expresso.daos;

import java.util.List;

import com.catalyst.training.expresso.entities.User;


public interface UserDao {

	/**
	 * GET
	 * Url "/user/get
	 * Returns a list of all users.
	 * @author cmiller
	 */
	List<User> getAllUsers();

	/**
	 * POST
	 * Url "/user/post
	 * Sends a User through the layers and eventually persists in the dao.
	 * @author cmiller
	 */
	void createUser(User user);

	/**
	 * Retrieves an employee by their username.
	 * @param username
	 * @return employee
	 */
	User getEmployeeByUsername(String username);

}
