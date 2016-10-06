package com.catalyst.training.expresso.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.entities.RecipeItem;
import com.catalyst.training.expresso.services.ExpressoService;

@Service
public class Validation {
	@Autowired
	ExpressoService service;

	public void setServices(ExpressoService service) {
		this.service = service;
	}
	 
	public final String NAME_REGEX = "[a-zA-Z0-9_ -]{1,30}";
	public final String NUMBER_REGEX = "[0-9.]{1,10}";
	public final String POSITIVEINT_REGEX = "[0-9]{1,10}";
	public final String ALLWHITE_REGEX = "^\\s*$"; 
	
	public boolean validateRegex(String str, String regex){
		boolean matches = str.matches(regex);
		if(regex.equals(ALLWHITE_REGEX)){
			return !matches;
		}
		else{
			return matches;
		}
	}
	
	

	public boolean uniqueIngredientName(Ingredient ing, List<Ingredient> ingredients) {
		String name = ing.getName();
		for(Ingredient i: ingredients){
			String iName = i.getName();
			if(name.equals( iName)&& i.getId() != ing.getId()){
				return false;
			}
		}
		return true; 
	}
 
	public boolean uniqueBakedGoodName(BakedGood good, List<BakedGood> goods) {
		String name = good.getName();
		for(BakedGood bg: goods){
			String bgName = bg.getName();
			if(name.equals( bgName) && bg.getId() != good.getId()){
				return false;
			}
		}
		return true;
	}
	
	public boolean uniqueDrinkName(Drink drink, List<Drink> drinks) {
		String name = drink.getName();
		for(Drink d: drinks){
			String dName = d.getName();
			if(name.equals( dName) && d.getId() != drink.getId()){
				return false;
			}
		}
		return true;
	}
	
	
	

}
