package it.contrader.view.itemlent;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ItemLentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ItemLentListView extends AbstractView{
	
	Request request;

	@Override
	public void showResults(Request request) {
		
		if (request != null) {
			System.out.println("\n------------------- Tracciamento Oggetti ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<ItemLentDTO> trackItems = (List<ItemLentDTO>) request.get("trackItems");
			
			if(trackItems.isEmpty())
				System.out.println("Non sono ancora stati richiesti oggetti");
				else {  
			for (ItemLentDTO itemLent: trackItems) {
				System.out.println(itemLent.toString());
			System.out.println();
				}
		
			}
		
		MainDispatcher.getInstance().callView("HomeAdmin", null);
		
		}
		
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
