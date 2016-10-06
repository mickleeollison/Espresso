package com.catalyst.training.expresso.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Drink {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
   @Column(nullable = false, unique = true, length=255)
   String name;
   @Column(nullable = false, unique = false, length=255)
   double cost;
   @ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
   @JoinTable
   @Column(nullable = false, length=255)
    List<RecipeItem> items;
	String description;
	@OneToOne
	User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<RecipeItem> getItems() {
		return items;
	}
	public void setItems(List<RecipeItem> amounts) {
		this.items = amounts;
	}
	  public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		

}
