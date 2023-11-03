package com.fis.bankingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Customer_details")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private long customermobno;
	private String password;
	private String customermail;
	private String customerdob;
	private String customerpermadd;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomermobno() {
		return customermobno;
	}

	public void setCustomermobno(long customermobno) {
		this.customermobno = customermobno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomermail() {
		return customermail;
	}

	public void setCustomermail(String customermail) {
		this.customermail = customermail;
	}

	public String getCustomerdob() {
		return customerdob;
	}

	public void setCustomerdob(String customerdob) {
		this.customerdob = customerdob;
	}

	public String getCustomerpermadd() {
		return customerpermadd;
	}

	public void setCustomerpermadd(String customerpermadd) {
		this.customerpermadd = customerpermadd;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [id=%s, customerName=%s, customermobno=%s, password=%s, customermail=%s, customerdob=%s, customerpermadd=%s]",
				id, customerName, customermobno, password, customermail, customerdob, customerpermadd);
	}

	public Customer(int id, String customerName, long customermobno, String password, String customermail,
			String customerdob, String customerpermadd) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customermobno = customermobno;
		this.password = password;
		this.customermail = customermail;
		this.customerdob = customerdob;
		this.customerpermadd = customerpermadd;
	}

	public Customer() {
		
	}
	

}
