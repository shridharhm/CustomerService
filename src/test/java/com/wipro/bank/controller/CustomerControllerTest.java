package com.wipro.bank.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wipro.customer.controller.CustomerController;
import com.wipro.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private  CustomerService customerService;
	
	
	@Test
	public void testGetAllAccounts() throws Exception {
		mvc.perform(get("/customers/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void testGetAllCustomers() throws Exception {
		mvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
}
