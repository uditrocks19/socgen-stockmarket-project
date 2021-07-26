package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Stock;
import services.StockService;

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