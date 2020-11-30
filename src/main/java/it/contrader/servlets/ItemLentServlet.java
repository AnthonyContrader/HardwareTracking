package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.ItemLentDTO;
import it.contrader.service.EmployeeService;
import it.contrader.service.ItemLentService;
import it.contrader.service.ItemService;

/**
 * Servlet implementation class ItemLentServlet
 */
public class ItemLentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemLentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void updateList(HttpServletRequest request) {
		ItemLentService service = new ItemLentService();
		List<ItemLentDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
    
    public void availableItemList(HttpServletRequest request) {
		ItemService service = new ItemService();
		List<ItemDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemLentService service = new ItemLentService();
		String mode = request.getParameter("mode");
		String fiscalCodeForLent = (String) request.getParameter("fiscalCodeForLent");
		//ItemLentDTO dto;
		//int id;
		boolean flag = false;  //ci dice se l'utente ha già richiesto l'oggetto

		switch (mode.toUpperCase()) {
			
		case "ITEMLENTLIST":
			updateList(request);
			request.setAttribute("fiscalCodeForLent", fiscalCodeForLent);
			getServletContext().getRequestDispatcher("/itemlent/itemlentmanager.jsp").forward(request, response);
			break;
			
		case "ITEMLIST":
			availableItemList(request);
			request.setAttribute("fiscalCodeForLent", fiscalCodeForLent);
			getServletContext().getRequestDispatcher("/itemlent/itemlentrequest.jsp").forward(request, response);
			break;
			
		case "INSERT":
			
			ItemLentDTO newItem = null;
			
			//String fiscalCodeForLent = (String) request.getParameter("fiscalCodeForLent");
			int choice = Integer.parseInt(request.getParameter("Id"));
			
			ItemService itemService = new ItemService();
			
			List<ItemDTO> itemsToLent = itemService.getAll();
			String itemName = itemsToLent.get(choice-1).getName();
			Double price = itemsToLent.get(choice-1).getPrice();
			
			EmployeeService employeeService = new EmployeeService();
			String firstNameOwner = null;
			String lastNameOwner = null;
			
			//preleva nome e cognome
			
			List<EmployeeDTO> employees = employeeService.getAll();
			for(EmployeeDTO employee: employees) {
				if(employee.getIdFC().equals(fiscalCodeForLent)) {
					firstNameOwner = employee.getFirstName();
					lastNameOwner = employee.getLastName();
					break;
				}
			}
			
			//-------------verifica che non sia già stato richiesto, se lo è allora flag = true
			
			List<ItemLentDTO> trackItems = service.getAll();
			for(ItemLentDTO itemLent: trackItems) {
				if(itemLent.getFiscalCodeForLent().equals(fiscalCodeForLent) 
						&& itemLent.getItemName().equals(itemName))
					flag = true;
			}
			
			//aggiunge l'oggetto alla lista dei richiesti
			
				if(flag == false) {
			
			newItem = new ItemLentDTO(firstNameOwner, lastNameOwner, itemName,
							price, fiscalCodeForLent);
			service.insert(newItem);
			request.setAttribute("esito", newItem);
			request.setAttribute("fiscalCodeForLent", fiscalCodeForLent);
			updateList(request);
			getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
			
			}
			
				else 
			getServletContext().getRequestDispatcher("/itemlentfailure.html").forward(request, response);
			
			
			break;
			
			
		case "LISTFORUSER":
			//fiscalCodeForLent = (String) request.getParameter("fiscalCodeForLent");
			List<ItemLentDTO> list = service.getAll();
			List<ItemLentDTO> listforuser = new ArrayList<>();
			
			//aggiunge alla nuova lista solo gli elementi che corrispondono al codice fiscale
			
			for(ItemLentDTO item: list) {
				if(item.getFiscalCodeForLent().equals(fiscalCodeForLent))
					listforuser.add(item);
				}
			
			
			for(ItemLentDTO item2: listforuser)
				System.out.println(item2.toString());
			
				request.setAttribute("listforuser", listforuser);
				request.setAttribute("fiscalCodeForLent", fiscalCodeForLent);
				getServletContext().getRequestDispatcher("/itemlent/itemlentreturn.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			
			String mix = (String) request.getParameter("mix");
			String[] parts = mix.split("-");
			
			int id = Integer.parseInt(parts[0]);
			fiscalCodeForLent = parts[1];
			
			if(service.delete(id)) {
				ItemLentDTO x = new ItemLentDTO("a", "a", "a", 3, "a");
				request.setAttribute("esito", x);
				request.setAttribute("fiscalCodeForLent", fiscalCodeForLent);
				getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);	
				
			}
		
		}
		
    }		
		
}

