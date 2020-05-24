package com.wipro.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customer.model.Customer;
import com.wipro.customer.service.CustomerService;


@RestController
public class CustomerController {


	@Autowired
	@Qualifier("orderController")
	OrderController orderController;
	
	@Autowired
	CustomerService customerService;


	@RequestMapping(method = RequestMethod.GET, value="/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}

	@RequestMapping(method = RequestMethod.GET, value="/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId){
		return customerService.getCustomer(customerId);
	}


	@RequestMapping(method = RequestMethod.POST, value="/customers")
	public Customer addCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);

	}

	@RequestMapping(method = RequestMethod.PUT, value="/customers/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
		customer.setCustomerID(customerId);
		return customerService.addCustomer(customer);

	}

	@RequestMapping(method = RequestMethod.DELETE, value="/customers/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId)
	{
		Customer customer = customerService.getCustomer(customerId);
		customerService.deleteCustomer(customer);
	}
//	
//	@RequestMapping(value = "customers/{customerId}/orders")
//    public OrderController getCommentResource() {
//        return orderController;
//    }
}
