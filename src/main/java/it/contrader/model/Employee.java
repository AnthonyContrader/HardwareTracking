package it.contrader.model;

public class Employee {
	
	private String idFC;

	private String firstName;
	
	private String lastName;
	
	private double salary;
	
	
	public Employee() {		
	}
	
	
	public Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	public Employee(String idFC, String firstName, String lastName, double salary) {
		this.idFC = idFC;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getIdFC() {
		return this.idFC;
	}
	
	public void setIdFC(String idFC) {
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
		

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idFC != other.idFC)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}


	
	
	
}
