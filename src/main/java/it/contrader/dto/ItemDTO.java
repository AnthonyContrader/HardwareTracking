package it.contrader.dto;

import it.contrader.model.Item;

public class ItemDTO {
	
private int id;
	
	private String name;
	
	private String code;
	
	private double price;
	
	public ItemDTO() {
		
	}

	public ItemDTO(int id, String name, String code, double price) {
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
	public String toString() {
		return id + "\t" + name + "\t" + name + "\t" + code + "\t" + price;
	}

}
