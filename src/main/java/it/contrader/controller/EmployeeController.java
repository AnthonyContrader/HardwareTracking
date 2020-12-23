package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.Converter;
import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Employee;
import it.contrader.model.Item;
import it.contrader.service.EmployeeService;
import it.contrader.service.ItemService;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200") 
public class EmployeeController extends AbstractController<EmployeeDTO>{
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ItemService itemService;
	@Autowired
	Converter<Item, ItemDTO> itemConverter;
	@Autowired
	Converter<Employee, EmployeeDTO> employeeConverter;
	

	@GetMapping("/request/{info}")
	public void request(@PathVariable("info") String info) {
		
		
		System.out.println(info);
		
		int itemId = Integer.parseInt(info.substring(0,1));
		int employeeId = Integer.parseInt(info.substring(1));
		
		employeeService.addItem(itemId, employeeId);
		
		
	}
	
	@GetMapping("/track")
	public List<EmployeeDTO> track(){
		
		List<EmployeeDTO> employees = employeeService.getAll();
		List<EmployeeDTO> employeesWithItems = new ArrayList<>();
		
		for(EmployeeDTO tempEmployee: employees) {
			if(!tempEmployee.getItemsLent().isEmpty())
				employeesWithItems.add(tempEmployee);
		}
		
		return employeesWithItems;
	}

}
