package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stock {
	@Id
	@GeneratedValue
	 private int id;
	   
	    private int companyId;
	    private double price;
	    private String date;
	    private String time;
	    @ManyToOne
	    private Company company;
	    protected Stock()
	    {
	    	
	    }
	    
	    
	    
		public Stock(int companyId, double price, String date, String time, Company company) {
			super();
			this.companyId = companyId;
			this.price = price;
			this.date = date;
			this.time = time;
			this.company = company;
		}



		public int getId() {
			return id;
		}
	
		public int getCompanyId() {
			return companyId;
		}
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public Company getCompany() {
			return company;
		}
		public void setCompany(Company company) {
			this.company = company;
		}
	    

}
