package com.fis.bankingapp.dao;

import java.util.List;

import com.fis.bankingapp.model.Customer;

public interface CustomerDao {
	// This is the interface in dao layer for customer transactions
	public String createCustomer(Customer customer );
	public List<Customer> showCustomerData();
}
