package com.catalyst.training.expresso.validation_testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import com.catalyst.training.expresso.daos.ExpressoDaoImpl;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.entities.RecipeItem;
import com.catalyst.training.expresso.services.ExpressoService;
import com.catalyst.training.expresso.services.ExpressoServicesImpl;
import com.catalyst.training.expresso.validation.Validation;


public class ExpressoValidationTests {
	ExpressoServicesImpl mockService;
	Validation valid;
	
	@Before
	public void setUp(){
		mockService = mock(ExpressoServicesImpl.class); 
		valid = new Validation();
	}
	@Test
	public void testValidateRegexHappyNumber(){
		assertTrue(valid.validateRegex("345", valid.NUMBER_REGEX));
	}
	@Test
	public void testValidateRegexSadNumber(){
		assertFalse(valid.validateRegex("12345678901", valid.NUMBER_REGEX));
	}
	@Test
	public void testValidateRegexHappyName(){
		assertTrue(valid.validateRegex("Name ", valid.NAME_REGEX));
	}
	@Test
	public void testValidateRegexSadName(){
		assertFalse(valid.validateRegex("Name %", valid.NUMBER_REGEX));
	}
	@Test
	public void testValidateRegexHappyNotWhite(){
		assertTrue(!valid.validateRegex(" 	", valid.ALLWHITE_REGEX));
	}
	@Test
	public void testValidateRegexSadNotWhite(){
		assertFalse(!valid.validateRegex("1", valid.ALLWHITE_REGEX));
	}
	@Test
	public void happyUniqueIngredientName(){
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient();
		ingredient.setName("name");
		ingredient.setId(1);
		ingredients.add(ingredient);
		Ingredient i = new Ingredient();
		i.setName("different_name");
		i.setId(2);
		assertTrue(valid.uniqueIngredientName(i, ingredients));
		i.setId(1);
		assertTrue(valid.uniqueIngredientName(i, ingredients));
		i.setName("name");
		assertTrue(valid.uniqueIngredientName(i, ingredients));
	}
	@Test
	public void sadUniqueIngredientName(){
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient();
		ingredient.setName("name");
		ingredient.setId(1);
		ingredients.add(ingredient);
		Ingredient i = new Ingredient();
		i.setName("name");
		i.setId(2);
		assertFalse(valid.uniqueIngredientName(i, ingredients));
	}
	@Test
	public void happyUniqueBakedGoodName(){
		List<BakedGood> goods = new ArrayList<BakedGood>();
		BakedGood good = new BakedGood();
		good.setName("name");
		good.setId(1);
		goods.add(good);
		BakedGood g = new BakedGood();
		g.setName("different_name");
		g.setId(2);
		assertTrue(valid.uniqueBakedGoodName(g, goods));
		g.setId(1);
		assertTrue(valid.uniqueBakedGoodName(g, goods));
		g.setName("name");
		assertTrue(valid.uniqueBakedGoodName(g, goods));
	}
	@Test
	public void sadUniqueBakedGoodName(){
		List<BakedGood> goods = new ArrayList<BakedGood>();
		BakedGood good = new BakedGood();
		good.setName("name");
		good.setId(1);
		goods.add(good);
		BakedGood g = new BakedGood();
		g.setName("name");
		g.setId(2);
		assertFalse(valid.uniqueBakedGoodName(g, goods));
	}
	@Test
	public void happyUniqueDrinkName(){
		List<Drink> drinks = new ArrayList<Drink>();
		Drink drink = new Drink();
		drink.setName("name");
		drink.setId(1);
		drinks.add(drink);
		Drink d = new Drink();
		d.setName("different_name");
		d.setId(2);
		assertTrue(valid.uniqueDrinkName(d, drinks));
		d.setId(1);
		assertTrue(valid.uniqueDrinkName(d, drinks));
		d.setName("name");
		assertTrue(valid.uniqueDrinkName(d, drinks));
	} 
	@Test
	public void sadUniqueDrinkName(){
		List<Drink> drinks = new ArrayList<Drink>();
		Drink drink = new Drink();
		drink.setName("name");
		drink.setId(1);
		drinks.add(drink);
		Drink d = new Drink();
		d.setName("name");
		d.setId(2);
		assertFalse(valid.uniqueDrinkName(d, drinks));
	}
	

}
