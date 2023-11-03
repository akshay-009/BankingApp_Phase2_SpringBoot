package com.fis.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankingapp.model.Customer;
import com.fis.bankingapp.service.CustomerService;
//{
//	"customerName": ""Akshay",
//	"customermobno": 8830309095,
//	"password": "Akshay@123",
//	"customermail": "a@gmail.com",
//	"customerdob": "27/04/2001",
//	"customerpermadd": "pune"
//}
@RestController
@RequestMapping("/customer") // http://localhost:8080/customer
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@PostMapping("/createCustomer") // http://localhost:8080/customer/createCustomer
	public String createCustomer(@RequestBody Customer customer ) {
		return service.createCustomer(customer);
	}
	
	@GetMapping("/showCustomerData") // http://localhost:8080/customer/showCustomerData
	public List<Customer> showCustomerData(){
		return service.showCustomerData();
		
	}

}
