package it.contrader.dao;



import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import it.contrader.model.ItemLent;

@Repository
public class ItemLentDAO{
	
	
	@Autowired
	private EntityManager entityManager;
	
	public ItemLentDAO() {
		
	}
	
	
	public List<ItemLent> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ItemLent> theQuery = currentSession.createQuery("from ItemLent", ItemLent.class);

		List<ItemLent> items = theQuery.getResultList();
		
		return items;
		
	}
	


	public ItemLent save(ItemLent itemLent) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(itemLent);
		
		return itemLent;
		
	}
	
	
	
	public void delete(String fiscalCode, String itemName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<ItemLent> query = currentSession.createQuery("delete from ItemLent x where "
				+ "x.fiscalCodeForLent=:fiscalCode AND x.itemName=:itemName");
		
		query.setParameter("fiscalCode", fiscalCode);
		query.setParameter("itemName", itemName);
		
		query.executeUpdate();
	}
	


}
