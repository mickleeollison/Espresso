package com.catalyst.training.expresso.services;

import java.util.List;

import com.catalyst.training.expresso.entities.Allergen;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Category;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;

public interface ExpressoService {
	/**
	 * Return a list of All Allergen in the database
	 * @return List of Allergen
     */
	List<Allergen> getAllergens();
	/**
	 * Get a Allergen by id from the database
	 * @param id of the Allergen
	 * @return Allergen
     */
	Allergen getAllergen(int id);
	/**
	 * Return a list of All Category in the database
	 * @return List of Category
     */
	List<Category> getCategories();
	/**
	 * Get a Category by id from the database
	 * @param id of the Category
	 * @return Category
     */
	Category getCategory(int id);
	/**
	 * Return a list of All BakedGood in the database
	 * @return List of BakedGood
     */
	List<BakedGood> getBakedGoods();
	/**
	 * Get a BakedGood by id from the database
	 * @param id of the BakedGood
	 * @return BakedGood
     */
	BakedGood getBakedGood(int id);
	/**
	 * Add a BakedGood to the database
	 * @param BakedGood MUST NOT HAVE ID SET
	 * @return String, null or error message
     */
	String addBakedGood(BakedGood bg);
	/**
	 * Deletes a BakedGood from the database
	 * @param id the id of the BakedGood to remove
	 * @return String, null or error message
     */
	String deleteBakedGood(int id);
	/**
	 * Updates a BakedGood to the database
	 * @param BakedGood MUST HAVE ID SET
	 * @return String, null or error message
     */
	String updateBakedGood(BakedGood bg);
	/**
	 * Return a list of All Ingredient in the database
	 * @return List of Ingredient
     */
	List<Ingredient> getIngredients();
	/**
	 * Get an Ingredient by id from the database
	 * @param id of the Ingredient
	 * @return Ingredient
     */
	Ingredient getIngredient(int id);
	/**
	 * Add a Ingredient to the database
	 * @param Ingredient MUST NOT HAVE ID SET
	 * @return String, null or error message
     */
	String addIngredient(Ingredient ingredient);
	/**
	 * Deletes an Ingredient from the database
	 * @param id the id of the Ingredient to remove
	 * @return String, null or error message
     */
	String deleteIngredient(int id);
	/**
	 * Updates an Ingredient to the database
	 * @param Ingredient MUST HAVE ID SET
	 * @return String, null or error message
     */
	String updateIngredient(Ingredient ingredient);
	/**
	 * Return a list of All Drink in the database
	 * @return List of Drink
     */
	List<Drink> getDrinks();
	/**
	 * Get a Drink by id from the database
	 * @param id of the Drink
	 * @return Drink
     */
	Drink getDrink(int id);
	/**
	 * Add a Drink to the database
	 * @param Drink MUST NOT HAVE ID SET
	 * @return String, null or error message
     */
	String addDrink(Drink drink);
	/**
	 * Deletes a Drink from the database
	 * @param id the id of the Drink to remove
	 * @return String, null or error message
     */
	String deleteDrink(int id);
	/**
	 * Updates a Drink to the database
	 * @param Drink MUST HAVE ID SET
	 * @return String, null or error message
     */
	String updateDrink(Drink drink);
}
