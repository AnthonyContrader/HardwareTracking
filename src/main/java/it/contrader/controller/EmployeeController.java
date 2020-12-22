package it.contrader.controller;

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
	
	@GetMapping("/request/{info}")
	public void request(@PathVariable("info") String info) {
		
		System.out.println(info);
		
		/*
		int employeeId = Integer.parseInt(info.substring(0,1));
		int itemId = Integer.parseInt(info.substring(1));
		
		EmployeeDTO tempEmployee = employeeService.read(employeeId);
		ItemDTO tempItem = itemService.read(itemId);
		
		tempEmployee.getItemsLent().add(itemConverter.toEntity(tempItem));
		*/
	}

}
