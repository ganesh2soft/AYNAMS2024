package com.ayna.aynaorder.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayna.aynaorder.entity.Order;

public interface OrderService {
	public ResponseEntity<Order> saveOrder(Order Order);

	public List<Order> getAllOrders();

	public void deleteOrder(Long OrderId);

	public Order getOrderById(Long orderId);

	public int preCheckSrv(Long productId);
	public void dummyUpdateStocksrv(Long productId,int stockUnits);
}
