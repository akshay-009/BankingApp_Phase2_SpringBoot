package com.fis.bankingapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankingapp.dao.AccountDao;
import com.fis.bankingapp.exceptions.AccountNotFound;
import com.fis.bankingapp.exceptions.NotEnoughBalance;
import com.fis.bankingapp.model.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao dao;
	
	@Override
	public String createAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.createAccount(account);
	}

	@Override
	public Account getAccount(long getAcc) {
		// TODO Auto-generated method stub
		return dao.getAccount(getAcc);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return dao.getAllAccounts();
	}

	@Override
	public String updateAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.updateAccount(account);
	}

	@Override
	public String deleteAccount(long getacc) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(getacc);
		
	}

	@Override
	public String deposit(long getAcc, double depositAmount) throws AccountNotFound {
		// TODO Auto-generated method stub
		return dao.deposit(getAcc, depositAmount);
		
	}

	@Override
	public String withdraw(long getAcc, double withdrawAmount ) throws AccountNotFound, NotEnoughBalance {
		// TODO Auto-generated method stub
		return dao.withdraw(getAcc, withdrawAmount);
		
	}

	@Override
	public String fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFound, NotEnoughBalance {
		// TODO Auto-generated method stub
		return dao.fundTransfer(fromAcc, toAcc, amount);
	}

	@Override
	public Double interestEarned(long getAcc, Date todaydate) {
		// TODO Auto-generated method stub
		return dao.interestEarned(getAcc, todaydate);
	}



}
