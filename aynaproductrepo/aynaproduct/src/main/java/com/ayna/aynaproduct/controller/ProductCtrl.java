package com.ayna.aynaproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayna.aynaproduct.entity.Product;
import com.ayna.aynaproduct.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCtrl {
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public Product  saveProduct (@RequestBody Product Product) {
		return productService.saveProduct(Product);
	}
	
	@GetMapping("/allProducts")
	public List<Product> fetchAllProduct (){
		return productService.getAllProducts();
	}
	@DeleteMapping("/deleteproduct/{ProductId}")
	public void deleteProductbyId(@PathVariable("ProductId") Long iid) {
		productService.deleteProduct(iid);
}
}
