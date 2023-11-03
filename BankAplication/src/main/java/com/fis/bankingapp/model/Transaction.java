package com.fis.bankingapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_details")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transid;
	private long fromaccount;
	private long toaccount;
	private double amount;
	private Date transtime;
	private String transtype;
	private String status;
//	public int getTransid() {
//		return transid;
//	}
//	public void setTransid(int transid) {
//		this.transid = transid;
//	}
	public long getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(long fromaccount) {
		this.fromaccount = fromaccount;
	}
	public long getToaccount() {
		return toaccount;
	}
	public void setToaccount(long toaccount) {
		this.toaccount = toaccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTranstime() {
		return transtime;
	}
	public void setTranstime(Date transtime) {
		this.transtime = transtime;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Transaction [transid=%s, fromaccount=%s, toaccount=%s, amount=%s, transtime=%s, transtype=%s, status=%s]",
				transid, fromaccount, toaccount, amount, transtime, transtype, status);
	}
	
	public Transaction(int transid, long fromaccount, long toaccount, double amount, Date transtime, String transtype,
			String status) {
		super();
		this.transid = transid;
		this.fromaccount = fromaccount;
		this.toaccount = toaccount;
		this.amount = amount;
		this.transtime = transtime;
		this.transtype = transtype;
		this.status = status;
	}
	
	public Transaction() {
		
	}
}
