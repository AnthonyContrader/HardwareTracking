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
	public static final String QUERY_CREATE = "INSERT INTO itemlent (id, name, price, fiscalCodeForLent) VALUES (?,?,?,?)";
	
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
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				String fiscalCodeForLent = resultSet.getString("fiscalCodeForLent");
				itemLent = new ItemLent(id, name, price, fiscalCodeForLent);
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
		preparedStatement.setInt(1, itemLentToInsert.getId());
		preparedStatement.setString(2, itemLentToInsert.getName());
		preparedStatement.setDouble(3, itemLentToInsert.getPrice());
		preparedStatement.setString(4, itemLentToInsert.getFiscalCodeForLent());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
}

}
