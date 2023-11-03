package com.fis.bankingapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//{
//    "accopendate": "2023-11-02",
//    "accounttype": "Savings",
//    "balance": 0,
//    "branch": "Aundh"
//}
@Entity
@Table(name="Account_details")

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acc")
	private long accountNumber;

	@ManyToOne
	//@JoinColumn(name="customerId")
	@JoinColumn(name = "id")
	private Customer customer;
	
//	private long customerId;
	private String accounttype;
	private Date accopendate;
	private double balance;
	private String branch;
	
	

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Customer getCustomer() {
	        return customer;
	    }

    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public Date getAccopendate() {
		return accopendate;
	}
	public void setAccopendate(Date accopendate) {
		this.accopendate = accopendate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Account [ accountNumber=%s, accounttype=%s, accopendate=%s, balance=%s, branch=%s]",
				 accountNumber, accounttype, accopendate, balance, branch);
	}
	
	public Account( long accountNumber, String accounttype, Date accopendate, double balance,
			String branch) {
		super();
//		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accounttype = accounttype;
		this.accopendate = accopendate;
		this.balance = balance;
		this.branch = branch;
	}
	
	public Account() {
		
	}

}
