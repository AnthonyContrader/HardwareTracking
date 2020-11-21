package it.contrader.service;

import java.util.List;

import it.contrader.converter.ItemLentConverter;
import it.contrader.dao.ItemLentDAO;
import it.contrader.dto.ItemLentDTO;

public class ItemLentService {
	
	private ItemLentDAO ItemLentDAO;
	private ItemLentConverter ItemLentConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ItemLentService(){
		this.ItemLentDAO = new ItemLentDAO();
		this.ItemLentConverter = new ItemLentConverter();
	}
	

	public List<ItemLentDTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return ItemLentConverter.toDTOList(ItemLentDAO.getAll());
	}

/*
	public ItemLentDTO read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return ItemLentConverter.toDTO(ItemLentDAO.read(id));
	}

*/
	public boolean insert(ItemLentDTO dto) {
		return ItemLentDAO.insert(ItemLentConverter.toEntity(dto));
	}

/*
	public boolean update(ItemLentDTO dto) {
		// Converte un ItemDTO in entit� e lo passa allo ItemDAO per la modifica
		return ItemLentDAO.update(ItemLentConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return ItemLentDAO.delete(id);
	}
	
	*/

}
