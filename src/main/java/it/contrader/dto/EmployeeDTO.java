package it.contrader.dto;

public class EmployeeDTO {
	
	private int id;

	private String firstName;
	
	private String lastName;
	
	private double salary;
	
	
	public EmployeeDTO() {		
	}
	
	public EmployeeDTO(int id, String firstName, String lastName, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return id + "\t" + firstName + "\t" + lastName + "\t" + salary;
			
	}

}
