package com.wipro.customer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customer.dao.CustomerRepo;
import com.wipro.customer.model.Customer;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer) {

		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer;
	}

	public Customer updateCustomer(Customer customer) {

		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer;
	}

	public Customer getCustomer(int customerId)
	{
		Iterable<Customer> all = customerRepo.findAll();
		Iterator<Customer> iterator = all.iterator();

		while(iterator.hasNext())
		{
			Customer next = iterator.next();
			if(customerId==next.getCustomerID())
			{
				return next;
			}
		}

		return new Customer();
	}

	public List<Customer> getAllCustomers(){

		List<Customer> customers = new ArrayList<>();
		Iterable<Customer> all = customerRepo.findAll();
		Iterator<Customer> iterator = all.iterator();

		while(iterator.hasNext())
		{
			Customer customer = iterator.next();
			customers.add(customer);
		}
		return customers;

	}
	
	public void deleteCustomer(Customer customer)
	{
		customerRepo.delete(customer);
	}

	
}


