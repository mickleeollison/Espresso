package com.catalyst.training.expresso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.training.expresso.entities.User;
import com.catalyst.training.expresso.services.UserService;

/**
 * User Controller class. Has all the end points for Post, Put, Delete, Get.
 * 
 * @author cmiller
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * GET
	 * Url "/user
	 * Returns a list of all users.
	 * @author cmiller
	 */
	@RequestMapping(value="users", method = RequestMethod.GET)
	public  List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	/**
	 * POST
	 * Url "/user
	 * Sends a User through the layers and eventually persists in the dao.
	 * @author cmiller
	 */
	@RequestMapping(value="users", method = RequestMethod.POST)
	public void createUser(@RequestBody User user){
		userService.createUser(user);
	}
}
