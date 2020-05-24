package com.wipro.customer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wipro.customer.dao.OrderRepo;
import com.wipro.customer.model.Inventory;
import com.wipro.customer.model.Order;
import com.wipro.customer.model.Price;
import com.wipro.customer.model.Product;

@Service
public class OrderService
{
	@Autowired
	OrderRepo orderRepo;

	@Autowired
	private RestTemplate template;

	@HystrixCommand
	public Order addOrder(Order order) {
		int orderAmount=0;

		List<Integer> ids = order.getProductIds();
		List<Product> products = new ArrayList<>();
		for(int i : ids)
		{
			Product product = template.getForObject("http://localhost:9191/api/serviceapp/getProduct/"+i, Product.class);

			if(product !=null)
			{
				Price price = template.getForObject("http://localhost:9191/price-service/"+i, Price.class);
				//insert the promotion logic here..


				orderAmount+=price.getPrice();
				Inventory inventory = template.getForObject("http://localhost:9191getInventoryByProductId/"+i, Inventory.class);
				inventory.setNumberOfItems(inventory.getNumberOfItems()-1);
				template.put("http:localhost:9191/modifyInventory", inventory);
				products.add(product);

			}
		}
		order.setProducts(products);
		order.setOrderAmount(orderAmount);



		return order;
	}

	//	public Order addOrder(Order order) {
	//
	//
	//		Order savedOrder = orderRepo.save(order);
	//		return savedOrder;
	//	}

	public Order updateOrder(Order order) {

		Order savedOrder = orderRepo.save(order);
		return savedOrder;
	}


	public Order getOrder(int orderId)
	{
		Iterable<Order> all = orderRepo.findAll();
		Iterator<Order> iterator = all.iterator();

		while(iterator.hasNext())
		{
			Order next = iterator.next();
			if(orderId==next.getOrderId())
			{
				return next;
			}
		}

		return new Order();
	}

	public List<Order> getAllOrders(){

		List<Order> orders = new ArrayList<>();
		Iterable<Order> all = orderRepo.findAll();
		Iterator<Order> iterator = all.iterator();

		while(iterator.hasNext())
		{
			Order order = iterator.next();
			orders.add(order);
		}
		return orders;

	}

	public void deleteOrder(Order order)
	{
		orderRepo.delete(order);
	}

	//@HystrixCommand(fallbackMethod="addFallbackOrder")
	public Order addFallbackOrder(Order order)
	{
		System.out.println("Product Service down..calling the fallback method");
		return order;
	}

	public Order getOrderByCustomerId(int customerId)
	{
		System.out.println("$$$$$$$$$$$$$");
		return orderRepo.findByCustomerCustomerID(customerId);
	}
}


