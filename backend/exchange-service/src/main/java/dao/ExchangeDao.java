package dao;


import entitiy.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import repostory.ExchangeRepository;

public class ExchangeDao{
	
	@Autowired
	private ExchangeRepository rep;
	public List<Exchange> getStockExchangeList()
	{
		return rep.findAll();
	}
	public String addStockExchnage(Exchange exchange)
	{
		rep.save(exchange);
		return "added Successfully "+"with id "+exchange.getId();
	}
	

}
