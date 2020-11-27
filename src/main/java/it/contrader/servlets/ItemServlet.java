package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ItemDTO;
import it.contrader.service.Service;
import it.contrader.service.ItemService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ItemDTO> service = new ItemService();
		List<ItemDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ItemDTO> service = new ItemService();
		String mode = request.getParameter("mode");
		ItemDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ITEMLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/item/updateitem.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			Double price = Double.parseDouble(request.getParameter("price"));
			dto = new ItemDTO (name,price);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			price = Double.parseDouble(request.getParameter("price"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ItemDTO (name, price);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
		}
	}
}