package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;

public class ItemRequestView extends AbstractView{
	
	private Request request;
	private String choice;
	private String fiscalCodeForLent;
	private final String mode = "REQUEST";

	public ItemRequestView(){
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Articoli disponibili ----------------\n");
			System.out.println("Attenzione: in caso di danneggiamento le sarà addebitato il costo\n");
			System.out.println("ID\tNome\t\tCosto");
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

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.print("Scegliere tra gli articoli disponibili digitando il numero id -> ");
		choice = this.getInput();
		System.out.print("Inserisci il tuo codice fiscale -> ");
		fiscalCodeForLent = this.getInput();
	}
	
	/**
	 * Impacchetta la request e la manda allo EmployeeController.
	 */
	@Override
	public void submit() {
		
		request = new Request();
		request.put("mode", mode);
		request.put("choice", choice);
		request.put("fiscalCodeForLent", fiscalCodeForLent);
		MainDispatcher.getInstance().callAction("Item", "doControl", this.request);
		
		}
		
	
	}
	


