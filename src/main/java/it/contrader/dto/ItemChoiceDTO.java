package it.contrader.dto;

public class ItemChoiceDTO {

	private int id;
	private String name;
	private Double price;
	private String receiver;
	
	
	public ItemChoiceDTO(int id, String name, Double price, String receiver) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.receiver = receiver;
	}


	public ItemChoiceDTO(String name, Double price, String receiver) {
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
	
	
}
