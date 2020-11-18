package it.contrader.service;

import java.util.List;

import it.contrader.converter.ItemConverter;
import it.contrader.dao.ItemDAO;
import it.contrader.dto.ItemDTO;

public class ItemService {
	
	private ItemDAO ItemDAO;
	private ItemConverter ItemConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ItemService(){
		this.ItemDAO = new ItemDAO();
		this.ItemConverter = new ItemConverter();
	}
	

	public List<ItemDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return ItemConverter.toDTOList(ItemDAO.getAll());
	}


	public ItemDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return ItemConverter.toDTO(ItemDAO.read(id));
	}


	public boolean insert(ItemDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return ItemDAO.insert(ItemConverter.toEntity(dto));
	}


	public boolean update(ItemDTO dto) {
		// Converte un ItemDTO in entità e lo passa allo ItemDAO per la modifica
		return ItemDAO.update(ItemConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return ItemDAO.delete(id);
	}
	
	
	

}
