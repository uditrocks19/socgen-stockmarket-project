package entitiy;

public class Exchange {
	private int id;
	private String StockExhchange;
	private String brief;
	private Address address;
	private String remarks;
	
	public Exchange(int id, String stockExhchange, String brief, Address address, String remarks) {
		
		this.id = id;
		StockExhchange = stockExhchange;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockExhchange() {
		return StockExhchange;
	}
	public void setStockExhchange(String stockExhchange) {
		StockExhchange = stockExhchange;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
