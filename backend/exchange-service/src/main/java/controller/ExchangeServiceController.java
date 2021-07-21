package controller;

import java.util.List;

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
import entitiy.*;


import services.ExchangeServices;

@RestController
@RequestMapping("/stockExchange")
public class ExchangeServiceController {
	
		@Autowired
		private ExchangeServices exchangeServices;
		@GetMapping("/stockexchanges")
		private ResponseEntity<List<StockExchange>> getAllStockExchanges()
		{
			return ResponseEntity.ok(exchangeServices.getAllStockExchanges());
		}
		@GetMapping("/stockexchanges/{exchangeid}")
		public ResponseEntity getStockExchanges(@PathVariable("exchangeid") int exchangeId)
		{
			if(exchangeServices.getStockExchangeById(exchangeId)!=null)
			{
				return ResponseEntity.ok(exchangeServices.getStockExchangeById(exchangeId));
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StockExchange with id "+ exchangeId+" not found.");
			}
		}
		@PostMapping("/stockexchanges")
	    private ResponseEntity<StockExchange> saveStockExchange(@RequestBody StockExchange stockExchange)
	    {
	        return ResponseEntity.ok(exchangeServices.addStockExchange(stockExchange));
	    }
		 @PutMapping("/stockexchanges/{id}")
		    private ResponseEntity updateSector(@PathVariable int id, @RequestBody StockExchange stockExchange){

		        return ResponseEntity.ok(exchangeServices.UpdateStockExchange(id, stockExchange));
		    }
		 @DeleteMapping("/stockexchanges/{id}")
		    private ResponseEntity deleteStockExchange(@PathVariable int id){

		        if (!exchangeServices.deleteById(id)) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<>(id, HttpStatus.OK);
		    }
		 @GetMapping("/stockexchanges/name/{name}")
		    private ResponseEntity getStockExchangeByName(@PathVariable("name") String stockExchangeName)
		    {
		        if (exchangeServices.getStockExchangeByName(stockExchangeName)!=null)
		        {
		            return ResponseEntity.ok(exchangeServices.getStockExchangeByName(stockExchangeName).getId());
		        }
		        else
		        {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with name "+ stockExchangeName+" not found.");
		        }
		    }
		 @GetMapping("/companies/{id}")
		    private ResponseEntity<List<Company>> getCompanies(@PathVariable("id") int id){
		        return ResponseEntity.ok(exchangeServices.getCompanies(id));
		    }



}
