package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="itemlent")
public class ItemLent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name_owner")
	private String firstNameOwner;
	
	@Column(name="last_name_owner")
	private String lastNameOwner;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="fiscal_code_for_lent")
	private String fiscalCodeForLent;
	
	@Column(name="date_of_request")
	private String date;

	@Override
	public String toString() {
		return firstNameOwner + " " + lastNameOwner + " (" + fiscalCodeForLent +
				") DETIENE " + itemName + "; DATA RICHIESTA: " + date; 
	}
	
	

}
