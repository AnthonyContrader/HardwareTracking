package it.contrader.controller;

import it.contrader.service.EmployeeService;
import it.contrader.service.ItemLentService;
import it.contrader.service.ItemService;

import java.util.List;

import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.ItemLentDTO;
import it.contrader.main.MainDispatcher;


public class ItemLentController implements Controller{

	private static String sub_package = "itemlent.";
	
	private ItemLentService itemLentService;
	private EmployeeService employeeService;
	private ItemService itemService;
	
	public ItemLentController() {
		this.itemLentService = new ItemLentService();
		this.itemService = new ItemService();
		this.employeeService = new EmployeeService();
	}


	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		int choice = (Integer) request.get("choice");
		
		String fiscalCodeForLent = (String) request.get("fiscalCodeForLent");
		
		String firstNameOwner = null;
		String lastNameOwner = null; 
		String itemName;
		double price;
		
		
		switch(mode) {
		
		
		case "INSERT": 
			
			//carico la lista oggetti con corrispondente indice
			
			List<ItemDTO> itemsToLent = itemService.getAll();
			itemName = itemsToLent.get(choice-1).getName();
			price = itemsToLent.get(choice-1).getPrice();
			
			//carico la lista impiegati prelevando nome e cognome sapendo il codice fiscale
			
			List<EmployeeDTO> employees = employeeService.getAll();
			for(EmployeeDTO employee: employees) {
				if(employee.getIdFC().equals(fiscalCodeForLent)) {
					firstNameOwner = employee.getFirstName();
					lastNameOwner = employee.getLastName();
				}
			}
			
			if(firstNameOwner != null && lastNameOwner != null) {
			ItemLentDTO itemtolent = new ItemLentDTO(firstNameOwner, lastNameOwner,
									itemName, price, fiscalCodeForLent);
			
			itemLentService.insert(itemtolent);
				MainDispatcher.getInstance().callView(sub_package + "ItemLentInsert", null); 
				
		}else {
				System.out.println("Nominativo mancante");
				MainDispatcher.getInstance().callView("HomeUser", null); 
		}
			break;
			
		
		case "ITEMLENTLIST":
			List<ItemLentDTO> trackItems = itemLentService.getAll();
			request.put("trackItems", trackItems);
			MainDispatcher.getInstance().callView(sub_package + "ItemLentList", request);

		 break;
		 
		 
		 default:
			 System.out.println("Sono al default");
			
	}
	
	
	}	
	

}
