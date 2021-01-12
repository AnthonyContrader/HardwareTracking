package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Component
public class ItemConverter extends AbstractConverter<Item, ItemDTO>{
	
	@Override
	public Item toEntity(ItemDTO itemDTO) {
		Item item = null;
		if (itemDTO != null) {
			item = new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice());
		}
		return item;
	}

	@Override
	public ItemDTO toDTO(Item item) {
		ItemDTO userDTO = null;
		if (item != null) {
			userDTO = new ItemDTO(item.getId(), item.getName(), item.getPrice());

		}
		return userDTO;
	}
	

}
