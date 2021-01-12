package it.contrader.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.contrader.model.Item;

@Repository
public class ItemDAO implements DAOGeneralInterface<Item>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Item> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Item> theQuery = currentSession.createQuery("from Item", Item.class);

		List<Item> items = theQuery.getResultList();
		
		//4 - return the results
		
		return items;
		
	}
	

	@Override
	public Item findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Item item = currentSession.get(Item.class, id);
		
		return item;
	}

	@Override
	public Item save(Item item) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(item);
		
		return item;
		
	}
	
	@Override
	public Item update(Item item) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.update(item);
		
		return item;
		
	}


	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Item> query = currentSession.createQuery("delete from Item where id=:itemId");
		
		query.setParameter("itemId", id);
		
		query.executeUpdate();
	}


}
