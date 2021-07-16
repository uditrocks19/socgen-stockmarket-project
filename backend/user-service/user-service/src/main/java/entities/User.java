package entities;

public class User {
	private int id;
	private String name;
	private int usertype;
	private String email;
	private int contact;
	private boolean confirmed;
	
	public User(int id, String name, int usertype, String email, int contact, boolean confirmed) {
	
		this.id = id;
		this.name = name;
		this.usertype = usertype;
		this.email = email;
		this.contact = contact;
		this.confirmed = confirmed;
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
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	

}
