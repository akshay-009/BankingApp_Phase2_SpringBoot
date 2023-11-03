package com.fis.bankingapp.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fis.bankingapp.exceptions.AccountNotFound;
import com.fis.bankingapp.exceptions.NotEnoughBalance;
import com.fis.bankingapp.model.Account;


@Repository
public class AccountDaoImpl implements AccountDao {
	

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public String createAccount(Account account) {
		// TODO Auto-generated method stub
		entityManager.persist(account);
		return "Account Created Successfully";
	}

	
	@Override
	public Account getAccount(long getAcc) {
		// TODO Auto-generated method stub
		return entityManager.find(Account.class, getAcc);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		TypedQuery<Account> query = entityManager.createQuery("select a from Account a",Account.class);
		return query.getResultList();
	}

	@Override
	public String updateAccount(Account account) {
		// TODO Auto-generated method stub
		entityManager.merge(account);
		return "Account Updated Successfully";
		
	}

	@Override
	public String deleteAccount(long getacc) {
		// TODO Auto-generated method stub
		entityManager.remove(getAccount(getacc));
		return "Account Deleted Successfully";
		
	}

	@Override
	public String deposit(long getAcc, double depositAmount) throws AccountNotFound {
		// TODO Auto-generated method stub
		Account account = getAccount(getAcc);
		if(account==null) {
			throw new AccountNotFound("Account Not Found");
		}
		account.setBalance(account.getBalance()+depositAmount);

		//entityManager.merge(transaction);
		// entityManager.persist(account);
		return "Amount deposited Successfully";
		
	}

	@Override
	public String withdraw(long getAcc, double withdrawAmount ) throws AccountNotFound, NotEnoughBalance{
		// TODO Auto-generated method stub
		Account account = getAccount(getAcc);
		if(account==null) {
			throw new AccountNotFound("Account Not Found");
		}
		if (account.getBalance() < withdrawAmount) {
           // throw new RuntimeException("Insufficient funds");
			throw new NotEnoughBalance("Not Enough Balance");
        }
        account.setBalance(account.getBalance() - withdrawAmount);
        //entityManager.merge(transaction);
        return "Amount withdrawl Successfully ";	
		
	}

	@Override
	public String fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFound, NotEnoughBalance {
		// TODO Auto-generated method stub
		Account fromaccount = getAccount(fromAcc);
		Account toaccount = getAccount(toAcc);
		if(fromaccount==null || toaccount==null )
		{
			throw new AccountNotFound("Account Not Found");
		}
		if (fromaccount.getBalance() < amount) {
	           // throw new RuntimeException("Insufficient funds");
				throw new NotEnoughBalance("Not Enough Balance");
	        }
		
		fromaccount.setBalance(fromaccount.getBalance() - amount);
		toaccount.setBalance(toaccount.getBalance()+amount);
		  
			//entityManager.merge(transaction);
		
		return "Fund Transfer Successfully";
	}


	@Override
	public double interestEarned(long getAcc, Date todaydate) {
		// TODO Auto-generated method stub
		Account account=getAccount(getAcc);
		long days=Math.abs(todaydate.getTime()-account.getAccopendate().getTime());
		double interest = account.getBalance()*days*(0.00016);
		return interest;
	}


}
