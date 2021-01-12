package it.contrader.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;
import it.contrader.dao.ItemLentDAO;
import it.contrader.dto.ItemLentDTO;
import it.contrader.model.ItemLent;

@Service
public class ItemLentService{
	
	@Autowired
	ItemLentDAO repository;
	@Autowired
	Converter<ItemLent, ItemLentDTO> converter;
	
	@Transactional
	public ItemLentDTO insert(ItemLentDTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}
	
	@Transactional
	public void delete(String fiscalCode, String itemName) {
		repository.delete(fiscalCode, itemName);
	}
	
	@Transactional
	public List<ItemLentDTO> getAll(){
		return converter.toDTOList(repository.findAll());
	}
}
