package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Employee;
import it.contrader.model.User;

public class EmployeeConverter {
	
	public EmployeeDTO toDTO(Employee employee) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getFirstName(),
								employee.getLastName(), employee.getSalary());
			
		return employeeDTO;
		
	}
	
	public Employee toEntity(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getFirstName(),
							employeeDTO.getLastName(), employeeDTO.getSalary());
		
		return employee;
		
	}
	
	public List<EmployeeDTO> toDTOList(List<Employee> employeeList) {
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		
		for(Employee employee : employeeList) {
			
			employeeDTOList.add(toDTO(employee));
		}
		return employeeDTOList;
	}

}
