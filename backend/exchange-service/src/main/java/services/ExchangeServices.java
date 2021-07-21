package services;
import org.springframework.beans.factory.annotation.Autowired;

import repostory.AddressRepository;
import repostory.StockExchangeRepository;
import entitiy.*;
import java.util.*;

public class ExchangeServices {
	
	@Autowired
	private AddressRepository rep1;
	@Autowired
	private StockExchangeRepository rep2;
	public List<StockExchange> getAllStockExchanges()
	{
		List<StockExchange>stockExchanges=new ArrayList<>();
		rep2.findAll().forEach(stockExchanges::add);
		return stockExchanges;
		
	}
	public Optional<StockExchange> getStockExchangeById(int id)
	
	{
		Optional<StockExchange> stockExchange=rep2.findById(id);
		
		if(stockExchange.isPresent())
		{
			return stockExchange;
		}
		else
			return null;
		
	}
	public StockExchange addStockExchange(StockExchange stockExchange)
	{
		return rep2.save(stockExchange);
		
	}
	
	public boolean deleteById(int id)
	
	{
		if(rep2.findById(id).isPresent())
		{
			rep2.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
	public StockExchange UpdateStockExchange(int id,StockExchange stockExchange)
	{
		
		
			Optional<StockExchange> stockExchange1 = rep2.findById(id);
	        Optional<Address> address = rep1.findById(id+1);
	        if(stockExchange1.isPresent() && address.isPresent()) {
	            StockExchange newEntity = stockExchange1.get();
	           Address address1=address.get();
	           newEntity.setName(stockExchange.getName());
	           newEntity.setBrief(stockExchange.getBrief());
	           newEntity.setRemarks(stockExchange.getRemarks());
	           address1.setCity(stockExchange.getAddress().getCity());
	           address1.setState(stockExchange.getAddress().getState());
	           address1.setStreet(stockExchange.getAddress().getStreet());
	           address1.setZip_code(stockExchange.getAddress().getZip_code());
	           newEntity.setAddress(address1);
	           newEntity=rep2.save(newEntity);
	           return newEntity;
	           
	           
	        }
	        else
	        {
	        	return rep2.save(stockExchange);
	        }
	       
	    }
		
		
		
	
	public StockExchange getStockExchangeByName(String name)
	{
		Optional<StockExchange> stockExchange=Optional.ofNullable(rep2.findByName(name));
		return  stockExchange.orElse(null);
	}
	public List<Company> getCompanies(int id){
		
		Optional<StockExchange> stockExchangeOptional = rep2.findById(id);
        return stockExchangeOptional.map(StockExchange::getCompanies).orElse(null);
    }
	public StockExchange addCompanyToExchange(String stockExchangeName,Company entity)
	{
		StockExchange stockExchange = rep2.findByName(stockExchangeName);
        if(stockExchange == null)
            return null;
        stockExchange.getCompanies().add(entity);
        stockExchange = rep2.save(stockExchange);
        return stockExchange;
		
	}
	}
	
   

