package com.catalyst.training.expresso.pageobject.pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.training.expresso.selenium_framework.TestPageObject;
import com.catalyst.training.expresso.selenium_pages.DrinkPage;
import com.catalyst.training.expresso.selenium_pages.IngredientPage;

public class DrinkPageEvaluation extends TestPageObject{
	
	@Test
    public void navigateToDrinkPage(){
		DrinkPage drink = new DrinkPage(driver);
        Assert.assertEquals(("http://localhost:8080/expresso-drinkRecipes"), drink.getUrl() );
    }
	
	/**
	 * Note: the successful/unsuccessful create, update and delete of entities is 
	 * evaluated via the entity id, which equals the entities name is added (and 
	 * removed when deleted) from the view table
	 */
	
	@Test
	public void happyCreateNewDrink(){
		String name = "drink" + String.valueOf(Math.random()).replace(".", "");
		DrinkPage i = new DrinkPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("description"), "fluffy");
		Select ingredients = new Select(driver.findElement(By.className("ingredients1")));
		ingredients.selectByIndex(2);
		i.sendKeys(By.className("amounts1"), "3");
		i.click(By.id("createdrink"));
		i.click(By.className("close"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}

	@Test
	public void happyRemoveDrink(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String name = "drink" + String.valueOf(Math.random()).replace(".", "");
		DrinkPage i = new DrinkPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("description"), "fluffy");
		Select ingredients = new Select(driver.findElement(By.className("ingredients1")));
		ingredients.selectByIndex(2);
		i.sendKeys(By.className("amounts1"), "3");
		i.click(By.id("createdrink"));
		i.click(By.className("closeit"));
		driver.navigate().refresh();
		i.click(By.id("dropdown"));
		i.click(By.id("delete_dropdown"));
		WebElement selectElement = driver.findElement(By.className("drinks1"));
		Select select = new Select(selectElement);
		select.selectByIndex(select.getOptions().size()-1);
		i.click(By.id("removeBtn"));

		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.find(By.id(name));
			assertTrue(false);
		}
		catch(Exception E){
			assertTrue(true);
		}
	}
	
	@Test
	public void happyUpdateDrink(){
		String name = "drink" + String.valueOf(Math.random()).replace(".", "").substring(10);
		DrinkPage i = new DrinkPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select drinks = new Select(driver.findElement(By.className("drinks2")));
		drinks.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.sendKeys(By.className("amounts2"), "3");
		i.click(By.id("updatedrink"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}
	
	@Test
	public void sadCantCreateDrinkWithInvalidData(){
		String name = "";
		DrinkPage i = new DrinkPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("description"), "fluffy");
		Select ingredients = new Select(driver.findElement(By.className("ingredients1")));
		ingredients.selectByIndex(2);
		i.sendKeys(By.className("amounts1"), "3");
		i.click(By.id("createdrink"));
		boolean drinkAdded = true;
		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			drinkAdded = false;
		}
		assertFalse(drinkAdded);
	}
	
	@Test
	public void sadCantUpdateDrinkWithInvalidData(){
		String name = "";
		DrinkPage i = new DrinkPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select drinks = new Select(driver.findElement(By.className("drinks2")));
		drinks.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.sendKeys(By.className("amounts2"), "3");
		i.click(By.id("updatedrink"));
		boolean drinkUpdated = true;
		try{
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			drinkUpdated = false;
		}
		assertFalse(drinkUpdated);
		}
	
	@Test
	public void sadCantCreateDrinkWithInsufficientInventory(){
		String name = "notadded";
		DrinkPage i = new DrinkPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("description"), "fluffy");
		Select ingredients = new Select(driver.findElement(By.className("ingredients1")));
		ingredients.selectByIndex(2);
		i.sendKeys(By.className("amounts1"), "1011");
		i.click(By.id("createdrink"));
		boolean drinkAdded = true;
		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			drinkAdded = false;
		}
		assertFalse(drinkAdded);
	}
	
	
}
