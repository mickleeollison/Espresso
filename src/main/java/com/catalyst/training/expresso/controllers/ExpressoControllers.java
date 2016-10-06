package com.catalyst.training.expresso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.training.expresso.entities.Allergen;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Category;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.services.ExpressoService;

@RestController
@CrossOrigin(origins = "http://appmollison.s3-website-us-west-2.amazonaws.com")
public class ExpressoControllers {
	@Autowired
	ExpressoService service;

	public void setServices(ExpressoService service) {
		this.service = service;
	}
	@RequestMapping(value="/drinks", method=RequestMethod.GET)
	public List<Drink> getDrinks() {
			return	service.getDrinks();
	}

	@RequestMapping(value="/drinks/{id}", method=RequestMethod.GET)
	public Drink getDrink(@PathVariable Integer id) {
		return service.getDrink(id);
	}

	@RequestMapping(value="/drinks", method=RequestMethod.POST)
	public String addDrink(@RequestBody Drink drink) {
		 return service.addDrink(drink);
	}

	@RequestMapping(value="/drinks/{id}", method=RequestMethod.DELETE)
	public String deleteDrink(@PathVariable Integer id) {
		return service.deleteDrink(id);
	}

	@RequestMapping(value="/drinks/{id}", method=RequestMethod.PUT)
	public String updateDrink(@PathVariable Integer id, @RequestBody Drink drink) {
		drink.setId(id);
		return service.updateDrink(drink);
	}

	@RequestMapping(value="/ingredients", method=RequestMethod.GET)
	public List<Ingredient> getIngredients() {
		return service.getIngredients();
	}

	@RequestMapping(value="/ingredients/{id}", method=RequestMethod.GET)
	public Ingredient getIngredient(@PathVariable Integer id) {
		return service.getIngredient(id);
	}

	@RequestMapping(value="/ingredients", method=RequestMethod.POST)
	public String addIngredient(@RequestBody Ingredient ingredient) {
		return service.addIngredient(ingredient);
	}
	
	@RequestMapping(value="/ingredients/{id}", method=RequestMethod.PUT)
	public String updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
		ingredient.setId(id);
		return service.updateIngredient(ingredient);
	}

	@RequestMapping(value="/ingredients/{id}", method=RequestMethod.DELETE)
	public String deleteHero(@PathVariable Integer id) {
		return service.deleteIngredient(id);	
	}
	
	@RequestMapping(value="/bakedgoods", method=RequestMethod.GET)
	public List<BakedGood> getBakedGoods() {
		return service.getBakedGoods();
	}

	@RequestMapping(value="/bakedgoods/{id}", method=RequestMethod.GET)
	public BakedGood getBakedGood(@PathVariable Integer id) {
		return service.getBakedGood(id);
	}

	@RequestMapping(value="/bakedgoods", method=RequestMethod.POST)
	public String addBakedGood(@RequestBody BakedGood bakedGood) {
		return service.addBakedGood(bakedGood);
	}
	
	@RequestMapping(value="/bakedgoods/{id}", method=RequestMethod.PUT)
	public String updateBakedGood(@PathVariable Integer id, @RequestBody BakedGood bakedGood) {
		bakedGood.setId(id);
		return service.updateBakedGood(bakedGood);
	}

	@RequestMapping(value="/bakedgoods/{id}", method=RequestMethod.DELETE)
	public String deleteBakedGood(@PathVariable Integer id) {
		return service.deleteBakedGood(id);		
	}
	
	@RequestMapping(value="/allergens", method=RequestMethod.GET)
	public List<Allergen> getAllergens() {
		return service.getAllergens();
	}
	@RequestMapping(value="/allergens/{id}", method=RequestMethod.GET)
	public Allergen getAllergen(@PathVariable Integer id) {
		return service.getAllergen(id);
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<Category> getCategories() {
		return service.getCategories();
	}
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public Category getCategory(@PathVariable Integer id) {
		return service.getCategory(id);
	}

}
