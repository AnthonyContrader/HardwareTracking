package it.contrader.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;
import it.contrader.dao.EmployeeDAO;
import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Employee;
import it.contrader.model.Item;

@Service
public class EmployeeService extends AbstractService<Employee, EmployeeDTO>{
	
	@Autowired
	EmployeeDAO dao;
	
	@Transactional
	public void addItem(int itemId, int employeeId) {
		
		dao.add(itemId, employeeId);
		
	}
	
	
}
