package com.fis.bankingapp.dao;

import java.util.List;
import com.fis.bankingapp.model.Transaction;

public interface TransactionDao {
	// This is the interface in dao layer for transactions
	
	public List<Transaction> showTransactionData();
	public String addTransaction(Transaction transaction);
	public List<Transaction> getTransactionByAcc(long getAcc);

}
