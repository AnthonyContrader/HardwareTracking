package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ItemLentDTO{
	
	
	private int id;
	
	private String firstNameOwner;
	
	private String lastNameOwner;
	
	private String itemName;
	
	private String fiscalCodeForLent;
	
	private String date;
	
	@Override
	public String toString() {
		return firstNameOwner + " " + lastNameOwner + " (" + fiscalCodeForLent +
				") DETIENE " + itemName + "; DATA RICHIESTA: " + date; 
	}
	
	}
	
	
