package com.fis.bankingapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fis.bankingapp.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
		return "Customer Created Succesfully";
		
	}

	@Override
	public List<Customer> showCustomerData() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
		return query.getResultList();
	}

}
