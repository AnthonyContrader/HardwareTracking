package it.contrader.model;

public class ItemChoice {
	
	private int id;
	private String name;
	private Double price;
	private String receiver;
	
	
	public ItemChoice(int id, String name, Double price, String receiver) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.receiver = receiver;
	}


	public ItemChoice(String name, Double price, String receiver) {
		this.name = name;
		this.price = price;
		this.receiver = receiver;
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


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	@Override
	public String toString() {
		return id + "\t" + name + "\t" + price + "\t" + receiver;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemChoice other = (ItemChoice) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		return true;
	}
	
	
	
	
	
	

}
