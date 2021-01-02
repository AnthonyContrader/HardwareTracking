package it.contrader.dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id")
public class EmployeeDTO {
	
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int salary;
	
	private String fiscalCode;

	private User user;
	
	//private List<Item> itemsLent;
	
	

}
