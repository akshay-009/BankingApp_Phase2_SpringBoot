package com.fis.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankingapp.dao.CustomerDao;
import com.fis.bankingapp.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao dao;
	@Override
	public String createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
		
	}

	@Override
	public List<Customer> showCustomerData() {
		// TODO Auto-generated method stub
		return dao.showCustomerData();
	}

}
