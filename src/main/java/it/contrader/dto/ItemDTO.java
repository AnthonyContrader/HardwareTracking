package it.contrader.dto;


import it.contrader.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private int id;
	
	private String name;
	
	private int price;
	
	private Employee employee;
	
}
