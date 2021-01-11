package it.contrader.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.dao.EmployeeDAO;
import it.contrader.dto.EmployeeDTO;

import it.contrader.model.Employee;


@Service
public class EmployeeService extends AbstractService<Employee, EmployeeDTO>{
	
	@Autowired
	EmployeeDAO dao;
	
	/*
	
	@Transactional
	public void addItem(int itemId, int employeeId) {
		
		dao.add(itemId, employeeId);
		
	}
	  */
	
}
