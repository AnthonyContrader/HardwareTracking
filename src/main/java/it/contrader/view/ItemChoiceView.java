package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;

public class ItemChoiceView extends AbstractView{
	
	
	private Request request;
	private String choice;

	public ItemChoiceView(){
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Articoli disponibili ----------------\n");
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
		System.out.print("  Digita il corrispondente numero per richiedere -> ");
	
		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo EmployeeController.
	 */
	@Override
	public void submit() {
		
	}
	
	

}
