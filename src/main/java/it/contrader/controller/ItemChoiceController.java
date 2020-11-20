package it.contrader.controller;

import it.contrader.dto.ItemChoiceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ItemChoiceService;

public class ItemChoiceController implements Controller {
	
private static String sub_package = ".";
	
	private ItemChoiceService itemChoiceService;
	
	public ItemChoiceController() {
		this.itemChoiceService = new ItemChoiceService();
	}
	
public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		
		int id = Integer.parseInt(request.get("id").toString());
		String name = request.get("name").toString();
		String receiver = request.get("fiscalCode").toString();
		Double price = Double.parseDouble(request.get("price").toString());
		
		ItemChoiceDTO itemchoicetoinsert = new ItemChoiceDTO(id, name, price, receiver);
		itemChoiceService.insert(itemchoicetoinsert);
		request = new Request();
		request.put("mode", "mode");
		//Rimanda alla view con la risposta
		MainDispatcher.getInstance().callView(sub_package + "ItemChoice", request);
		
		
		}
	
		
	

}
