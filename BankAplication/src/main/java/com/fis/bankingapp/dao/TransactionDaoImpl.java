package com.fis.bankingapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fis.bankingapp.model.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao{
@PersistenceContext
EntityManager entityManager;

	@Override
	public List<Transaction> showTransactionData() {
		// TODO Auto-generated method stub
		TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t",Transaction.class);
		return query.getResultList();
	}

	@Override
	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		entityManager.persist(transaction);
		return "Transaction Added Successfully";
	}

	@Override
	public List<Transaction> getTransactionByAcc(long getAcc) {
		// TODO Auto-generated method stub
		TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t where t.fromaccount=?1",Transaction.class);
		query.setParameter(1, getAcc);
		return query.getResultList();
	}

}
