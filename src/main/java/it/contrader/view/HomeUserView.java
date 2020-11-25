package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;
	

	@Override
	public void showResults(Request request) {
		if(request != null)
		System.out.println("\n Benvenuto in SAMPLE PROJECT " + request.get("username").toString() + "\n");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Premere [1] per richiedere, [3] per uscire");
		choice = this.getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		switch (choice) {

		case "1":
			this.request.put("mode", "ITEMLIST_TOLENT"); //dovrebbe stampare la lista di articoli disponibili
			MainDispatcher.getInstance().callAction("Item", "doControl", request);
			break;
			
			/*
		case "2":
			this.request.put("choice", choice);
			this.request.put("firstName", firstName);
			this.request.put("lastName", lastName);
			this.request.put("mode", "ITEMRETURN");
			MainDispatcher.getInstance().callAction("Item", "doControl", request);
			break;
			*/
			
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
