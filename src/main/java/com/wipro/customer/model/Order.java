package com.wipro.customer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders_table")
public class Order 
{
	
	@Id
	private int orderId;
	
	private double orderAmount;
	@ElementCollection 
	//@JsonIgnore
	private List<Integer> productIds;
	
	private String promoCode;
	
	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	@XmlTransient
	public List<Integer> getProductIds() {
		return productIds;
	}
	
	public Order(int orderId, Customer customer) {
		super();
		this.orderId = orderId;
		this.customer = customer;
	}
	public void setProductIds(List<Integer> productId) {
		this.productIds = productId;
	}
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="test")
	private List<Product> products;
	
	private boolean orderStatus;
	
	
	
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	public Order(int orderId) {
		super();
		this.orderId = orderId;
		//this.customer = customer;
	}
	
	
	
	public Order(int orderId, List<Product> products) {
		super();
		this.orderId = orderId;
		this.products = products;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	@XmlTransient
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
