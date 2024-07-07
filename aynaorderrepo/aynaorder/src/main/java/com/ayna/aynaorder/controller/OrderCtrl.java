package com.ayna.aynaorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayna.aynaorder.entity.Order;
import com.ayna.aynaorder.external.OrderToStockService;
import com.ayna.aynaorder.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderCtrl {
	@Autowired
	OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

		return orderService.saveOrder(order);
	}

	@GetMapping("/allOrders")
	public List<Order> fetchAllOrder() {
		return orderService.getAllOrders();
	}

	@DeleteMapping("/deleteOrder/{OrderId}")
	public void deleteOrderbyId(@PathVariable("OrderId") Long iid) {
		orderService.deleteOrder(iid);
	}

	@GetMapping("/getOrder/{orderId}")
	public Order fetchOrderByOrderId(@PathVariable Long orderId) {
		return orderService.getOrderById(orderId);
	}
}