package com.wipro.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customer.model.Order;
import com.wipro.customer.service.OrderService;


@RestController
@RequestMapping(value="/")
public class OrderController {


	@Autowired
	OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET, value="/orders")
	public List<Order> getAllOrders(){
		System.out.println("***********");
		return orderService.getAllOrders();
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/ordersByCustomerId/{customerId}")
	public Order getTestOrder(@PathVariable("customerId") int customerId)
	{
		System.out.println("$$$$$$$$$$$$$");
		return orderService.getOrderByCustomerId(customerId);
	}

	@RequestMapping(method = RequestMethod.GET, value="/orders/{orderId}")
	public Order getOrder(@PathVariable("orderId") int orderId){
		return orderService.getOrder(orderId);
	}


	@RequestMapping(method = RequestMethod.POST,value="/orders")
	public Order addOrder(@RequestBody Order order){
		return orderService.addOrder(order);

	}

	@RequestMapping(method = RequestMethod.PUT, value="/orders/{orderId}")
	public Order updateOrder(@PathVariable("orderId") int orderId,@RequestBody Order order){
		order.setOrderId(orderId);
		return orderService.addOrder(order);

	}

	@RequestMapping(method = RequestMethod.DELETE, value="/orders/{orderId}")
	public void deleteOrder(@PathVariable("orderId") int orderId)
	{
		Order order = orderService.getOrder(orderId);
		orderService.deleteOrder(order);

	}
	
	

}
