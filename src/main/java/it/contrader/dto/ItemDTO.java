package it.contrader.dto;

public class ItemDTO {
	
private int id;
	
	private String name;
	
	private double price;
	
	private String fiscalCodeForLent;
	
	public ItemDTO() {
		
	}

	public ItemDTO(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public ItemDTO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//-----------------------
	
	public ItemDTO(int id, String name, double price, String fiscalCodeForLent) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.fiscalCodeForLent = fiscalCodeForLent;
	}
	
	//-----------------------

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
	
	   //-----------------------

		public String getFiscalCodeForLent() {
			return fiscalCodeForLent;
		}

		public void setFiscalCodeForLent(String fiscalCodeForLent) {
			this.fiscalCodeForLent = fiscalCodeForLent;
		}
		
		//-----------------------


	@Override
	public String toString() {
		return id +  "\t" + name + "\t" + price;
	}

}
