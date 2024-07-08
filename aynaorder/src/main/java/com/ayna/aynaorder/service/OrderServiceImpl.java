package com.ayna.aynaorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayna.aynaorder.entity.Order;
import com.ayna.aynaorder.external.OrderToStockService;
import com.ayna.aynaorder.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepo orderRepo;

	@Autowired
	private OrderToStockService orderToStockService;
	
	@Override
    public int preCheckSrv(Long productId) {
    	int checker = orderToStockService.getStockUnits(productId);
    	System.out.println("Stock Availabity of product mentioned" + checker);
    	return checker;
    }
	
	@Override
	public ResponseEntity<Order> saveOrder(Order order) {

		/*
		 * checker has been fetched from AYNAPRODUCT SERVICE itemOrdered field should be
		 * greater than checker
		 */
		int checker = orderToStockService.getStockUnits(order.getProductId());
		System.out.println("Stock Availabity of product mentioned" + checker);

		if (checker < order.getItemsOrdered()) {
			System.out.println("Stock Availabity Error");
			// Insufficient stock scenario
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("X-Reason", "Alert! Insufficient Stock") // Watch
																													// headers
																													// in
																													// Postman
																													// response
					.body(null); // Or return an error message or specific response
		} else {
			// Sufficient stock, proceed with saving the order
			Order savedOrder = orderRepo.save(order);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
		}
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public void deleteOrder(Long OrderId) {
		orderRepo.deleteById(OrderId);

	}

	@Override
	public Order getOrderById(Long orderId) {
		Optional<Order> optionalOrder = orderRepo.findById(orderId);
		return optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with orderId: " + orderId));
	}
}
