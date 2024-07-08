package com.ayna.aynaorder.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
           
    @Column(name="product_id")
	private Long productId;   
    
    @Column(name="items_ordered")
	private int itemsOrdered;
	
	@Column(name="unit_price")
	private int unitPrice;

    @Column(name="total_cost")
	private int totalCost;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(int itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemsOrdered, orderId, productId, totalCost, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return itemsOrdered == other.itemsOrdered && Objects.equals(orderId, other.orderId)
				&& Objects.equals(productId, other.productId) && totalCost == other.totalCost
				&& unitPrice == other.unitPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", itemsOrdered=" + itemsOrdered
				+ ", unitPrice=" + unitPrice + ", totalCost=" + totalCost + "]";
	}

	public Order(Long orderId, Long productId, int itemsOrdered, int unitPrice, int totalCost) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.itemsOrdered = itemsOrdered;
		this.unitPrice = unitPrice;
		this.totalCost = totalCost;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	



}