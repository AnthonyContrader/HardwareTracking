package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Item;


public class ItemDAO implements DAO<Item> {
	
	public static final String QUERY_ALL = "SELECT * FROM items";
	public static final String QUERY_CREATE = "INSERT INTO items (name, price) VALUES (?,?)";
	public static final String QUERY_READ = "SELECT * FROM items WHERE id=?";
	public static final String QUERY_UPDATE = "UPDATE items SET name=?, price=? WHERE id=?";
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
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				item = new Item(name, price);
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
		preparedStatement.setDouble(2, itemToInsert.getPrice());
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
			String name;
			double price;

			name = resultSet.getString("name");
			price = resultSet.getDouble("price");
			Item item = new Item(name, price);
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

				if (itemToUpdate.getPrice() == 0.0) {
					itemToUpdate.setPrice(itemRead.getPrice());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, itemToUpdate.getName());
				preparedStatement.setDouble(2, itemToUpdate.getPrice());
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
