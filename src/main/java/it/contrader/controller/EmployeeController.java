package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EmployeeService;
import it.contrader.service.UserService;

public class EmployeeController implements Controller{
	
private static String sub_package = "employee.";
	
	private EmployeeService employeeService;
	private UserService userService;
	
	
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public EmployeeController() {
		this.employeeService = new EmployeeService();
		this.userService = new UserService();
	}
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		String idFC;
		String firstName;
		String lastName;
		Double salary;
		
		//campi relativi alla classe user per permettere la registrazione automatica di un nuovo impiegato nella lista user

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idFC = request.get("idFC").toString();
			EmployeeDTO employeeDTO = employeeService.read(idFC);
			request.put("employee", employeeDTO);
			MainDispatcher.getInstance().callView(sub_package + "EmployeeRead", request);
			break;
		    
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			idFC = request.get("idFC").toString();
			firstName = request.get("firstName").toString();
			lastName = request.get("lastName").toString();
			salary = (Double)request.get("salary");
			
			//costruisce l'oggetto user da inserire
			EmployeeDTO employeetoinsert = new EmployeeDTO(idFC, firstName, lastName, salary);
			UserDTO usertoinsert = new UserDTO(firstName+lastName, idFC, "USER");
			//invoca il service
			employeeService.insert(employeetoinsert);
			userService.insert(usertoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "EmployeeInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idFC = request.get("idFC").toString();
			//Qui chiama il service
			employeeService.delete(idFC);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeeDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idFC = request.get("idFC").toString();
			firstName = request.get("firstName").toString();
			lastName = request.get("lastName").toString();
			salary = (Double) request.get("salary");
			EmployeeDTO employeeToUpdate = new EmployeeDTO(firstName, lastName, salary);
			employeeToUpdate.setId(idFC);
			employeeService.update(employeeToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeeUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "EMPLOYEELIST":
			List<EmployeeDTO> employeesDTO = employeeService.getAll();
			//Impacchetta la request con la lista degli impiegati
			request.put("employees", employeesDTO);
			MainDispatcher.getInstance().callView("Employee", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "EmployeeRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "EmployeeInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "EmployeeUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "EmployeeDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}
