package com.catalyst.training.expresso.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BakedGood {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(nullable = false, unique = true, length=255)
    String name;
	@Column(nullable = false)
	double cost;
	@Column(nullable = false, length=255)
    String vendor;
	@ManyToMany
	List<Allergen> allergens;
	@ManyToOne
    Category category;
	public int getId() {
		return id;
	}
	@OneToOne
	User user;
	@Column(nullable = false)
	int inventory;
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public List<Allergen> getAllergens() {
		return allergens;
	}
	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
