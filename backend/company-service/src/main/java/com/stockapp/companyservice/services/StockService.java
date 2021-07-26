package com.stockapp.companyservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapp.companyservice.entities.Stock;
import com.stockapp.companyservice.repositories.StockRepository;

import java.util.List;

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