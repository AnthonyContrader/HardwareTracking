package it.contrader.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.contrader.model.Employee;



@Repository
public class EmployeeDAO implements DAOGeneralInterface<Employee>{
	
	@Autowired
	private EntityManager entityManager;
	
	public EmployeeDAO() {
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();
		
		return employees;
		
	}

	@Override
	public Employee update(Employee employee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.update(employee);
		
		return employee;
		
	}
	
	@Override
	public Employee save(Employee employee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(employee);
		
		return employee;
		
	}

	@Override
	public Employee findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
		
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();		
		
	}
	
	/*
	public void add(int itemId, int employeeId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, employeeId);
		
		Item item = currentSession.get(Item.class, itemId);
		
		Item tempItem = new Item();
		tempItem.setName(item.getName());
		tempItem.setPrice(item.getPrice());
		
		List<Item> itemsLent = employee.getItemsLent();
		
		//List<Employee> owners = item.getOwners();
		
		//owners.add(employee);
		
		if(itemsLent.add(tempItem))
			System.out.println("Ho aggiunto " + tempItem);
		
		currentSession.update(employee);
		
		for(Item x: itemsLent)
			System.out.println(x.getName());
	} */
	


}


