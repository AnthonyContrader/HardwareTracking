package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EmployeeDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EmployeeService;

public class EmployeeController implements Controller{
	
private static String sub_package = "employee.";
	
	private EmployeeService employeeService;
	
	
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public EmployeeController() {
		this.employeeService = new EmployeeService();
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
		int id;
		String firstName;
		String lastName;
		Double salary;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			EmployeeDTO employeeDTO = employeeService.read(id);
			request.put("employee", employeeDTO);
			MainDispatcher.getInstance().callView(sub_package + "EmployeeRead", request);
			break;
		    
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			firstName = request.get("firstName").toString();
			lastName = request.get("lastName").toString();
			salary = Double.parseDouble(request.get("salary").toString()); //Double
			
			//costruisce l'oggetto user da inserire
			EmployeeDTO employeeToInsert = new EmployeeDTO(firstName, lastName, salary);
			//invoca il service
			employeeService.insert(employeeToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "EmployeeInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			employeeService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeeDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			firstName = request.get("username").toString();
			lastName = request.get("password").toString();
			salary = (Double) request.get("usertype");
			EmployeeDTO employeeToUpdate = new EmployeeDTO(firstName, lastName, salary);
			employeeToUpdate.setId(id);
			employeeService.update(employeeToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeeUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "EMPLOYEELIST":
			List<EmployeeDTO> employeesDTO = employeeService.getAll();
			//Impacchetta la request con la lista degli user
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
