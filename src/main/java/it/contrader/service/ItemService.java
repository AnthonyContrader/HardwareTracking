package it.contrader.service;

import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemDAO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

public class ItemService extends AbstractService<Item, ItemDTO> {

	//Istanzio DAO  e Converter specifici.
	public ItemService(){
		this.dao = new ItemDAO();
		this.converter = new ItemConverter();
	}

}
