package it.contrader.controller;

import it.contrader.service.EmployeeService;
import it.contrader.service.ItemLentService;
import it.contrader.service.ItemService;

import java.util.ArrayList;
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
		
		case "DELETE":
			
			if(itemLentService.delete(choice))
				MainDispatcher.getInstance().callView(sub_package + "ItemLentDelete", null);
			else {
					System.out.println("Errore");
				MainDispatcher.getInstance().callView("HomeUser", null);
			}
			break;
		
		
		case "INSERT": 
			
			//carico la lista oggetti con corrispondente indice
			
			List<ItemDTO> itemsToLent = itemService.getAll();
			itemName = itemsToLent.get(choice-1).getName();
			price = itemsToLent.get(choice-1).getPrice();
			
			//verifico dalla lista oggetti prestati che l'oggetto non sia già stato richiesto
			
			List<ItemLentDTO> trackItems = itemLentService.getAll();
			for(ItemLentDTO itemLent: trackItems) {
				// se è presente blocca l'operazione e rimanda alla HomeUserView
				if(itemLent.getFiscalCodeForLent().equals(fiscalCodeForLent)
						&& itemLent.getItemName().equals(itemName)) {
				System.out.println("\nCi dispiace doverti informare che dai nostri sistemi"
						+ " rileviamo che hai già richiesto questo oggetto.\n"
						+ "Non è possibile richiedere più di un oggetto per tipo.\n"); 
					MainDispatcher.getInstance().callView("HomeUser", null); 
				}
			}
			
			//se non è presente allora la richiesta è inoltrabile e 
			//carico la lista impiegati prelevando nome e cognome sapendo il codice fiscale
			
			List<EmployeeDTO> employees = employeeService.getAll();
			for(EmployeeDTO employee: employees) {
				if(employee.getIdFC().equals(fiscalCodeForLent)) {
					firstNameOwner = employee.getFirstName();
					lastNameOwner = employee.getLastName();
				}
			}
			
			//se i nomi sono stati trovati allora il codice fiscale è valido
			
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
			List<ItemLentDTO> trackItem = itemLentService.getAll();
			request.put("trackItem", trackItem);
			MainDispatcher.getInstance().callView(sub_package + "ItemLentList", request);

		 break;
		 
		 
		case "ITEM_LENT_LIST_TO_SPECIFIC_USER":
			
			//carico tutta la lista e vado a scegliere solo gli oggetti corrispondenti
			//al codice fiscale fornito
			
			List<ItemLentDTO> itemsLent = itemLentService.getAll();
			
			List<ItemLentDTO> itemsRequestedFromThisUser = new ArrayList<>();
			
			for(ItemLentDTO i: itemsLent) {
				if(i.getFiscalCodeForLent().contentEquals(fiscalCodeForLent))
					itemsRequestedFromThisUser.add(i);
			}
			
			request.put("itemsRequestedFromThisUser", itemsRequestedFromThisUser);
			MainDispatcher.getInstance().callView(sub_package + "ItemLentDelete", request);
			
		 break;
		 
		 
		 default:
			 System.out.println("Sono al default");
			
	  }
	
	
	}	
	

}
