package it.contrader.view.itemlent;

import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemLentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ItemLentDeleteView extends AbstractView {
	
	
	private Request request;
	int choice;
	private String fiscalCodeForLent;
	private static final String mode = "DELETE";
	private List<Integer> availableId = new ArrayList<>();

	@Override
	public void showResults(Request request) {
		
		if(request != null) {
			
		List<ItemLentDTO> itemsRequestedFromThisUser = (List<ItemLentDTO>) request.get("itemsRequestedFromThisUser");
		
		if(itemsRequestedFromThisUser.isEmpty()) {
			System.out.println("Non ci sono elementi a tuo nome");
			MainDispatcher.getInstance().callView("HomeUser", null);
		} 
		
		System.out.println("\n--------------------ARTICOLI RICHIESTI--------------------");
		
		for(ItemLentDTO item: itemsRequestedFromThisUser) {
			System.out.println(item.getId() + ") " + item.getItemName());
			availableId.add(item.getId());
		}
			}
		//se la request è null
		else {
			System.out.println("Restituzione inoltrata");
			MainDispatcher.getInstance().callView("HomeUser", null);
		}
			
		
		}
		

	@Override
	public void showOptions() {
		
		//il do-while fa da protezione per evitare che inserendo un numero che non sia tra quelli disponibili
		//vada ad eliminare un oggetto prestato a qualcun altro
		
		do{
		System.out.print("Digitare il numero corrispondente  \tPremere [0] per tornare indietro\n\n-> ");
		choice = Integer.parseInt(this.getInput());
		if(choice == 0)
			MainDispatcher.getInstance().callView("HomeUser", null);
		}while(!availableId.contains(choice));
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("fiscalCodeForLent", fiscalCodeForLent);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("ItemLent", "doControl", request);
		
	}
	
	
	
	
	

}
