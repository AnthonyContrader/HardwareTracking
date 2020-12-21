package it.contrader.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.contrader.model.ItemLent;

@Repository
public class ItemLentDAO implements DAOGeneralInterface<ItemLent>{
	
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ItemLent> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ItemLent> theQuery = currentSession.createQuery("from ItemLent", ItemLent.class);

		List<ItemLent> items = theQuery.getResultList();
		
		return items;
		
	}
	

	@Override
	public ItemLent findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		ItemLent itemLent = currentSession.get(ItemLent.class, id);
		
		return itemLent;
	}

	@Override
	public ItemLent save(ItemLent itemLent) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(itemLent);
		
		//save/update the customer
		return itemLent;
		
	}
	
	@Override
	public ItemLent update(ItemLent itemLent) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.update(itemLent);
		
		//save/update the customer
		return itemLent;
		
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<ItemLent> query = currentSession.createQuery("delete from ItemLent where id=:itemLentId");
		
		query.setParameter("itemLentId", id);
		
		query.executeUpdate();
	}


}
