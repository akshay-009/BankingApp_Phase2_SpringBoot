package com.fis.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankingapp.dao.TransactionDao;
import com.fis.bankingapp.model.Transaction;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionDao dao;
	
	@Override
	public List<Transaction> showTransactionData() {
		// TODO Auto-generated method stub
		return dao.showTransactionData();
	}

	@Override
	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return dao.addTransaction(transaction);
		
	}

	@Override
	public List<Transaction> getTransactionByAcc(long getAcc) {
		// TODO Auto-generated method stub
		return dao.getTransactionByAcc(getAcc);
	}

}
