package it.contrader.view.employee;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class EmployeeUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String firstName;
	private String lastName;
	private Double salary;
	private final String mode = "UPDATE";

	public EmployeeUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Employee", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'impiegato:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci username dell'impiegato:");
			firstName = getInput();
			System.out.println("Inserisci password dell'impiegato:");
			lastName = getInput();
			System.out.println("Inserisci stipendio dell'impiegato:");
			salary = Double.parseDouble(getInput());
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
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("salary", salary);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employee", "doControl", request);
	}

}
