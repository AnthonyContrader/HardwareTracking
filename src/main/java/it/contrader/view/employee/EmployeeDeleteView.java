package it.contrader.view.employee;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeeDeleteView extends AbstractView {
	
	//AbstractView ha il metodo getInput() per lo scanner
	
	private Request request;

	private String idFC;
	private final String mode = "DELETE";

	public EmployeeDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Employee", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'impiegato:");
			idFC = getInput();

	}

	/**
	 * impacchetta la request con l'id dell'impiegato da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idFC", idFC);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employee", "doControl", request);
	}


}
