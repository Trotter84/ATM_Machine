package edu.neumont.csc150.controllers;

import edu.neumont.csc150.models.Bank;
import edu.neumont.csc150.models.Person;

import java.util.Random;


public class ATMController {
	private Bank bank;
	private Person person;

	private int testLength = 6;

	public ATMController() {
		bank = new Bank();
		person = new Person("Daniel", "Trotter");
	}

	public void run() {
		bank.createAccount(person);
		System.out.println(bank);
		bank.createCard(bank.getAccounts().get(0));
		System.out.println(bank);
		shoppingSpree();
		bank.createCard(bank.getAccounts().get(0));
		System.out.println(bank);

		bank.getAccounts().get(0).getTransactions();
	}

	public void shoppingSpree() {
		Random random = new Random();
		for (int i = 0; i < testLength; i++) {
			bank.getAccounts().get(0).swipeCard(random.nextInt(10000));
		}
	}
}
