package com.wipro.customer.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.customer.model.Order;

public interface OrderRepo extends CrudRepository<Order, Integer> 
{
	public Order findByCustomerCustomerID(int customerID);
}
