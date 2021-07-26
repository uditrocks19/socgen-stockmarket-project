package com.stockapp.companyservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockapp.companyservice.entities.Stock;
import com.stockapp.companyservice.services.StockService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class StockController {
    @Autowired
    public StockService stockService;

    @GetMapping("/stocks")
    private ResponseEntity<List<Stock>> getStock(){
        return ResponseEntity.ok(stockService.getStock());
    }

    @PostMapping("/stocks")
    private ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return ResponseEntity.ok(stockService.addStock(stock));
    }
}