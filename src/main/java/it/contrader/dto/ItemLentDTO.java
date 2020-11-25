package it.contrader.dto;

public class ItemLentDTO {
	
	
private int id;
	
	private String firstNameOwner;
	
	private String lastNameOwner;
	
	private String itemName;
	
	private double price;
	
	private String fiscalCodeForLent;
	
	public ItemLentDTO() {
		
	}

	public ItemLentDTO(int id, String firstNameOwner, String lastNameOwner, String itemName, double price,
			String fiscalCodeForLent) {
		this.id = id;
		this.firstNameOwner = firstNameOwner;
		this.lastNameOwner = lastNameOwner;
		this.itemName = itemName;
		this.price = price;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}

	public ItemLentDTO(String firstNameOwner, String lastNameOwner, String itemName, double price,
			String fiscalCodeForLent) {
		this.firstNameOwner = firstNameOwner;
		this.lastNameOwner = lastNameOwner;
		this.itemName = itemName;
		this.price = price;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFiscalCodeForLent() {
		return fiscalCodeForLent;
	}

	public void setFiscalCodeForLent(String fiscalCodeForLent) {
		this.fiscalCodeForLent = fiscalCodeForLent;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstNameOwner == null) ? 0 : firstNameOwner.hashCode());
		result = prime * result + ((fiscalCodeForLent == null) ? 0 : fiscalCodeForLent.hashCode());
		result = prime * result + id;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((lastNameOwner == null) ? 0 : lastNameOwner.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLentDTO other = (ItemLentDTO) obj;
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
