package com.catalyst.training.expresso.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="expense_user", schema="public")
public class User {
	
	/**
	 * Generates the user_id which is the primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	/**
	 * Required field for a user to input their password which is used
	 * to login to the app.
	 */
	@NotNull
	@Column(name="user_password")
	private String userPassword;

	/**
	 * Required field for a user to input their email which becomes their
	 * username in order to log into the app.
	 */
	@NotNull 
	@Column(name="user_email")
	private String userEmail;
	
	/**
	 * Generates a date when a user is added to the database.
	 */
	@Column(name="create_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date createDate = new Date();

	/**
	 * Getters and Setters
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}