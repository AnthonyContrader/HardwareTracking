package it.contrader.converter;


import it.contrader.dto.ItemLentDTO;
import it.contrader.model.ItemLent;

import org.springframework.stereotype.Component;

@Component
public class ItemLentConverter extends AbstractConverter<ItemLent, ItemLentDTO>{
	
	@Override
	public ItemLent toEntity(ItemLentDTO itemLentDTO) {
		ItemLent user = null;
		if (itemLentDTO != null) {
			user = new ItemLent(itemLentDTO.getId(), itemLentDTO.getFirstNameOwner(), 
					itemLentDTO.getLastNameOwner(), itemLentDTO.getItemName(),
					itemLentDTO.getPrice(), itemLentDTO.getFiscalCodeForLent());
		}
		return user;
	}

	@Override
	public ItemLentDTO toDTO(ItemLent itemLent) {
		ItemLentDTO itemLentDTO = null;
		if (itemLent != null) {
			itemLentDTO = new ItemLentDTO(itemLent.getId(), itemLent.getFirstNameOwner(), 
					itemLent.getLastNameOwner(), itemLent.getItemName(),
					itemLent.getPrice(), itemLent.getFiscalCodeForLent());

		}
		return itemLentDTO;
	}
	

}
