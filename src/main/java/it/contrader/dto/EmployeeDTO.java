package it.contrader.dto;


public class EmployeeDTO {
	
	private String idFC;

	private String firstName;
	
	private String lastName;
	
	private double salary;
	
	
	public EmployeeDTO() {		
	}
	
	
	public EmployeeDTO(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	public EmployeeDTO(String idFC, String firstName, String lastName, double salary) {
		this.idFC = idFC;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getIdFC() {
		return idFC;
	}

	public void setId(String idFC) {
		this.idFC = idFC;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return idFC + "\t" + firstName + "\t" + lastName + "\t" + salary;
			
	}
		



}
