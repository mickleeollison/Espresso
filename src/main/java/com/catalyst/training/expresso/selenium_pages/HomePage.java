package com.catalyst.training.expresso.selenium_pages;

import org.openqa.selenium.WebDriver;

import com.catalyst.training.expresso.selenium_framework.PageObject;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
    goTo("http://localhost:8080/");
	}

}
