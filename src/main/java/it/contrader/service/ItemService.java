package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dto.ItemDTO;
import it.contrader.model.Item;

@Service
public class ItemService extends AbstractService<Item, ItemDTO>{
	
	@Autowired
	ItemService itemService;

}
