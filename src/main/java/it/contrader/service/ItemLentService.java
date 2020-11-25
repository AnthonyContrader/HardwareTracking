package it.contrader.service;

import java.util.List;

import it.contrader.converter.ItemLentConverter;
import it.contrader.dao.ItemLentDAO;
import it.contrader.dto.ItemLentDTO;

public class ItemLentService {
	
	private ItemLentDAO itemLentDAO;
	private ItemLentConverter ItemLentConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ItemLentService(){
		this.itemLentDAO = new ItemLentDAO();
		this.ItemLentConverter = new ItemLentConverter();
	}
	

	public List<ItemLentDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return ItemLentConverter.toDTOList(itemLentDAO.getAll());
	}


	public boolean insert(ItemLentDTO dto) {
		return itemLentDAO.insert(ItemLentConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return itemLentDAO.delete(id);
	}
	
	

}
