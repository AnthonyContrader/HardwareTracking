package it.contrader.view.employee;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeeDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class EmployeeReadView extends AbstractView {

	private String idFC;
	private Request request;
	private final String mode = "READ";

	public EmployeeReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			EmployeeDTO employee = (EmployeeDTO) request.get("employee");
			System.out.println(employee);
			MainDispatcher.getInstance().callView("Employee", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'impiegato:");
		idFC = getInput();
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idFC", idFC);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employee", "doControl", request);
	}

}