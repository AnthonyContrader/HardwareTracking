package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.EmployeeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.EmployeeService;
import it.contrader.service.UserService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		EmployeeService service = new EmployeeService();
		List<EmployeeDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		UserService userService = new UserService();
		String mode = request.getParameter("mode");
		EmployeeDTO dto;
		UserDTO userDTO;
		String idFC;
		boolean ans;
		boolean ans_insert;

		switch (mode.toUpperCase()) {

		case "EMPLOYEELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/employee/employeemanager.jsp").forward(request, response);
			break;

		case "READ":
			idFC = request.getParameter("idFC");
			dto = service.read(idFC);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/employee/reademployee.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/employee/updateemployee.jsp").forward(request, response);
			
			break;

		case "INSERT":
			idFC = request.getParameter("idFC");
			String firstName = request.getParameter("firstName").toString();
			String lastName = request.getParameter("lastName").toString();
			Double salary = Double.parseDouble(request.getParameter("salary"));
			dto = new EmployeeDTO (idFC, firstName, lastName, salary);
			userDTO = new UserDTO(firstName+"_"+lastName, idFC, "USER");
			ans_insert = service.insert(dto) && userService.insert(userDTO);
			request.setAttribute("ans", ans_insert);
			updateList(request);
			getServletContext().getRequestDispatcher("/employee/employeemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			idFC = request.getParameter("idFC");
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			salary = Double.parseDouble(request.getParameter("salary"));
			dto = new EmployeeDTO (idFC,firstName, lastName, salary);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/employee/employeemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idFC = request.getParameter("idFC");

			//preleva nome e cognome per eliminare user

			for(EmployeeDTO x: service.getAll()) //prende la lista impiegati
			if(x.getIdFC().equals(idFC)) { //se il id corrisponde
			firstName = x.getFirstName(); lastName = x.getLastName(); //preleva nome e cognome
			for(UserDTO y: userService.getAll()) { //prende la lista user
			if(y.getUsername().equals(firstName+"_"+lastName)) //se l'user corrisponde
			userService.delete(y.getId()); //elimina
			}
			}


			ans = service.delete(idFC);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/employee/employeemanager.jsp").forward(request, response);
			break;
		}
	}
}