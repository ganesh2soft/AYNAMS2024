package com.ayna.aynastock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ayna.aynastock.entity.Stock;
import com.ayna.aynastock.repo.StockRepo;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepo stockRepo;

	public Stock saveStock(Stock stock) {
		// TODO Auto-generated method stub
		return stockRepo.save(stock);
	}

	public List<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		return stockRepo.findAll();
	}

	public void deleteStock(Long stockId) {
		stockRepo.deleteById(stockId);

	}

	public Stock updateStock(@PathVariable("stockId") Long stockId, Stock stock) {
		Optional<Stock> optionalStock = stockRepo.findById(stockId);
		if (optionalStock.isPresent()) {
			Stock existingStock = optionalStock.get();
			// Update fields
			existingStock.setProductId(stock.getProductId());
			existingStock.setUnitPrice(stock.getUnitPrice());
			existingStock.setStockUnits(stock.getStockUnits());

			return stockRepo.save(existingStock);
		}
		return null; // Return null if stock with given ID not found
	}

	public int getStockUnitsByProductId(int productId) {
		Stock stock = stockRepo.findByProductId(productId);
		if (stock != null) {
			return stock.getStockUnits();
		} else {
			throw new RuntimeException("Stock with productId " + productId + " not found");
		}
	}
}
