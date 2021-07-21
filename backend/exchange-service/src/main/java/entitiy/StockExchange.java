package entitiy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class StockExchange {
@Id
@GeneratedValue
@Column(name="id")
	private int id;
@Column(name="name")
private String name;
@Column(name="brief")
private String brief;
@Column(name="address_id")
private int address_id;
@Column(name="remarks")
private String remarks;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "address_id", referencedColumnName = "id")
@JsonManagedReference
private Address address;
@OneToMany
private List<Company> companies;
@OneToMany
private List<Stock>stocks;
protected StockExchange()
{
	
}

public StockExchange(String name, String brief, int address_id, String remarks, Address address,
		List<Company> companies, List<Stock> stocks) {
	super();
	this.name = name;
	this.brief = brief;
	this.address_id = address_id;
	this.remarks = remarks;
	this.address = address;
	this.companies = companies;
	this.stocks = stocks;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Company> getCompanies() {
	return companies;
}

public void setCompanies(List<Company> companies) {
	this.companies = companies;
}

public List<Stock> getStocks() {
	return stocks;
}

public void setStocks(List<Stock> stocks) {
	this.stocks = stocks;
}

public void setId(int id) {
	this.id = id;
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
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("StockExchange [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", brief=");
	builder.append(brief);
	builder.append(", address_id=");
	builder.append(address_id);
	builder.append(", remarks=");
	builder.append(remarks);
	builder.append("]");
	return builder.toString();
}






}
