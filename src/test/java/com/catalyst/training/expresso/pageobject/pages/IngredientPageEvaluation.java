package com.catalyst.training.expresso.pageobject.pages;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.training.expresso.selenium_framework.PageObject;
import com.catalyst.training.expresso.selenium_framework.TestPageObject;
import com.catalyst.training.expresso.selenium_pages.HomePage;
import com.catalyst.training.expresso.selenium_pages.IngredientPage;
import com.google.common.collect.Iterables;
import com.thoughtworks.selenium.Wait;

public class IngredientPageEvaluation extends TestPageObject{
	String name;
	@Test
    public void navigateToIngredientsPage(){
		IngredientPage ingredient = new IngredientPage(driver);
        Assert.assertEquals(("http://localhost:8080/expresso-ingredients"), ingredient.getUrl() );
    }
	
	/**
	 * Note: the successful/unsuccessful create, update and delete of entities is 
	 * evaluated via the entity id, which equals the entities name is added (and 
	 * removed when deleted) from the view table
	 */
	
	@Test
	public void happyCreateNewIngredient(){
		name = "Ingredient" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("inventory"), "5");
		i.sendKeys(By.id("unitofmeasure"), "fluffy");
		i.click(By.id("createingredient"));
		i.click(By.className("close"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}

	@Test
	public void happyRemoveIngredient(){
		name = "Ingredient" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("inventory"), "5");
		i.sendKeys(By.id("unitofmeasure"), "fluffy");
		i.click(By.id("createingredient"));
		i.click(By.className("closeit"));
		driver.navigate().refresh();
		i.click(By.id("dropdown"));
		i.click(By.id("delete_dropdown"));
		WebElement selectElement = driver.findElement(By.className("ingredients1"));
		Select select = new Select(selectElement);
		select.selectByIndex(select.getOptions().size()-1);
		i.click(By.id("removeBtn"));

		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.find(By.id(name));
			assertTrue(false);
		}
		catch(Exception E){
			//expected to execute
			assertTrue(true);
		}
		
	}
	
	@Test
	public void happyUpdateIngredient(){
		String name = "Ingredient" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select ingredients = new Select(driver.findElement(By.className("ingredients2")));
		ingredients.selectByIndex(2);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.click(By.id("updateingredient"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}
	
	@Test
	public void sadCantCreateIngredientWithInvalidData(){
		String name = "";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("inventory"), "5");
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("unitofmeasure"), "fluffy");
		i.click(By.id("createingredient"));
		i.click(By.className("close"));
		boolean added = true;
		try{
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			added = false;
		}
		assertFalse(added);
		}
	
	
	@Test
	public void sadCantUpdateIngredientWithInvalidData(){
		String name = "";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select ingredients = new Select(driver.findElement(By.className("ingredients2")));
		ingredients.selectByIndex(2);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.click(By.id("updateingredient"));
		boolean updated = true;
		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			updated = false;
		}
		assertFalse(updated);
		}
	/*ingredient must be available and in use at the time of running this test,
	  which is the case upon first running the app*/
	
	@Test
	public void sadCantRemoveIngredientInUse(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		IngredientPage i = new IngredientPage(driver);
		driver.navigate().refresh();
		i.click(By.id("dropdown"));
		i.click(By.id("delete_dropdown"));
		WebElement selectElement = driver.findElement(By.className("ingredients1"));
		Select select = new Select(selectElement);
		String item = select.getOptions().get(1).getText();
		select.selectByIndex(1);
		i.click(By.id("removeBtn"));

		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.find(By.id(item));
			assertTrue(false);
		}
		catch(Exception E){
			//expected to execute
			assertTrue(true);
		}
	}
	
	
}
