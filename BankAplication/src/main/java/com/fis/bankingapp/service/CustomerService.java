package com.fis.bankingapp.service;

import java.util.List;

import com.fis.bankingapp.model.Customer;

public interface CustomerService {
	public String createCustomer(Customer customer );
	public List<Customer> showCustomerData();

}
