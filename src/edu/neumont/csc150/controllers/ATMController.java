package edu.neumont.csc150.controllers;

import edu.neumont.csc150.models.Bank;


public class ATMController {
	private Bank bank;

	public ATMController() {
		bank = new Bank();
	}

	public void run() {
		bank.createAccount();
		System.out.println(bank);
	}
}
