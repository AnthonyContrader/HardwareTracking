package it.contrader.view.employee;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeeTrackView extends AbstractView{
	
	
	Request request;

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Tracciamento Oggetti ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<String> trackItems = (List<String>) request.get("trackItems");
			for (String e: trackItems) {
				System.out.println(e);
			System.out.println();
			}
		
		}
		
		MainDispatcher.getInstance().callView("HomeAdmin", null);
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
