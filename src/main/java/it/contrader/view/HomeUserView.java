package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;
	
	String fiscalCodeForLent;
	

	@Override
	public void showResults(Request request) {
		if(request != null)
		System.out.println("\n Benvenuto in SAMPLE PROJECT " + request.get("username").toString() + "\n");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Premere [1] per richiedere, [2] Per restituire, [3] per uscire");
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
			
			
		case "2":
			System.out.print("Inserisci il tuo codice fiscale -> ");
			fiscalCodeForLent = this.getInput();
			this.request.put("choice", 3); //impacchettamento per evitare il crash
			this.request.put("fiscalCodeForLent", fiscalCodeForLent);
			this.request.put("mode", "ITEM_LENT_LIST_TO_SPECIFIC_USER");
			MainDispatcher.getInstance().callAction("ItemLent", "doControl", request);
			break;
			
			
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
