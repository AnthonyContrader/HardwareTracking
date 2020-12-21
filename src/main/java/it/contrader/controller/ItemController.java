package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ItemDTO;
import it.contrader.service.ItemService;


@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200") 
public class ItemController extends AbstractController<ItemDTO> {
	
	@Autowired
	ItemService itemService;

}
