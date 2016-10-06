package com.catalyst.training.expresso.daos;

import java.util.List;

import com.catalyst.training.expresso.entities.Allergen;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Category;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;

public interface ExpressoDao {
	/**
	 * get List of allergens from the database
	 * @return List of allergens
     */
	List<Allergen> getAllergens();
	/**
	 * get allergen from the database
	 * @return allergen
     */
	Allergen getAllergen(int id);
	/**
	 * get List of categories from the database
	 *  @param id of the Allergen
	 * @return List of categories
     */
	List<Category> getCategories();
	/**
	 * get category from the database
	 ** @param id of the Category
	 * @return category
     */
	Category getCategory(int id);
	/**
	 * get List of baked goods from the database
	 * @return List of baked goods
     */
	List<BakedGood> getBakedGoods();
	/**
	 * get baked good from the database
	 * @param id of the BakedGood
	 * @return baked good
     */
	BakedGood getBakedGood(int id);
	/**
	 * adds a bakedgood in the database
	 * @param bakedgood
	 * @return void
     */
	void addBakedGood(BakedGood bg);
	/**
	 * Remove a bakedgood by id
	 * @param id the id of the bakedgood
	 * @return void
     */
	void deleteBakedGood(int id);
	/**
	 * update a bakedgood in the database
	 * @param bakedgood
	 * @return void
     */
	void updateBakedGood(BakedGood bg); 
	/**
	 * get List of ingredients from the database
	 * @return List of ingredients
     */
	List<Ingredient> getIngredients();
	/**
	 * get ingredient from the database
	 ** @param id of the Ingredient
	 * @return ingredient
     */
	Ingredient getIngredient(int id);
	/**
	 * adds an ingredient in the database
	 * @param ingredient
	 * @return void
     */
	void addIngredient(Ingredient ingredient);
	/**
	 * Remove a ingredient by id
	 * @param id the id of the ingredient
	 * @return void
     */
	void deleteIngredient(int id);
	/**
	 * update an ingredient in the database
	 * @param ingredient
	 * @return void
     */
	void updateIngredient(Ingredient ingredient);
	/**
	 * get List of drinks from the database
	 * @return List of drinks
     */
	List<Drink> getDrinks();
	/**
	 * get drink from the database
	 * @param id of the Drink
	 * @return drink
     */
	Drink getDrink(int id);
	/**
	 * adds a drink in the database
	 * @param drink
	 * @return void
    */
	void addDrink(Drink drink);
	/**
	 * Remove a drink by id
	 * @param id the id of the drink
	 * @return void
     */
	void deleteDrink(int id);
	/**
	 * update a drink in the database
	 * @param drink
	 * @return void
     */
	void updateDrink(Drink drink);
}
