package it.contrader.view.employee;

import it.contrader.view.*;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class EmployeeInsertToUser extends AbstractView{
	
	
	private String username;
	private String password;
	private String usertype;
	private String mode;
	private Request request;
	
	public EmployeeInsertToUser(String username, String password, String usertype, String mode) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.mode = mode;
	}
	
	@Override
	public void showResults(Request request) {

		}

	@Override
	public void showOptions() {
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("username", username);
		request.put("password", password);
		request.put("usertype", usertype);
		request.put("mode", mode);
	MainDispatcher.getInstance().callAction("User", "doControl", request);
		
	}
	
	
	}
	
	
	


