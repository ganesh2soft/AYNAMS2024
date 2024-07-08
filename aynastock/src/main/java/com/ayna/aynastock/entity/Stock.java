package com.ayna.aynastock.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocktbl")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "stock_units")
	private int stockUnits;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getStockUnits() {
		return stockUnits;
	}

	public void setStockUnits(int stockUnits) {
		this.stockUnits = stockUnits;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, stockId, stockUnits);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return productId == other.productId && Objects.equals(stockId, other.stockId) && stockUnits == other.stockUnits;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", productId=" + productId + ", stockUnits=" + stockUnits + "]";
	}

	public Stock(Long stockId, int productId, int stockUnits) {
		super();
		this.stockId = stockId;
		this.productId = productId;
		this.stockUnits = stockUnits;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}