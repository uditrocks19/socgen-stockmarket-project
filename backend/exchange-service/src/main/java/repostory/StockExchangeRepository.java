package repostory;

import org.springframework.data.repository.CrudRepository;

import entitiy.StockExchange;

public interface  StockExchangeRepository extends CrudRepository<StockExchange,Integer> {
	StockExchange findByName(String stockExchangeByName);

	void deleteById(int id);

	
	

}
