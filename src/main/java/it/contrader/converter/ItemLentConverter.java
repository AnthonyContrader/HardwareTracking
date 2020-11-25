package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.ItemLentDTO;
import it.contrader.model.ItemLent;

public class ItemLentConverter {
	
	public ItemLentDTO toDTO(ItemLent itemLent) {
		
		ItemLentDTO itemLentDTO = new ItemLentDTO(itemLent.getId(), itemLent.getFirstNameOwner(), 
				itemLent.getLastNameOwner(), itemLent.getItemName(), itemLent.getPrice(), 
				itemLent.getFiscalCodeForLent());
		
		return itemLentDTO;
		
	}
	
	public ItemLent toEntity(ItemLentDTO itemLentDTO) {
		
		ItemLent itemLent = new ItemLent(itemLentDTO.getId(), itemLentDTO.getFirstNameOwner(), 
				itemLentDTO.getLastNameOwner(), itemLentDTO.getItemName(), itemLentDTO.getPrice(),
				itemLentDTO.getFiscalCodeForLent());
		
		return itemLent;
		
	}
	
	public List<ItemLentDTO> toDTOList(List<ItemLent> itemLentList) {
		
		List<ItemLentDTO> itemLentDTOList = new ArrayList<ItemLentDTO>();
		
		for(ItemLent itemLent : itemLentList) {
			
			itemLentDTOList.add(toDTO(itemLent));
		}
		return itemLentDTOList;
	}

}
