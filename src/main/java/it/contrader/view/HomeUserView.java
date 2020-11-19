package it.contrader.view;


import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		System.out.println("\n Benvenuto  " + request.get("username").toString() + "\n");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Premere 1 per richiedere, 2 per restituire");
		//System.out.println("\n Esatto, puoi solo uscire...");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		switch (choice) {

		case "1":
			this.request.put("mode", "ITEM_LIST_TO_CHOICE"); //dovrebbe stampare la lista di articoli disponibili
			MainDispatcher.getInstance().callAction("Item", "doControl", request);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
