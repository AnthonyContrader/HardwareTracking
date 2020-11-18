package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;

public class ItemView extends AbstractView {
	
	private Request request;
	private String choice;

	public ItemView(){
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Articoli ----------------\n");
			System.out.println("ID\tNome\tCodice\tCosto");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ItemDTO> items = (List<ItemDTO>) request.get("items");
			for (ItemDTO i: items)
				System.out.println(i);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo EmployeeController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Item", "doControl", this.request);
	}
	

}
