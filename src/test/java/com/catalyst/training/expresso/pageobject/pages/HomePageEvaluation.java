package com.catalyst.training.expresso.pageobject.pages;

import org.junit.Assert;
import org.junit.Test;

import com.catalyst.training.expresso.selenium_framework.TestPageObject;
import com.catalyst.training.expresso.selenium_pages.HomePage;

public class HomePageEvaluation extends TestPageObject{
	
	@Test
    public void navigateToNewProject(){
		HomePage home = new HomePage(driver);
        Assert.assertEquals(("http://localhost:8080/"), home.getUrl() );
    }
}
