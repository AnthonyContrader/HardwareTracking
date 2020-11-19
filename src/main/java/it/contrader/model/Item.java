package it.contrader.model;

public class Item {
	
	private int id;
	
	private String name;
	
	private String code;
	
	private double price;
	
	public Item() {
		
	}
	
	public Item(String name, String code, double price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}


	public Item(int id, String name, String code, double price) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		return id + "\t" + name + "\t" + name + "\t" + code + "\t" + price;
	}
	
}
