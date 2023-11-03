package com.fis.bankingapp.service;

import java.util.List;

import com.fis.bankingapp.model.Transaction;

public interface TransactionService {
	public List<Transaction> showTransactionData();
	public String addTransaction(Transaction transaction);
	public List<Transaction> getTransactionByAcc(long getAcc);

}
