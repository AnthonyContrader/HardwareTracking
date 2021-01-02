package it.contrader.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.contrader.dto.EmployeeDTO;
import it.contrader.service.EmployeeService;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200") 
public class EmployeeController extends AbstractController<EmployeeDTO>{
	
	@Autowired
	EmployeeService employeeService;

}
