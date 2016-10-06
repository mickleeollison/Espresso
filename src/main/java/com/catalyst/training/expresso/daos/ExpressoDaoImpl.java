package com.catalyst.training.expresso.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.training.expresso.entities.Allergen;
import com.catalyst.training.expresso.entities.BakedGood;
import com.catalyst.training.expresso.entities.Category;
import com.catalyst.training.expresso.entities.Drink;
import com.catalyst.training.expresso.entities.Ingredient;
import com.catalyst.training.expresso.entities.RecipeItem;

@Repository
@Transactional
public class ExpressoDaoImpl implements ExpressoDao{
	@PersistenceContext
	private EntityManager em;
	public void setEm(EntityManager em) {
		this.em = em;
	}
	@Override
	public List<Allergen> getAllergens() {
		return em.createQuery("SELECT a FROM Allergen a", Allergen.class).getResultList();
	}

	@Override
	public Allergen getAllergen(int id) {
		return em
				.createQuery("SELECT a FROM Allergen a WHERE a.id = :id", Allergen.class)
				.setParameter("id",  id)
				.getSingleResult();
	}

	@Override
	public List<BakedGood> getBakedGoods() {
		return em.createQuery("SELECT b FROM BakedGood b", BakedGood.class).getResultList();

	}

	@Override
	public BakedGood getBakedGood(int id) {
		return em
				.createQuery("SELECT b FROM BakedGood b WHERE b.id = :id", BakedGood.class)
				.setParameter("id",  id)
				.getSingleResult();
	}

	@Override
	public void addBakedGood(BakedGood bg) {
		em.merge(bg);
		
	}

	@Override
	public void deleteBakedGood(int id) {
		BakedGood bakedGood = em
				.createQuery("SELECT b FROM BakedGood b WHERE b.id = :id", BakedGood.class)
				.setParameter("id", id)
				.getSingleResult();
				em.remove(bakedGood);			
	}

	@Override
	public void updateBakedGood(BakedGood bg) {
		em.merge(bg);
		
	}

	@Override
	public List<Ingredient> getIngredients() {
		return em.createQuery("SELECT i FROM Ingredient i", Ingredient.class).getResultList();
	}

	@Override
	public Ingredient getIngredient(int id) {
		return em
				.createQuery("SELECT i FROM Ingredient i WHERE i.id = :id", Ingredient.class)
				.setParameter("id",  id)
				.getSingleResult();
	}

	@Override
	public void addIngredient(Ingredient ingredient) {
		em.merge(ingredient);
		
	}

	@Override
	public void deleteIngredient(int id) {
		Ingredient ingredient = em
				.createQuery("SELECT i FROM Ingredient i WHERE i.id = :id", Ingredient.class)
				.setParameter("id", id)
				.getSingleResult();
				em.remove(ingredient);		
	}

	@Override
	public void updateIngredient(Ingredient ingredient) {
		em.merge(ingredient);
		
	}

	@Override
	public List<Drink> getDrinks() {
		return em.createQuery("SELECT d FROM Drink d", Drink.class).getResultList();

	}

	@Override
	public Drink getDrink(int id) {
		return em
				.createQuery("SELECT d FROM Drink d WHERE d.id = :id", Drink.class)
				.setParameter("id",  id)
				.getSingleResult();
	}

	@Override
	public void addDrink(Drink drink) {
		
				em.merge(drink);
				
			}
	
	@Override
	public void deleteDrink(int id) {
		Drink drink = em
				.createQuery("SELECT d FROM Drink d WHERE d.id = :id", Drink.class)
				.setParameter("id", id)
				.getSingleResult();
	
				em.remove(drink);

	}

	@Override
	public void updateDrink(Drink drink) {
		
		em.merge(drink);
		
	}
	@Override
	public List<Category> getCategories() {
		return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	}
	@Override
	public Category getCategory(int id) {
		return em
				.createQuery("SELECT c FROM Category c WHERE c.id = :id", Category.class)
				.setParameter("id",  id)
				.getSingleResult();
	}

}
