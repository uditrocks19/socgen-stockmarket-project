package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sector")
public class Sector {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String brief;

    @OneToMany(mappedBy = "sector")
    
    private List<Company> companies;

  protected Sector()
  {
	  
  }
    public Sector( String name, String brief) {
        
        
        this.name=name;
        this.brief=brief;
    }


    public int getId() {
        return id;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
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

}