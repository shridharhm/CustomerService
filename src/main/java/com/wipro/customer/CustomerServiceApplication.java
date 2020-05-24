package com.wipro.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.wipro.customer.model.Adress;
import com.wipro.customer.model.Customer;
import com.wipro.customer.model.Order;
import com.wipro.customer.service.CustomerService;
import com.wipro.customer.service.OrderService;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	private OrderService service;

	@Autowired
	private CustomerService service2;

	@Autowired
	private RestTemplate template;

	@Bean
//	@LoadBalanced
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}


	public static void main(String[] args) 
	{
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer c1 = new Customer(121,"John Smith","jsmithh@aol.com");
		Customer c2 = new Customer(122,"Steve Paul","spaul@aol.com");
		Customer c3 = new Customer(123,"Mark James","mjames@aol.com");

		Adress a1 = new Adress("Brigade Road","Bangalore","Karnataka",560001);
		Adress a2 = new Adress("Church Street", "Delhi", "New Delhi", 512658);
		Adress a3 = new Adress("MG Road","Hyyderabad","Telangana",4856958);

		c1.setAdress(a1);
		c2.setAdress(a2);
		c3.setAdress(a3);

		Order o1 = new Order(1,c1);
		Order o2 = new Order(2,c2);
		Order o3 = new Order(3,c3);
//		Order o4 = new Order(4);
//		Order o5 = new Order(5);
//		Order o6 = new Order(6);
		
		List<Integer> productIds1 = new ArrayList<>();
		List<Integer> productIds2 = new ArrayList<>();
		List<Integer> productIds3 = new ArrayList<>();

		productIds1.add(1);
		productIds1.add(2);
		productIds2.add(3);
		productIds2.add(4);
		productIds3.add(5);
		productIds3.add(6);


		o1.setProductIds(productIds1);
		o2.setProductIds(productIds2);
		o3.setProductIds(productIds3);
//		for(int i : productIds)
//		{
//			if(i<=6)
//			{
//				if(i%2==0)
//				{
//					Product product = template.getForObject("http://localhost:9191/api/serviceapp/getProduct/"+i, Product.class);
//					o1.getProducts().add(product);
//				}
//
//				else
//				{
//					Product product = template.getForObject("http://localhost:9191/api/serviceapp/getProduct/"+i, Product.class);
//					o2.getProducts().add(product);
//				}
//			}
//			
//			else
//			{
//				Product product = template.getForObject("http://localhost:9191/api/serviceapp/getProduct/"+i, Product.class);
//				o3.getProducts().add(product);
//			}
//		}
		
		
		c1.setOrder(o1);
		c2.setOrder(o2);
		c3.setOrder(o3);
		
		
		service2.addCustomer(c1);
		service2.addCustomer(c2);
		service2.addCustomer(c3);
		
//		List<Order> orders1 = new ArrayList<>();
//		List<Order> orders2 = new ArrayList<>();
//		List<Order> orders3 = new ArrayList<>();
//		
//		
//		orders1.add(o1);
//		orders1.add(o2);
//		orders2.add(o3);
//		orders2.add(o4);
//		orders3.add(o5);
//		orders3.add(o6);

	}

}
