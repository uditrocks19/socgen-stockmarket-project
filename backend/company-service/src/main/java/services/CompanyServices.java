package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Company;
import repositories.CompanyRepository;

@Service
public class CompanyServices {
	@Autowired
	CompanyRepository companyRepository;
	public List<Company> getAllCompanies()
	{
		return companyRepository.findAll();
	}
	public Company getCompanyById(int id)
	{
		Optional<Company>company=companyRepository.findById(id);
		 return company.orElse(null);
	}
	public Company addCompany(Company company)
	{
		return companyRepository.save(company);
	}
public boolean deleteById(int id)
{
	if(companyRepository.findById(id).isPresent())
		
	{
		companyRepository.deleteById(id);
		return true;
	}
	else
	{
		return  false;
		
	}
	
}
public Company updateCompany(int id,Company company)
{
	company.setId(id);
	Optional<Company>company1=companyRepository.findById(id);
	if(company1.isEmpty())
	{
		return  null;
	}
	else
	{
		return  companyRepository.save(company);
	}
}
public List<Company> getCompanyByPattern(String pattern)
{
    return companyRepository.findByNameContainingIgnoreCase(pattern);
}
public List<Company> getCompanyByExchange(int id)
{
    return companyRepository.findCompanyByExchange(id);
}
public Company deactivateCompany(int id)
{
    Optional<Company> companyOptional = Optional.ofNullable(getCompanyById(id));
    if(companyOptional.isEmpty()) {
        return null;
    }
    companyRepository.deleteById(id);
    return companyOptional.get();
}


	
	
}
