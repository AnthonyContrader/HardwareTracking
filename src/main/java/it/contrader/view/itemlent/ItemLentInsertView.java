package it.contrader.view.itemlent;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ItemLentInsertView extends AbstractView{
	
	//l'aggiunta dell'elemento prestato è la richiesta da parte dell'utente
	
	private Request request;;
	private int choice;
	private String fiscalCodeForLent;
	private static final String mode = "INSERT";

	@Override
	public void showResults(Request request) {
		if(request != null) {
			
			System.out.println("\n------------------- Articoli Disponibili ----------------\n");
			System.out.println("ID\tNome\tCosto");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ItemDTO> itemsAvailable = (List<ItemDTO>) request.get("itemsAvailable");
			for (ItemDTO i: itemsAvailable)
				System.out.println(i);
			System.out.println();
		}
		else {
			System.out.println("Richiesta andata a buon fine");
			MainDispatcher.getInstance().callView("HomeUser", null); 
		}  
		
	}

	@Override
	public void showOptions() {
			System.out.print("Scegliere tra gli articoli disponibili digitando il numero id -> ");
			choice = Integer.parseInt(this.getInput());
			System.out.print("Inserisci il tuo codice fiscale -> ");
			fiscalCodeForLent = this.getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", mode);
		request.put("choice", choice);
		request.put("fiscalCodeForLent", fiscalCodeForLent);
		System.out.println(choice+fiscalCodeForLent);
		MainDispatcher.getInstance().callAction("ItemLent", "doControl", request);
		
	}
	
	

}
