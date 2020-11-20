package it.contrader.service;

import java.util.List;

import it.contrader.converter.ItemChoiceConverter;
import it.contrader.dao.ItemChoiceDAO;
import it.contrader.dto.ItemChoiceDTO;

public class ItemChoiceService {
	
	private ItemChoiceDAO ItemChoiceDAO;
	private ItemChoiceConverter ItemChoiceConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ItemChoiceService(){
		this.ItemChoiceDAO = new ItemChoiceDAO();
		this.ItemChoiceConverter = new ItemChoiceConverter();
	}
	

	public List<ItemChoiceDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return ItemChoiceConverter.toDTOList(ItemChoiceDAO.getAll());
	}



	public boolean insert(ItemChoiceDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return ItemChoiceDAO.insert(ItemChoiceConverter.toEntity(dto));
	}

	
}
