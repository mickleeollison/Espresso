package com.catalyst.training.expresso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.catalyst.training.expresso.daos.UserDao;
import com.catalyst.training.expresso.entities.User;


/**
 * The Service Implementation for a user. All service validation gets called from here.
 * @author cmiller
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDao userDao;
	
	/**
	 * Returns a list of users from the database
	 * @author cmiller
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * Sends a User to the dao layer.
	 * @author cmiller
	 * @return 
	 */
	@Override
	public boolean createUser(User user) {
			String encryptedPass = encoder.encode(user.getUserPassword());
			user.setUserPassword(encryptedPass);
			userDao.createUser(user);
			boolean result = true;
		return result;
	}
	/**
	 * Retrieves an employee by their username.
	 * @param username
	 * @return employee
	 */
	@Override
	public User getEmployeeByUsername(String username) {
		return userDao.getEmployeeByUsername(username);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setEncoder(BCryptPasswordEncoder encoder){
		this.encoder = encoder;
	}
}
