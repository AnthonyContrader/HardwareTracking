package it.contrader.view.item;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ItemInsertView extends AbstractView{
	private Request request;

	private String name;
	private String code;
	private Double price;
	private final String mode = "INSERT";

	public ItemInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Item", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dell'articolo:");
			name = getInput();
			System.out.println("Inserisci codice dell'articolo:");
			code = getInput();
			System.out.println("Inserisci prezzo dell'articolo:");
			price = Double.parseDouble(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("code", code);
		request.put("price", price);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
	}


}
