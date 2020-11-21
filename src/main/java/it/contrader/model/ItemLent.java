package it.contrader.model;

public class ItemLent {
	
private int id;
	
	private String name;
	
	private double price;
	
	private String fiscalCodeForLent;
	
	
	public ItemLent() {
		
	}
	
	public ItemLent(String name, double price, String fiscalCodeForLent) {
		this.name = name;
		this.price = price;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}


	public ItemLent(int id, String name, double price, String fiscalCodeForLent) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLent other = (ItemLent) obj;
		if (fiscalCodeForLent == null) {
			if (other.fiscalCodeForLent != null)
				return false;
		} else if (!fiscalCodeForLent.equals(other.fiscalCodeForLent))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + price + "\t" + fiscalCodeForLent;
	}
	
	
	
	

}
