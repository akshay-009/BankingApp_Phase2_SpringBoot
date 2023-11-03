package com.fis.bankingapp.dao;

import java.util.Date;
import java.util.List;

import com.fis.bankingapp.exceptions.AccountNotFound;
import com.fis.bankingapp.exceptions.NotEnoughBalance;
import com.fis.bankingapp.model.Account;

public interface AccountDao {
	// This is the interface in dao layer for account transactions
	public String createAccount(Account account);
	public Account getAccount(long getAcc); 
	public List<Account> getAllAccounts();
	public String updateAccount(Account account);
	public String deleteAccount(long getacc);
	
	public String deposit(long getAcc, double depositAmount) throws AccountNotFound;
	public String withdraw(long getAcc, double withdrawAmount) throws AccountNotFound, NotEnoughBalance; 
	public String fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFound, NotEnoughBalance;
	
	public double interestEarned(long getAcc,Date todaydate);


}
