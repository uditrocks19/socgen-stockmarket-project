package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Stock;
import repositories.StockRepository;


@Service
public class StockService {
    @Autowired
    public StockRepository stockRepository;

    public List<Stock> getStock(){
        return stockRepository.findAll();
        }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }
}