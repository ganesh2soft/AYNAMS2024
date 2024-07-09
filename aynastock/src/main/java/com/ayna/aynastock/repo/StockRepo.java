package com.ayna.aynastock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayna.aynastock.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
	Stock findByProductId(Long productId);
	
}
