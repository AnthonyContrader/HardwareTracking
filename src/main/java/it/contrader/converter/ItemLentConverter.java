package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ItemLentDTO;
import it.contrader.model.ItemLent;

public class ItemLentConverter {
	
	public ItemLentDTO toDTO(ItemLent itemLent) {
		
		ItemLentDTO itemDTO = new ItemLentDTO(itemLent.getId(), itemLent.getName(), itemLent.getPrice(), itemLent.getFiscalCodeForLent());
		
		return itemDTO;
		
	}
	
	public ItemLent toEntity(ItemLentDTO itemLentDTO) {
		
		ItemLent itemLent = new ItemLent(itemLentDTO.getId(), itemLentDTO.getName(), itemLentDTO.getPrice(), itemLentDTO.getFiscalCodeForLent());
		
		return itemLent;
		
	}
	
	public List<ItemLentDTO> toDTOList(List<ItemLent> itemLentList) {
		
		List<ItemLentDTO> itemLentDTOList = new ArrayList<ItemLentDTO>();
		
		for(ItemLent item : itemLentList) {
			
			itemLentDTOList.add(toDTO(item));
		}
		return itemLentDTOList;
	}

}
