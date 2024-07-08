package com.ayna.aynaproduct.entity;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producttbl")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@Column(name="seller_name",unique=true)
	private String sellerName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name = "listed_date")
	@CreationTimestamp
	private Date listedDate;
	
	@Column(name = "unit_price")
	private int unitPrice;
	
	@Column(name="image_url")
	private String imageUrl;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName, imageUrl, listedDate, productId, productName, sellerName, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(listedDate, other.listedDate) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName) && Objects.equals(sellerName, other.sellerName)
				&& unitPrice == other.unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", sellerName=" + sellerName + ", productName=" + productName
				+ ", categoryName=" + categoryName + ", listedDate=" + listedDate + ", unitPrice=" + unitPrice
				+ ", imageUrl=" + imageUrl + "]";
	}

	public Product(Long productId, String sellerName, String productName, String categoryName, Date listedDate,
			int unitPrice, String imageUrl) {
		super();
		this.productId = productId;
		this.sellerName = sellerName;
		this.productName = productName;
		this.categoryName = categoryName;
		this.listedDate = listedDate;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
