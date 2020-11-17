package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Employee;
import it.contrader.model.User;

public class EmployeeDAO {
	
	public static final String QUERY_ALL = "SELECT * FROM employees";
	public static final String QUERY_CREATE = "INSERT INTO employees (firstName, lastName, salary) VALUES (?,?,?)";
	public static final String QUERY_READ = "SELECT * FROM employees WHERE id=?";
	public static final String QUERY_UPDATE = "UPDATE employees SET firstName=?, lastName=?, salary=? WHERE id=?";
	public static final String QUERY_DELETE = "DELETE FROM employees WHERE id=?"; 
	
	public EmployeeDAO(){
		
	}
	
	//------------------GET ALL
	
	public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Employee employee;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				double salary = resultSet.getDouble("salary");
				employee = new Employee(firstName, lastName, salary);
				employee.setId(id);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	//------------------INSERISCI NUOVO

public boolean insert(Employee employeeToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1, employeeToInsert.getFirstName());
		preparedStatement.setString(2, employeeToInsert.getLastName());
		preparedStatement.setDouble(3, employeeToInsert.getSalary());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		return false;
	}
	
}
	

//-------------------------VISUALIZZA
	
	public Employee read(int employeeId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String firstName, lastName;
			double salary;

			firstName = resultSet.getString("firstName");
			lastName = resultSet.getString("lastName");
			salary = resultSet.getDouble("salary");
			Employee employee = new Employee(firstName, lastName, salary);
			employee.setId(resultSet.getInt("id"));

			return employee;
		} catch (SQLException e) {
			return null;
		}

	}
	
	//-----------------------MODIFICA
	
	public boolean update(Employee employeeToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (employeeToUpdate.getId() == 0)
			return false; 

		Employee employeeRead = read(employeeToUpdate.getId());
		if (!employeeRead.equals(employeeToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (employeeToUpdate.getFirstName() == null || employeeToUpdate.getFirstName().equals("")) {
					employeeToUpdate.setFirstName(employeeRead.getFirstName());
				}

				if (employeeToUpdate.getLastName() == null || employeeToUpdate.getLastName().equals("")) {
					employeeToUpdate.setLastName(employeeRead.getLastName());
				}

				if (employeeToUpdate.getSalary() == 0.0) {
					employeeToUpdate.setSalary(employeeRead.getSalary());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, employeeToUpdate.getFirstName());
				preparedStatement.setString(2, employeeToUpdate.getLastName());
				preparedStatement.setDouble(3, employeeToUpdate.getSalary());
				preparedStatement.setInt(4, employeeToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;

	}
	
	//---------------------ELIMINA
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	


}











}
