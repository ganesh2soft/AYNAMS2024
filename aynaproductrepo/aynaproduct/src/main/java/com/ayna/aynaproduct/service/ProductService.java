package com.ayna.aynaproduct.service;

import java.util.List;



import com.ayna.aynaproduct.entity.Product;


public interface ProductService {
	public Product saveProduct(Product Product);
	public List<Product> getAllProducts();
	public void deleteProduct(Long ProductId);
}
