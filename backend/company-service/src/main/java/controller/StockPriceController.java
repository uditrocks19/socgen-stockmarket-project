package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.StockPrice;
import services.StockPriceService;

@RestController
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
    public ResponseEntity<List<StockPrice>> getStockPrice(@PathVariable int companyId, @PathVariable int exchangeId, @PathVariable String fromTime, @PathVariable String toTime){
        return ResponseEntity.ok(stockPriceService.getStockPrice(companyId, exchangeId, fromTime, toTime));
    }
}