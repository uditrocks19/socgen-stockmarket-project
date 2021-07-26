package com.stockapp.exchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stockapp.exchangeservice.entitiy.*;

import java.util.List;

import com.stockapp.exchangeservice.services.*;

@RestController
@RequestMapping("/stockexchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;


    @GetMapping("/stockexchanges")
    private ResponseEntity<List<StockExchange>> getAllStockExchanges()
    {
        return ResponseEntity.ok(stockExchangeService.getAllStockExchanges());
    }

    @GetMapping("/stockexchanges/{exchangeid}")
    private ResponseEntity getStockExchanges(@PathVariable("exchangeid") int exchangeId)
    {
        if (stockExchangeService.getStockExchangeById(exchangeId)!=null)
        {
            return ResponseEntity.ok(stockExchangeService.getStockExchangeById(exchangeId));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StockExchange with id "+ exchangeId+" not found.");
        }
    }

    @PostMapping("/stockexchanges")
    private ResponseEntity<StockExchange> saveStockExchange(@RequestBody StockExchange stockExchange)
    {
        return ResponseEntity.ok(stockExchangeService.addStockExchange(stockExchange));
    }

    @PutMapping("/stockexchanges/{id}")
    private ResponseEntity updateSector(@PathVariable int id, @RequestBody StockExchange stockExchange){

        return ResponseEntity.ok(stockExchangeService.updateStockExchange(id,stockExchange));
    }

    @DeleteMapping("/stockexchanges/{id}")
    private ResponseEntity deleteStockExchange(@PathVariable int id){

        if (!stockExchangeService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/stockexchanges/name/{name}")
    private ResponseEntity getStockExchangeByName(@PathVariable("name") String stockExchangeName)
    {
        if (stockExchangeService.getStockExchangeByName(stockExchangeName)!=null)
        {
            return ResponseEntity.ok(stockExchangeService.getStockExchangeByName(stockExchangeName).getId());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with name "+ stockExchangeName+" not found.");
        }
    }

    @GetMapping("/stockexchanges/companies/{id}")
    private ResponseEntity getCompanies(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://COMPANY-SERVICE/company/getCompanyByExchange/"+id;
		return restTemplate.getForEntity(url, String.class);
    }


}