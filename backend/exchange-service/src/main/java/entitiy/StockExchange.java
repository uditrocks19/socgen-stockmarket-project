package entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
protected StockExchange()
{
	
}
public StockExchange(int id, String name, String brief, int address_id, String remarks) {
	super();
	this.id=id;
	this.name = name;
	this.brief = brief;
	this.address_id = address_id;
	this.remarks = remarks;
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
