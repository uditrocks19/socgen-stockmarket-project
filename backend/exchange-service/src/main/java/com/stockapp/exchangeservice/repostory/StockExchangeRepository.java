package com.stockapp.exchangeservice.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.exchangeservice.entitiy.*;
@Repository
public interface  StockExchangeRepository extends JpaRepository<StockExchange,Integer> {
	StockExchange findByName(String stockExchangeByName);

	

	
	

}
