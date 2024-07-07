package com.ayna.aynaorder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayna.aynaorder.entity.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
