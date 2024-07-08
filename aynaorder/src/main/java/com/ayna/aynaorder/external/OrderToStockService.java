package com.ayna.aynaorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AYNASTOCK/api/v1/stock/")
public interface OrderToStockService {

	@GetMapping("/getstock/{productId}")
	int getStockUnits(@PathVariable("productId") Long productId);
}
