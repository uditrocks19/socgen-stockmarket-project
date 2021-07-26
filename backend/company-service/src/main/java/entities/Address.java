package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "address")
public class Address {


  
	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
@Column(name="city")
    private String city;
@Column(name="street")
    private String street;
@Column(name="zip_code")
    private String zip_code;
@Column(name="state")
    private String state;



protected Address()
{
	
}



public Address(String city, String street, String zip_code, String state) {
	super();
	this.city = city;
	this.street = street;
	this.zip_code = zip_code;
	this.state = state;
}



public int getId() {
	return id;
}




public String getCity() {
	return city;
}



public void setCity(String city) {
	this.city = city;
}



public String getStreet() {
	return street;
}



public void setStreet(String street) {
	this.street = street;
}



public String getZip_code() {
	return zip_code;
}



public void setZip_code(String zip_code) {
	this.zip_code = zip_code;
}



public String getState() {
	return state;
}



public void setState(String state) {
	this.state = state;
}




  

 
    
}