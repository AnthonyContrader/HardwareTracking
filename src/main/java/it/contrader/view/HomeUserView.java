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
		System.out.println("Premere [1] per richiedere, [2] per restituire, [3] per uscire");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		switch (choice) {

		case "1":
			this.request.put("choice", choice);
			this.request.put("mode", "ITEMCHOICELIST"); //dovrebbe stampare la lista di articoli disponibili
			MainDispatcher.getInstance().callAction("Item", "doControl", request);
			break;
			
		case "2":
			
			break;
			
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
