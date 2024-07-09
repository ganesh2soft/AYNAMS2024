package com.ayna.aynastock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayna.aynastock.entity.Stock;
import com.ayna.aynastock.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200" ,allowedHeaders = "*", exposedHeaders = {"Content-Type"})
//, allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
//		RequestMethod.PUT, RequestMethod.DELETE })
public class StockCtrl {
	@Autowired
	StockService stockService;

	@PostMapping("/addStock")
	public Stock saveStock(@RequestBody Stock Stock) {
		return stockService.saveStock(Stock);
	}

	@GetMapping("/allStocks")
	public List<Stock> fetchAllStock() {
		return stockService.getAllStocks();
	}

	@DeleteMapping("/deleteStock/{StockId}")
	public void deleteStockbyId(@PathVariable("StockId") Long iid) {
		stockService.deleteStock(iid);
	}

	

	@PutMapping("/updateStock/{stockId}")
	public ResponseEntity<Stock> updateStock(@PathVariable("stockId") Long stockId, @RequestBody Stock updatedStock) {

		Stock updated = stockService.updateStock(stockId, updatedStock);
		if (updated == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(updated);
	}
	
	/*
	 * Below @GetMapping @PutMapping can be used BY FEIGN CLIENT (AYNAORDER MICRO)
	 */
	@GetMapping("/getstock/{productId}")
	public int getStockUnits(@PathVariable Long productId) {
        int stockUnits = stockService.getStockUnitsByProductId(productId);
        return stockUnits;
    }
	
	
	@PutMapping("/updateStockbyProd/{productId}/{stockUnits}")
	public ResponseEntity<Stock> updateStockbyProdCtrl(@PathVariable("productId") Long productId, @PathVariable("stockUnits")int stockUnits) {
		Stock updated = stockService.updateStockbyProdsrv(productId, stockUnits);
		
		if (updated == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(updated);
	}
	
	
	
}
