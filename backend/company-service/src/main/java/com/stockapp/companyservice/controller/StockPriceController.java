package com.stockapp.companyservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockapp.companyservice.dtos.ExcelDataDto;
import com.stockapp.companyservice.entities.StockPrice;
import com.stockapp.companyservice.services.StockPriceService;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/company")
public class StockPriceController {

    @Autowired
    public StockPriceService stockPriceService;

    @GetMapping("/StockPrice")
    public ResponseEntity<List<StockPrice>> getStockPrice(){
        return ResponseEntity.ok(stockPriceService.getStockPrice());
    }

    @PostMapping("/StockPrice")
    public ResponseEntity<List<ExcelDataDto>> addStockPrice(@RequestBody List<ExcelDataDto> excelDataDto){
        return ResponseEntity.ok(stockPriceService.addStockPrice(excelDataDto));
    }

    @GetMapping("/StockPrice/companyId/{companyId}/exchangeId/{exchangeId}/fromTime/{fromTime}/toTime/{toTime}")
    public ResponseEntity<List<StockPrice>> getStockPrice(@PathVariable int companyId, @PathVariable int exchangeId, @PathVariable String fromTime, @PathVariable String toTime) throws ParseException {
        return ResponseEntity.ok(stockPriceService.getStockPricesForCompanyComparison(companyId, exchangeId, fromTime, toTime));
    }
}