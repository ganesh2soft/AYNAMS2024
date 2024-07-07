package com.ayna.aynaproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayna.aynaproduct.entity.Product;
import com.ayna.aynaproduct.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;
	
	
	public Product saveProduct(Product Product) {
		// TODO Auto-generated method stub
		return productRepo.save(Product);
	}

	
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	
	public void deleteProduct(Long ProductId) {
		productRepo.deleteById(ProductId);
		
	}
}
