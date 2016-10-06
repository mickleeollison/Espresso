package com.catalyst.training.expresso.services_testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.catalyst.training.expresso.daos.ExpressoDaoImpl;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.entities.RecipeItem;
import com.catalyst.training.expresso.services.ExpressoServicesImpl;
import com.catalyst.training.expresso.validation.Validation;

public class ExpressoServiceTests {
	ExpressoServicesImpl service;
	ExpressoDaoImpl mockDao;
	Validation  mockValid;
	  
	@Before
	public void setup(){
		service = new ExpressoServicesImpl();
	    mockDao = mock(ExpressoDaoImpl.class);
	    service.setDao(mockDao);
	    mockValid = mock(Validation.class);  
	    service.setValidation(mockValid);
	}
	
	@Test
	public void happyAddBakedGood(){
		BakedGood bg = new BakedGood();
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.addBakedGood(bg));
	}
	
	@Test
	public void sadAddBakedGood(){
		BakedGood bg = new BakedGood();
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Unique Baked Good name constraint violated", service.addBakedGood(bg));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.addBakedGood(bg));
	}
	
	@Test
	public void happyAddDrink(){
		Drink d = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		RecipeItem item = new RecipeItem();
		item.setAmount(99);
		Ingredient i = new Ingredient();
		i.setInventory(100);
		i.setId(1);
		items.add(item);
		Ingredient ingredient = new Ingredient();
		ingredient.setInventory(100);
		ingredient.setId(1);
		item.setIngredient(ingredient);
		d.setItems(items);
		List<Ingredient> currentIngs = new ArrayList<Ingredient>();
		currentIngs.add(i);
		when(mockDao.getIngredients()).thenReturn(currentIngs);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.addDrink(d));
	}
	
	@Test
	public void sadAddDrink(){
		Drink d = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		RecipeItem item = new RecipeItem();
		item.setAmount(101);
		Ingredient i = new Ingredient();
		i.setInventory(100);
		i.setId(1);
		items.add(item);
		Ingredient ingredient = new Ingredient();
		ingredient.setInventory(100);
		ingredient.setId(1);
		item.setIngredient(ingredient);
		d.setItems(items);
		List<Ingredient> currentIngs = new ArrayList<Ingredient>();
		currentIngs.add(i);
		when(mockDao.getIngredients()).thenReturn(currentIngs);	
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Unique Drink Recipe name constraint violated", service.addDrink(d));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.addDrink(d));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		assertEquals("Error: Insufficient ingredients to create recipe, change amounts to amount equal to or less than amount in inventory", service.addDrink(d));
	}
	
	@Test
	public void happyAddIngredient(){
		Ingredient i = new Ingredient();
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.addIngredient(i));
	}
	
	@Test
	public void sadAddIngredient(){
		Ingredient i = new Ingredient();
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Ingredient Unique Name constraint violated", service.addIngredient(i));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.addIngredient(i));
	}
	
	@Test
	public void happyUpdateBakedGood(){
		BakedGood bg = new BakedGood();
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.updateBakedGood(bg));
	}
	
	@Test
	public void sadUpdateBakedGood(){
		BakedGood bg = new BakedGood();
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Unique Baked Good name constraint violated", service.updateBakedGood(bg));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueBakedGoodName(any(BakedGood.class),anyListOf(BakedGood.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.updateBakedGood(bg));
	}
	
	@Test
	public void happyUpdateDrink(){
		Drink d = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		RecipeItem item = new RecipeItem();
		item.setAmount(99);
		Ingredient i = new Ingredient();
		i.setInventory(100);
		i.setId(1);
		Ingredient g = new Ingredient();
		g.setInventory(100);
		g.setId(1);
		item.setIngredient(i);
		items.add(item);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient();
		ingredient.setInventory(100);
		ingredient.setId(1);
		ingredients.add(ingredient);
		d.setItems(items);
		List<Ingredient> currentIngs = new ArrayList<Ingredient>();
		currentIngs.add(i);
		when(mockDao.getDrink(any(Integer.class))).thenReturn(d);
		when(mockDao.getIngredient(any(Integer.class))).thenReturn(g);
		when(mockDao.getIngredients()).thenReturn(currentIngs);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.updateDrink(d));
	}
	
	@Test
	public void sadUpdateDrink(){
		Drink d = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		RecipeItem item = new RecipeItem();
		item.setAmount(101);
		Ingredient i = new Ingredient();
		i.setInventory(100);
		i.setId(1);
		Ingredient g = new Ingredient();
		g.setInventory(100);
		g.setId(1);
		item.setIngredient(i);
		items.add(item);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient();
		ingredient.setInventory(100);
		ingredient.setId(1);
		ingredients.add(ingredient);
		d.setItems(items);
		List<Ingredient> currentIngs = new ArrayList<Ingredient>();
		currentIngs.add(i);
		when(mockDao.getDrink(any(Integer.class))).thenReturn(d);
		when(mockDao.getIngredient(any(Integer.class))).thenReturn(g);
		when(mockDao.getIngredients()).thenReturn(currentIngs);		
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Unique Drink Recipe name constraint violated", service.updateDrink(d));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.updateDrink(d));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		when(mockValid.uniqueDrinkName(any(Drink.class),anyListOf(Drink.class))).thenReturn(true);
		assertEquals("Error: Insufficient ingredients to update recipe, change amounts to amount equal to or less than amount in inventory", service.updateDrink(d));
	}
	
	@Test
	public void happyUpdateIngredient(){
		Ingredient i = new Ingredient();
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(true);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals(null, service.updateIngredient(i));
	}
	
	@Test
	public void sadUpdateIngredient(){
		Ingredient i = new Ingredient();
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(false);
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(true);
		assertEquals("Error: Ingredient Unique Name constraint violated", service.updateIngredient(i));
		when(mockValid.validateRegex(any(String.class),any(String.class))).thenReturn(false);
		when(mockValid.uniqueIngredientName(any(Ingredient.class),anyListOf(Ingredient.class))).thenReturn(true);
		assertEquals("Error: input data invalid", service.updateIngredient(i));
	}
	
	@Test
	public void happyDeleteIngredient(){
		int id = 2;
		List<Drink> drinks = new ArrayList<Drink>();
		Drink drink = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		drinks.add(drink);
		RecipeItem r = new RecipeItem();
		r.setId(1);
		Ingredient i = new Ingredient();
		i.setId(3);
		r.setIngredient(i);
		items.add(r);
		drink.setItems(items);
		when(mockDao.getDrinks()).thenReturn(drinks);
		assertEquals(null, service.deleteIngredient(id));

	}
	
	@Test
	public void sadDeleteIngredient(){
		int id = 2;
		List<Drink> drinks = new ArrayList<Drink>();
		Drink drink = new Drink();
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		drinks.add(drink);
		RecipeItem r = new RecipeItem();
		r.setId(1);
		Ingredient i = new Ingredient();
		i.setId(2);
		r.setIngredient(i);
		items.add(r);
		drink.setItems(items);
		when(mockDao.getDrinks()).thenReturn(drinks);
		assertEquals("Error: Ingredient currently in use for a drink recipe, cannot remove.", service.deleteIngredient(id));
	}

}
