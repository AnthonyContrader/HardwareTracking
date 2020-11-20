package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

public class ItemConverter {
	
		
		public ItemDTO toDTO(Item item) {
			
			ItemDTO itemDTO = new ItemDTO(item.getId(), item.getName(), item.getPrice());
			
			return itemDTO;
			
		}
		
		public Item toEntity(ItemDTO itemDTO) {
			
			Item item = new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice());
			
			return item;
			
		}
		
		public List<ItemDTO> toDTOList(List<Item> itemList) {
			
			List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
			
			for(Item item : itemList) {
				
				itemDTOList.add(toDTO(item));
			}
			return itemDTOList;
		}
	

}
