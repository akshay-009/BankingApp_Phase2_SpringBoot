package com.fis.bankingapp.exceptions;

public class AccountNotFound extends Exception
{
	private static final long serialVersionUID = 1L;

	public AccountNotFound(String message) {
		super(message);
	}

}
