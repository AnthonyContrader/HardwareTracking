package it.contrader.converter;

import it.contrader.dto.EmployeeDTO;
import it.contrader.model.Employee;

import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter extends AbstractConverter<Employee, EmployeeDTO>{
	
	@SuppressWarnings("null")
	@Override
	public Employee toEntity(EmployeeDTO employeeDTO) {
		Employee employee = null;
		if (employeeDTO != null) {
			employee = new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
								employeeDTO.getSalary(), employeeDTO.getFiscalCode(), 
								employeeDTO.getUser());
		}
		return employee;
	}

	@Override
	public EmployeeDTO toDTO(Employee employee) {
		EmployeeDTO employeeDTO = null;
		if (employee != null) {
			employeeDTO = new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(),
									employee.getSalary(), employee.getFiscalCode(), 
									employee.getUser());

		}
		return employeeDTO;
	}


}
