package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.ItemLent;

public class ItemLentDAO {
	
	public static final String QUERY_ALL = "SELECT * FROM itemlent";
	public static final String QUERY_CREATE = "INSERT INTO itemlent "
			+ "(firstNameOwner, lastNameOwner, itemName, price, fiscalCodeForLent) VALUES (?,?,?,?,?)";
	public static final String QUERY_DELETE = "DELETE FROM itemlent WHERE id = ?";
	
public ItemLentDAO(){
		
	}
	
	//------------------GET ALL
	
	public List<ItemLent> getAll() {
		List<ItemLent> itemLentList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			ItemLent itemLent;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstNameOwner = resultSet.getString("firstNameOwner");
				String lastNameOwner = resultSet.getString("lastNameOwner");
				String itemName = resultSet.getString("itemName");
				double price = resultSet.getDouble("price");
				String fiscalCodeForLent = resultSet.getString("fiscalCodeForLent");
				itemLent = new ItemLent(firstNameOwner, lastNameOwner, itemName, price, fiscalCodeForLent);
				itemLent.setId(id);
				itemLentList.add(itemLent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return itemLentList;
		
	}
	

	//------------------INSERISCI NUOVO

public boolean insert(ItemLent itemLentToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1, itemLentToInsert.getFirstNameOwner());
		preparedStatement.setString(2, itemLentToInsert.getLastNameOwner());
		preparedStatement.setString(3, itemLentToInsert.getItemName());
		preparedStatement.setDouble(4, itemLentToInsert.getPrice());
		preparedStatement.setString(5, itemLentToInsert.getFiscalCodeForLent());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
}
	
	//-----------------ELIMINA
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}


