package com.catalyst.training.expresso.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.training.expresso.entities.User;


/**
 * The Dao Implementation for a user. All interactions with the database exist here.
 * @author cmiller
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Returns a list of users from the database.
	 * @author cmiller
	 */
	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	/**
	 * Creates a user in the database.
	 * @author cmiller
	 */
	@Override
	public void createUser(User user) {
		em.merge(user);
	}

	@Override
	public User getEmployeeByUsername(String username) {
		return em.createQuery("SELECT u FROM User u WHERE u.userEmail = :userEmail", User.class)
				.setParameter("userEmail", username)
				.getSingleResult();
	}
}
