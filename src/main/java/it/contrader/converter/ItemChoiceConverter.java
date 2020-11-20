package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ItemChoiceDTO;
import it.contrader.model.ItemChoice;

public class ItemChoiceConverter {
	
	public ItemChoiceDTO toDTO(ItemChoice item) {
		
		ItemChoiceDTO itemChoiceDTO = new ItemChoiceDTO(item.getId(), item.getName(), item.getPrice(), item.getReceiver());
		
		return itemChoiceDTO;
		
	}
	
	public ItemChoice toEntity(ItemChoiceDTO itemChoiceDTO) {
		
		ItemChoice itemChoice = new ItemChoice(itemChoiceDTO.getId(), itemChoiceDTO.getName(), 
											itemChoiceDTO.getPrice(), itemChoiceDTO.getReceiver());
		
		return itemChoice;
		
	}
	
	public List<ItemChoiceDTO> toDTOList(List<ItemChoice> itemChoiceList) {
		
		List<ItemChoiceDTO> itemChoiceDTOList = new ArrayList<ItemChoiceDTO>();
		
		for(ItemChoice itemChoice : itemChoiceList) {
			
			itemChoiceDTOList.add(toDTO(itemChoice));
		}
		return itemChoiceDTOList;
	}
	
	

}
