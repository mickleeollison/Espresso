package com.catalyst.training.expresso.pageobject.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.training.expresso.selenium_framework.TestPageObject;
import com.catalyst.training.expresso.selenium_pages.BakedGoodPage;
import com.catalyst.training.expresso.selenium_pages.IngredientPage;

public class BakedGoodPageEvaluation extends TestPageObject{
	
	@Test
    public void navigateToBakedGoodPage(){
		BakedGoodPage good = new BakedGoodPage(driver);
        Assert.assertEquals(("http://localhost:8080/expresso-baked_goods"), good.getUrl() );
    }
	
	/**
	 * Note: the successful/unsuccessful create, update and delete of entities is 
	 * evaluated via the entity id, which equals the entities name is added (and 
	 * removed when deleted) from the view table
	 */
	
	@Test
	public void happyCreateNewBakedGood(){
		String name = "good" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BakedGoodPage i = new BakedGoodPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("vendor"), "Company");
		i.sendKeys(By.id("inventory"), "5");
		i.click(By.id("creategood"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}
	@Test
	public void happyRemoveBakedGood(){
		String name = "good" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BakedGoodPage i = new BakedGoodPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("vendor"), "Company");
		i.sendKeys(By.id("inventory"), "5");
		i.click(By.id("creategood"));
		i.click(By.className("closeit"));
		driver.navigate().refresh();
		i.click(By.id("dropdown"));
		i.click(By.id("delete_dropdown"));
		WebElement selectElement = driver.findElement(By.className("goods1"));
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
	public void happyUpdateBakedGood(){
		driver.navigate().refresh();
		String name = "good" + String.valueOf(Math.random()).replace(".", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BakedGoodPage i = new BakedGoodPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select goods = new Select(driver.findElement(By.className("goods2")));
		goods.selectByIndex(2);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.click(By.id("updategood"));
		assertEquals(name, i.getInnerHtml(By.id(name)));
	}
	
	@Test
	public void sadCantCreateBakedGoodWithInvalidData(){
		String name = "";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BakedGoodPage i = new BakedGoodPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("add_dropdown"));
		i.sendKeys(By.id("name"), name);
		i.sendKeys(By.id("cost"), "3");
		i.sendKeys(By.id("vendor"), "Company");
		i.sendKeys(By.id("inventory"), "5");
		i.click(By.id("creategood"));
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
	public void sadCantUpdateBakedGoodWithInvalidData(){
		String name = "";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BakedGoodPage i = new BakedGoodPage(driver);
		i.click(By.id("dropdown"));
		i.click(By.id("update_dropdown"));
		Select goods = new Select(driver.findElement(By.className("goods2")));
		goods.selectByIndex(2);
		i.find(By.id("name_update")).clear();
		i.sendKeys(By.id("name_update"), name);
		i.click(By.id("updategood"));
		boolean updated = true;
		try{
			i.getInnerHtml(By.id(name));
		}
		catch(Exception E){
			updated = false;
		}
		assertFalse(updated);
	}
}
