package com.fis.bankingapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankingapp.exceptions.AccountNotFound;
import com.fis.bankingapp.exceptions.NotEnoughBalance;
import com.fis.bankingapp.model.Account;
import com.fis.bankingapp.model.Transaction;
import com.fis.bankingapp.service.AccountService;
import com.fis.bankingapp.service.TransactionService;

//{
//    "accopendate": "2023-11-02",
//    "accounttype": "Savings",
//    "balance": 0,
//    "branch": "Hyd"
//}
@RestController
@RequestMapping("/accounts") // http://localhost:8080/accounts
public class AccountController {
	@Autowired
	AccountService service;
	
	@Autowired
	TransactionService transservice;
	Date today=new Date();
	String transstatus=null;
	
	@PostMapping("/createAccount") // http://localhost:8080/accounts/createAccount
	public String createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}
	
	@GetMapping("/getAccount/{acc}") // http://localhost:8080/accounts/getAccount
	public Account getAccount(@PathVariable("acc") long getAcc) {
		return service.getAccount(getAcc);
	}
	
	@GetMapping("/getAllAccounts") // http://localhost:8080/accounts/getAllAccounts
	public List<Account> getAllAccounts(){
		return service.getAllAccounts();
		
	}
	
	@PutMapping("/updateAccount") // http://localhost:8080/accounts/updateAccount
	public String updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}
	
	@DeleteMapping("/deleteAccount/{acc}") // http://localhost:8080/accounts/deleteAccount/3
	public String deleteAccount(@PathVariable("acc") long getacc) {
		return service.deleteAccount(getacc);
	}
	
	@PostMapping("/deposit/{acc}") //http://localhost:8080/accounts/deposit/3
	public String deposit(@PathVariable("acc") long getAcc, @RequestBody Map<String, Double> request ) {
		Double depositAmount = request.get("depositAmount");
		
		Transaction transaction= new Transaction();
		
		try {
			transstatus = "SUCCESS";
			return service.deposit(getAcc, depositAmount);
		}catch(AccountNotFound anf) {
			transstatus= "FAILED";
			return anf.getMessage();
		}
		finally {
			transaction.setAmount(depositAmount);
			transaction.setFromaccount(getAcc);
			transaction.setTranstime(today);
			transaction.setTranstype("Deposit");
			transaction.setStatus(transstatus);
			transservice.addTransaction(transaction);
		}
		
		
		
	}
	
	@PostMapping("/withdraw/{acc}") // http://localhost:8080/accounts/withdraw/4
	public String withdraw(@PathVariable("acc") long getAcc, @RequestBody Map<String, Double> request ) {
		Double withdrawAmount = request.get("withdrawAmount");
		try {
			 transstatus = "SUCCESS";
			return service.withdraw(getAcc, withdrawAmount);
		}catch(AccountNotFound anf){
			transstatus= "FAILED";
			return anf.getMessage();
		}
		catch(NotEnoughBalance nef) {
			transstatus= "FAILED";
			return nef.getMessage();
		}
		finally {
			Transaction transaction= new Transaction();
			transaction.setAmount(withdrawAmount);
			transaction.setFromaccount(getAcc);
			transaction.setTranstime(today);
			
			transaction.setTranstype("Withdraw");
			transaction.setStatus(transstatus);
			transservice.addTransaction(transaction);
		}
		
		
		
	}
	
	@PostMapping("fundTransfer/{fromAcc}/{toAcc}") // http://localhost:8080/accounts/3/4
	public String fundTransfer(@PathVariable long fromAcc, @PathVariable long toAcc,@RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		try {
			transstatus= "SUCCESS";
			return service.fundTransfer(fromAcc, toAcc, amount);
		}catch(AccountNotFound anf){
			transstatus= "FAILED";
			return anf.getMessage();
		}
		catch(NotEnoughBalance nef) {
			transstatus= "FAILED";
			return nef.getMessage();
		}
		finally {
			Transaction transaction= new Transaction();
			transaction.setAmount(amount);
			transaction.setFromaccount(fromAcc);
			transaction.setToaccount(toAcc);
			transaction.setTranstime(today);
			transaction.setTranstype("Fund Transfer");
			transaction.setStatus(transstatus);
			transservice.addTransaction(transaction);
		}
		
//		@PostMapping("/interestEarned/{getAcc}/{todaydate}")
//		public Double interestEarned( @PathVariable long getAcc, @PathVariable Date todaydate) {
//			return service.interestEarned(getAcc, todaydate);
//		}
//		
		
	}


}
