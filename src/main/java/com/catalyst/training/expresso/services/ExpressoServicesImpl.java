package com.catalyst.training.expresso.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.training.expresso.daos.ExpressoDao;
import com.catalyst.training.expresso.entities.Allergen;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Category;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.entities.RecipeItem;
import com.catalyst.training.expresso.validation.Validation;


@Service
public class ExpressoServicesImpl implements ExpressoService{
	
	@Autowired
	Validation valid;
	public void setValidation(Validation valid) {
		this.valid = valid;
	}
	@Autowired
	ExpressoDao dao;

	public void setDao(ExpressoDao dao) {
		this.dao = dao;
	}
	@Override
	public List<Allergen> getAllergens() {
		return dao.getAllergens();
	}

	@Override
	public Allergen getAllergen(int id) {
		return dao.getAllergen(id);
	}

	@Override
	public List<BakedGood> getBakedGoods() {
		return dao.getBakedGoods();
	}

	@Override
	public BakedGood getBakedGood(int id) {
		return dao.getBakedGood(id);
	}  

	@Override
	public String addBakedGood(BakedGood bg) {
		//validate for unique name
		if(!valid.uniqueBakedGoodName(bg, dao.getBakedGoods())){
			return "Error: Unique Baked Good name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(bg.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(bg.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(bg.getVendor(), valid.NAME_REGEX) && valid.validateRegex(String.valueOf(bg.getInventory()),valid.POSITIVEINT_REGEX)){
		dao.addBakedGood(bg);
		return null;
		}
		return "Error: input data invalid";
	}
 
	@Override
	public String deleteBakedGood(int id) {
		dao.deleteBakedGood(id);
		return null;
	}

	@Override
	public String updateBakedGood(BakedGood bg) {
		//validate for unique name
		if(!valid.uniqueBakedGoodName(bg, dao.getBakedGoods())){
			return "Error: Unique Baked Good name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(bg.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(bg.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(bg.getVendor(), valid.NAME_REGEX) && valid.validateRegex(String.valueOf(bg.getInventory()),valid.POSITIVEINT_REGEX)){
		dao.updateBakedGood(bg);
		return null;
		}
		return "Error: input data invalid";
	}

	@Override
	public List<Ingredient> getIngredients() {
		return dao.getIngredients();
	}

	@Override
	public Ingredient getIngredient(int id) {
		return dao.getIngredient(id);
	}

	@Override
	public String addIngredient(Ingredient ingredient) {
		//validate for unique name
		if(!valid.uniqueIngredientName(ingredient, dao.getIngredients())){
			return "Error: Ingredient Unique Name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(ingredient.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(ingredient.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(ingredient.getUnitOfMeasure(), valid.ALLWHITE_REGEX) && valid.validateRegex(String.valueOf(ingredient.getInventory()),valid.POSITIVEINT_REGEX)){
			dao.addIngredient(ingredient);
		return null;
		}
		return "Error: input data invalid";
	}

	@Override
	public String deleteIngredient(int id) {
		//before deleting, check that Ingredient is not in use of a Drink
		List<Drink> drinks = dao.getDrinks();
		for(Drink drink: drinks){
			List<RecipeItem> items = drink.getItems();
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			for(RecipeItem r: items){
				ingredients.add(r.getIngredient());
			}
			for(Ingredient ingredient: ingredients){
				if(ingredient.getId()==id){
					return "Error: Ingredient currently in use for a drink recipe, cannot remove.";				}
			}
		}
		dao.deleteIngredient(id);
		return null;

	}
 
	@Override
	public String updateIngredient(Ingredient ingredient) {
		//validate for unique name
		if(!valid.uniqueIngredientName(ingredient, dao.getIngredients())){
			return "Error: Ingredient Unique Name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(ingredient.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(ingredient.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(ingredient.getUnitOfMeasure(), valid.ALLWHITE_REGEX) && valid.validateRegex(String.valueOf(ingredient.getInventory()),valid.POSITIVEINT_REGEX)){
			dao.updateIngredient(ingredient);
			return null;
			}
		return "Error: input data invalid";

	}
	
	@Override
	public List<Drink> getDrinks() {
		return dao.getDrinks();
	}

	@Override
	public Drink getDrink(int id) {
		return dao.getDrink(id);
	}

