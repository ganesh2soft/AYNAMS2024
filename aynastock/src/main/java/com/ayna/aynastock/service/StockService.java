package com.ayna.aynastock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ayna.aynastock.entity.Stock;

public interface StockService {
	public Stock saveStock(Stock Stock);

	public List<Stock> getAllStocks();

	public void deleteStock(Long StockId);

	public Stock updateStock(@PathVariable("stockId") Long stockId, Stock stock);

	public Stock updateStockbyProdsrv(Long productId, int stockUnits);
	
	public int getStockUnitsByProductId(Long productId);
}
