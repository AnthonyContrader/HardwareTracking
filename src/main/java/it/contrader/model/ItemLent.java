package it.contrader.model;

public class ItemLent {
	
	private int id;
	
	private String itemName;
	
	private double price;
	
	private String firstNameOwner;
	
	private String lastNameOwner;
	
	private String fiscalCodeForLent;
	
	
	public ItemLent() {
		
	}


	public ItemLent(int id, String firstNameOwner, String lastNameOwner, String itemName, double price, 
			String fiscalCodeForLent) {
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.firstNameOwner = firstNameOwner;
		this.lastNameOwner = lastNameOwner;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}


	public ItemLent(String firstNameOwner, String lastNameOwner, String itemName, double price, 
			String fiscalCodeForLent) {
		this.itemName = itemName;
		this.price = price;
		this.firstNameOwner = firstNameOwner;
		this.lastNameOwner = lastNameOwner;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getFirstNameOwner() {
		return firstNameOwner;
	}


	public void setFirstNameOwner(String firstNameOwner) {
		this.firstNameOwner = firstNameOwner;
	}


	public String getLastNameOwner() {
		return lastNameOwner;
	}


	public void setLastNameOwner(String lastNameOwner) {
		this.lastNameOwner = lastNameOwner;
	}


	public String getFiscalCodeForLent() {
		return fiscalCodeForLent;
	}


	public void setFiscalCodeForLent(String fiscalCodeForLent) {
		this.fiscalCodeForLent = fiscalCodeForLent;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLent other = (ItemLent) obj;
		if (firstNameOwner == null) {
			if (other.firstNameOwner != null)
				return false;
		} else if (!firstNameOwner.equals(other.firstNameOwner))
			return false;
		if (fiscalCodeForLent == null) {
			if (other.fiscalCodeForLent != null)
				return false;
		} else if (!fiscalCodeForLent.equals(other.fiscalCodeForLent))
			return false;
		if (id != other.id)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (lastNameOwner == null) {
			if (other.lastNameOwner != null)
				return false;
		} else if (!lastNameOwner.equals(other.lastNameOwner))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Dati oggetto: possessore -> " + firstNameOwner + " " + lastNameOwner +
				" (" + fiscalCodeForLent + ") detiene " + itemName.toUpperCase() + " (costo: " +
				price + ")";
				
	}
	
	

}
