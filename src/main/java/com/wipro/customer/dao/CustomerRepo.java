package com.wipro.customer.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.customer.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> 
{
}
