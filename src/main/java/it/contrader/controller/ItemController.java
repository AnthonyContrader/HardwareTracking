package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ItemDTO;
import it.contrader.dto.ItemLentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ItemLentService;
import it.contrader.service.ItemService;

public class ItemController implements Controller {

	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	
	private static String sub_package = "item.";
	
	private ItemService itemService;
	private ItemLentService itemLentService;
	
	public ItemController() {
		this.itemService = new ItemService();
		this.itemLentService = new ItemLentService();
	}
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		Double price;
		String fiscalCodeForLent;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			ItemDTO itemDTO = itemService.read(id);
			request.put("item", itemDTO);
			MainDispatcher.getInstance().callView(sub_package + "ItemRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			price = Double.parseDouble(request.get("price").toString());
			
			//costruisce l'oggetto user da inserire
			ItemDTO itemToInsert = new ItemDTO(name, price);
			//invoca il service
			itemService.insert(itemToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ItemInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			itemService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ItemDelete", request);
			break;                           
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			price = (Double) request.get("price");
			ItemDTO itemToUpdate = new ItemDTO(name, price);
			itemToUpdate.setId(id);
			itemService.update(itemToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ItemUpdate", request);
			break;
			
			//----------------------
			
		  case "REQUEST": 
			int choiceToLent = Integer.parseInt(choice);
			List<ItemDTO> itemsToLent = itemService.getAll();
			id = itemsToLent.get(choiceToLent-1).getId();
			name = itemsToLent.get(choiceToLent-1).getName();
			price = itemsToLent.get(choiceToLent-1).getPrice();
			fiscalCodeForLent = request.get("fiscalCodeForLent").toString();
			ItemLentDTO itemtolent = new ItemLentDTO(id, name, price, fiscalCodeForLent);
			if(itemLentService.insert(itemtolent))
				MainDispatcher.getInstance().callView("ItemRequest", null); 
			else
				System.out.println("errore");
			
			break; 
			
			//----------------------
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "ITEMLIST":
			List<ItemDTO> itemsDTO = itemService.getAll();
			//Impacchetta la request con la lista degli item
			request.put("items", itemsDTO);
			MainDispatcher.getInstance().callView("Item", request);
			break;
			
		case "ITEMCHOICELIST": 
			List<ItemDTO> itemsAvailable = itemService.getAll();
			//Impacchetta la request con la lista degli item
			request.put("itemsAvailable", itemsAvailable);
			MainDispatcher.getInstance().callView("ItemRequest", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ItemRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ItemInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ItemUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ItemDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
	
}
