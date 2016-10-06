package com.catalyst.training.expresso.selenium_framework;

import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;


public abstract class TestPageObject {
    protected WebDriver driver;
    protected SeleniumSettings seleniumSettings;

	@Before
	public void setUp() {
		seleniumSettings = new SeleniumSettings();
        driver = seleniumSettings.getDriver();		
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}