	@Override
	public String addDrink(Drink drink) {
		//validate for unique name
		if(!valid.uniqueDrinkName(drink, dao.getDrinks())){
			return "Error: Unique Drink Recipe name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(drink.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(drink.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(drink.getDescription(), valid.ALLWHITE_REGEX)){
			List<Ingredient> placeholder = dao.getIngredients();
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			boolean inStock = true;
			for(RecipeItem r: drink.getItems()){
				for(Ingredient ing: placeholder){
					if(ing.getId() == r.getIngredient().getId()){
						ingredients.add(ing);
					}
				}
			}
			for(int i = 0; i < ingredients.size(); i++){
				if(ingredients.get(i).getInventory() < drink.getItems().get(i).getAmount()){
					inStock = false;
				}
			}
			if(inStock){
				for(int i = 0; i < ingredients.size(); i++){
					ingredients.get(i).setInventory((ingredients.get(i).getInventory() - drink.getItems().get(i).getAmount()));
					dao.updateIngredient(ingredients.get(i));
				}
				dao.addDrink(drink);
				return null;
			}
			else{
					return "Error: Insufficient ingredients to create recipe, change amounts to amount equal to or less than amount in inventory";
				}
			}
		return "Error: input data invalid";
	}

	@Override
	public String deleteDrink(int id) {
		List<Ingredient> placeholder = dao.getIngredients();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Drink drink = dao.getDrink(id);
		for(RecipeItem r: drink.getItems()){
			for(Ingredient ing: placeholder){
				if(ing.getId() == r.getIngredient().getId()){
					ingredients.add(ing);
				}
			}
		}
		for(int i = 0; i < drink.getItems().size(); i++){
			Ingredient ingredient = dao.getIngredient(drink.getItems().get(i).getIngredient().getId());
			ingredient.setInventory(ingredient.getInventory() + drink.getItems().get(i).getAmount());
		}
		dao.deleteDrink(id);
		return null;
	}

	@Override
	public String updateDrink(Drink drink) {
		//validate for unique name
		if(!valid.uniqueDrinkName(drink, dao.getDrinks())){
			return "Error: Unique Drink Recipe name constraint violated";
		}
		//validate entity properties against regex before sending to database
		if(valid.validateRegex(drink.getName(),valid.NAME_REGEX) && valid.validateRegex(String.valueOf(drink.getCost()),valid.NUMBER_REGEX) 
				&& valid.validateRegex(drink.getDescription(), valid.ALLWHITE_REGEX)){
			Drink d = dao.getDrink(drink.getId());
			for(int i = 0; i < d.getItems().size(); i++){
				Ingredient ingredient = dao.getIngredient(d.getItems().get(i).getIngredient().getId());
				ingredient.setInventory(ingredient.getInventory() + d.getItems().get(i).getAmount());
			}
			List<Ingredient> placeholder = getIngredients();
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			boolean inStock = true;
			for(RecipeItem r: drink.getItems()){
				for(Ingredient ing: placeholder){
					if(ing.getId() == r.getIngredient().getId()){
						ingredients.add(ing);
					}
				}
			}
			for(int i = 0; i < ingredients.size(); i++){
				if(ingredients.get(i).getInventory() < drink.getItems().get(i).getAmount()){
					inStock = false;
				}
			}
			if(inStock){
				for(int i = 0; i < ingredients.size(); i++){
					ingredients.get(i).setInventory((ingredients.get(i).getInventory() - drink.getItems().get(i).getAmount()));
					updateIngredient(ingredients.get(i));
					dao.updateDrink(drink);
				}
				return null;
			}
			else{
				for(int i = 0; i < d.getItems().size(); i++){
					Ingredient ingredient = dao.getIngredient(d.getItems().get(i).getIngredient().getId());
					ingredient.setInventory(ingredient.getInventory() - d.getItems().get(i).getAmount());
				}
				return "Error: Insufficient ingredients to update recipe, change amounts to amount equal to or less than amount in inventory";

			}
			
		}
		return "Error: input data invalid";
	}
	
	@Override
	public List<Category> getCategories() {
		return dao.getCategories();
	}
	@Override
	public Category getCategory(int id) {
		return dao.getCategory(id);
	}
	

	
	
}
