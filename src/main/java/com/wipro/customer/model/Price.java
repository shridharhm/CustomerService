package com.wipro.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

public class Price {
	private Integer priceId;
	private String productId;
	private Double price;
	
	public Price(Integer priceId, String productId, Double price,int port) {
		this.priceId = priceId;
		this.productId = productId;
		this.price = price;
	}
	public Price(Integer priceId, String productId, Double price) {
		super();
		this.priceId = priceId;
		this.productId = productId;
		this.price = price;
		
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "PriceEntity [priceId=" + priceId + ", productId=" + productId + ", price=" + price + "]";
	}
	
	
	
}
