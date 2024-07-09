package com.ayna.aynaorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@FeignClient(name = "AYNASTOCK/api/v1/stock/")
public interface OrderToStockService {

	@GetMapping("/getstock/{productId}")
	int getStockUnits(@PathVariable("productId") Long productId);
	
	@PutMapping("/updateStockbyProd/{productId}/{stockUnits}")
	void updateStockbyProdCtrl(@PathVariable("productId") Long productId, @PathVariable("stockUnits")int stockUnits);
}

