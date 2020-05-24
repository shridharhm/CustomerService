package com.wipro.customer.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers_table")
public class Customer {

	@Id
	private int customerID;
	private String name;
	private String email;
	@Embedded
	private Adress adress;
	@OneToOne(cascade = CascadeType.ALL)
	private Order orders;
	
	
	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Adress getAdress() {
		return adress;
	}


	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	public Order getOrder() {
		return orders;
	}


	public void setOrder(Order orders) {
		this.orders = orders;
	}


	public Customer(int customerID, String name, String email) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
	}
	public Customer(int customerID, String name, String email, Adress adress) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.adress = adress;
	}
	public Customer(int customerID, String name, String email, Adress adress, Order orders) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.orders = orders;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + "]";
	}
	
	
}
