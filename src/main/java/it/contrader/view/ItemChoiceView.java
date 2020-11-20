package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;

public class ItemChoiceView extends AbstractView{
	
	
	private Request request;
	private int id;
	private String choice;
	private String fiscalCode;

	public ItemChoiceView(){
		
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
		System.out.print("Inserisci il tuo codice fiscale -> ");
		this.fiscalCode = getInput();
	}
	
	/**
	 * Impacchetta la request e la manda allo EmployeeController.
	 */
	@Override
	public void submit() {
		
		request = new Request();
		request.put("id", choice);
		request.put("fiscalCode", fiscalCode);
		
		switch(choice) {
		
		case "1":
			request.put("name", "webcam");
			request.put("price", 50);
			break;
			
		case "2":
			request.put("name", "tablet");
			request.put("price", 150);
			break;
			
		case "3":
			request.put("name", "smartphone");
			request.put("price", 300);
			break;
			
		case "4":
			request.put("name", "stampante");
			request.put("price", 75);
			break;
			
		case "5":
			request.put("name", "notebook");
			request.put("price", 500);
		
		}
		
		MainDispatcher.getInstance().callAction("ItemChoice", "doControl", this.request);
	}
	

}
