package it.contrader.view.item;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class ItemUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private Double price;
	private final String mode = "UPDATE";

	public ItemUpdateView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Item", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'articolo:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome dell'articolo:");
			name = getInput();
			System.out.println("Inserisci prezzo dell'articolo:");
			price = Double.parseDouble(getInput());
		} catch (Exception e) {
				e.printStackTrace();
		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("price", price);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
	}

}