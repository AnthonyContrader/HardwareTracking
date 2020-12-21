package it.contrader.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

@Repository
public class UserDAO implements UserRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	
	public UserDAO() {
	}
	
	@Override
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();
		
		return users;
		
	}

	@Override
	public User save(User user) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(user);
		
		return user;
		
	}
	
	@Override
	public User update(User user) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.update(user);
		
		return user;
		
	}

	@Override
	public User findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		User user = currentSession.get(User.class, id);
		
		return user;
		
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", id);
		
		theQuery.executeUpdate();		
		
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> query = currentSession.createQuery("from User u where u.username='"
				+ username + "' AND u.password='" + password + "'", User.class);
		
		User user = query.getSingleResult();
		
		return user;
		
	}
	
	
	
	

}
