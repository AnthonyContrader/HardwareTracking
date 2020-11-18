package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Item;
//import it.contrader.model.User;

public class ItemDAO {
	
	public static final String QUERY_ALL = "SELECT * FROM items";
	public static final String QUERY_CREATE = "INSERT INTO items (name, code, price) VALUES (?,?,?)";
	public static final String QUERY_READ = "SELECT * FROM items WHERE id=?";
	public static final String QUERY_UPDATE = "UPDATE items SET firstName=?, lastName=?, salary=? WHERE id=?";
	public static final String QUERY_DELETE = "DELETE FROM items WHERE id=?"; 
	
	public ItemDAO(){
		
	}
	
	//------------------GET ALL
	
	public List<Item> getAll() {
		List<Item> itemList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Item item;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				double salary = resultSet.getDouble("salary");
				item = new Item(firstName, lastName, salary);
				item.setId(id);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	//------------------INSERISCI NUOVO

public boolean insert(Item itemToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1, itemToInsert.getName());
		preparedStatement.setString(2, itemToInsert.getCode());
		preparedStatement.setDouble(3, itemToInsert.getPrice());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		return false;
	}
	
}
	

//-------------------------VISUALIZZA
	
	public Item read(int itemId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, code;
			double price;

			name = resultSet.getString("name");
			code = resultSet.getString("code");
			price = resultSet.getDouble("price");
			Item item = new Item(name, code, price);
			item.setId(resultSet.getInt("id"));

			return item;
		} catch (SQLException e) {
			return null;
		}

	}
	
	//-----------------------MODIFICA
	
	public boolean update(Item itemToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (itemToUpdate.getId() == 0)
			return false; 

		Item itemRead = read(itemToUpdate.getId());
		if (!itemRead.equals(itemToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (itemToUpdate.getName() == null || itemToUpdate.getName().equals("")) {
					itemToUpdate.setName(itemRead.getName());
				}
					
				if (itemToUpdate.getCode() == null || itemToUpdate.getCode().equals("")) {
					itemToUpdate.setCode(itemRead.getCode());
				}

				if (itemToUpdate.getPrice() == 0.0) {
					itemToUpdate.setPrice(itemRead.getPrice());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, itemToUpdate.getName());
				preparedStatement.setString(2, itemToUpdate.getCode());
				preparedStatement.setDouble(3, itemToUpdate.getPrice());
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
	
		//prova

}
