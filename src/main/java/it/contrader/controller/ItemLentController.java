package it.contrader.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ItemLentDTO;
import it.contrader.service.ItemLentService;

@RestController
@RequestMapping("/track")
@CrossOrigin(origins = "http://localhost:4200") 
public class ItemLentController {
	
	@Autowired
	ItemLentService service;
	
	@GetMapping("/getall")
	public List<ItemLentDTO> getAll(){
		return service.getAll();		
	}
	
	@GetMapping("/getmyrequests/{fiscalCode}")
	public List<ItemLentDTO> getAll(@PathVariable("fiscalCode") String fiscalCode){
		
		List<ItemLentDTO> myRequests = new ArrayList<>();
		
		for(ItemLentDTO tempItemLent: service.getAll())
			if(tempItemLent.getFiscalCodeForLent().equals(fiscalCode))
				myRequests.add(tempItemLent);
		
		
		return myRequests;
	}
	
	@PostMapping("/request")
	public ItemLentDTO insert (@RequestBody ItemLentDTO dto) {
		
		boolean exists = false;
		
		List<ItemLentDTO> items = service.getAll();
		
		for(ItemLentDTO item: items)
			if(item.getFiscalCodeForLent().equals(dto.getFiscalCodeForLent())
					&& item.getItemName().equals(dto.getItemName()))
						exists = true;
		
		if(!exists) {
			service.insert(dto);
			return dto;
		} else
			return null;
	}
	
	@DeleteMapping("/return/{info}")
	public void delete(@PathVariable("info") String info) {
		
		String[] pieces = info.split("-");
		String fiscalCode = pieces[0];
		String itemName = pieces[1];
		
		service.delete(fiscalCode, itemName);
	}
	
	@GetMapping("/download")
	public void download() {
		
		Path percorso = FileSystems.getDefault().getPath("src", "trackItems.txt");
		
		try (BufferedWriter bw = Files.newBufferedWriter(percorso)) {

            for(ItemLentDTO tempItem: service.getAll()) {
            	bw.write(String.valueOf(tempItem));
            	bw.newLine();
            }
            
		}catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
	}
	

}
