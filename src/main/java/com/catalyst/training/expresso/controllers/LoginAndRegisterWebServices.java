package com.catalyst.training.expresso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAndRegisterWebServices {

	/**
	 * function that specifies end for Spring Security
	 * This end point has to be specified in the 
	 * Spring Security Configuration
	 * @return loginpage.html
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/loginpage.html";
	}
	
	/**
	 * this is the end point for the register page
	 * This end is allowed and configured by 
	 * Spring Security
	 * @return registerPage.html
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(){
		return "/registerPage.html";
	}
}
