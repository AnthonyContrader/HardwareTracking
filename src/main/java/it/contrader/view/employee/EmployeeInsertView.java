package it.contrader.view.employee;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeeInsertView extends AbstractView{
	private Request request;

	private String firstName;
	private String lastName;
	private Double salary;
	private final String mode = "INSERT";

	public EmployeeInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Employee", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dell'impiegato:");
			firstName = getInput();
			System.out.println("Inserisci cognome dell'impiegato:");
			lastName = getInput();
			System.out.println("Inserisci stipendio dell'impiegato:");
			salary = Double.parseDouble(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("salary", salary);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employee", "doControl", request);
	}


}
