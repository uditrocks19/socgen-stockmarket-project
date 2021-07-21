package entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Company {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Turnover")
	private float turnover;
	@Column(name="CEO")
	private String ceo;
	@Column(name="sector_id")
	private int sector_id;
	@Column(name="services")
	private String services;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	
	protected Company()
	{
		
	}


	public Company(String name, float turnover, String ceo, int sector_id, String services,
			StockExchange stockExchange) {
		super();
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.sector_id = sector_id;
		this.services = services;
		this.stockExchange = stockExchange;
	}


	public int getId() {
		return id;
	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getTurnover() {
		return turnover;
	}


	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}


	public String getCeo() {
		return ceo;
	}


	public void setCeo(String ceo) {
		this.ceo = ceo;
	}


	public int getSector_id() {
		return sector_id;
	}


	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}


	public String getServices() {
		return services;
	}


	public void setServices(String services) {
		this.services = services;
	}


	public StockExchange getStockExchange() {
		return stockExchange;
	}


	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}


	
	

}
