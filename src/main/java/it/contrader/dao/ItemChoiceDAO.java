package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.ItemChoice;

public class ItemChoiceDAO {
	
	
	public static final String QUERY_ALL = "SELECT * FROM itemchoice";
	public static final String QUERY_CREATE = "INSERT INTO itemschoice (id, name, price, receiver) VALUES (?,?,?,?)";
	
public ItemChoiceDAO(){
		
	}
	
	//------------------GET ALL
	
	public List<ItemChoice> getAll() {
		List<ItemChoice> itemChoiceList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			ItemChoice item;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				String receiver = resultSet.getString("receiver");
				item = new ItemChoice(id, name, price, receiver);
				item.setId(id);
				itemChoiceList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemChoiceList;
	}

	//------------------INSERISCI NUOVO

public boolean insert(ItemChoice itemToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setDouble(1, itemToInsert.getId());
		preparedStatement.setString(2, itemToInsert.getName());
		preparedStatement.setDouble(3, itemToInsert.getPrice());
		preparedStatement.setString(4, itemToInsert.getReceiver());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		return false;
	}
	
}

}
