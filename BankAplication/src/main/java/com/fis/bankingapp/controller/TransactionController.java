package com.fis.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankingapp.model.Transaction;
import com.fis.bankingapp.service.TransactionService;

@RestController
@RequestMapping("/Transactions") // http://localhost:8080/Transactions
public class TransactionController {
	@Autowired
	TransactionService service;
	
	@GetMapping("/showTransactions") // http://localhost:8080/Transactions/showTransactions
	public List<Transaction> showTransactionData(){
		return service.showTransactionData();
	}
	
	@PostMapping("/addTransaction") 
	public String addTransaction(Transaction transaction) {
		return service.addTransaction(transaction);
	}
	
	@GetMapping("/getTransactionByAcc/{acc}") // http://localhost:8080/Transactions/getTransactions/4
	public List<Transaction> getTransactionByAcc(@PathVariable("acc") long getAcc) {
		return service.getTransactionByAcc(getAcc);
	}


}
