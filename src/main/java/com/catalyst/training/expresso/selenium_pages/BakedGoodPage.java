package com.catalyst.training.expresso.selenium_pages;

import org.openqa.selenium.WebDriver;

import com.catalyst.training.expresso.selenium_framework.PageObject;

public class BakedGoodPage extends PageObject{

	public BakedGoodPage(WebDriver driver) {
		super(driver);
	    goTo("http://localhost:8080/expresso-baked_goods");

	}

}
