package com.catalyst.training.expresso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PageControllers {
	/**
     * Controller to navigate to the home page
     * @return String with location of html page to get
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/index.html";
	}

}
