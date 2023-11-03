package com.fis.bankingapp.service;

import java.util.Date;
import java.util.List;

import com.fis.bankingapp.exceptions.AccountNotFound;
import com.fis.bankingapp.exceptions.NotEnoughBalance;
import com.fis.bankingapp.model.Account;

public interface AccountService {
	public String createAccount(Account account);
	public Account getAccount(long getAcc); 
	public List<Account> getAllAccounts();
	public String updateAccount(Account account);
	public String deleteAccount(long getacc);
	
	public String deposit(long getAcc, double depositAmount) throws AccountNotFound;
	public String withdraw(long getAcc, double withdrawAmount) throws AccountNotFound, NotEnoughBalance; 
	public String fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFound, NotEnoughBalance;
	
	public Double interestEarned(long getAcc,Date todaydate);

}
