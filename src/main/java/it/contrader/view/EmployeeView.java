package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeeDTO;
import it.contrader.main.MainDispatcher;

public class EmployeeView extends AbstractView{
	
	
	private Request request;
	private String choice;

	public EmployeeView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Impiegati ----------------\n");
			System.out.println("ID\tNome\tCognome\tStipendio");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<EmployeeDTO> employees = (List<EmployeeDTO>) request.get("employees");
			for (EmployeeDTO e: employees)
				System.out.println(e);
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
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [T]raccia [B]ack [E]sci");

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
		MainDispatcher.getInstance().callAction("Employee", "doControl", this.request);
	}

	
	

	
	

}
