package com.ayna.aynaproduct.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayna.aynaproduct.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
