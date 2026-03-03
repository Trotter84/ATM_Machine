package edu.neumont.csc150.models;

import java.util.ArrayList;
import java.util.List;


public class Bank {
	private int balance;
	private Account account;
	private List<Account> accounts;

	public Bank() {
		accounts = new ArrayList<>();
	}

//region =========== GETTERS||SETTERS ===========
//TODO: set validators

	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
//		TODO: check for restraints
		this.balance = balance;
	}

//endregion

//	private String createAccountID() {
//
//	}

	public void createAccount() {
		String accountID = "123 45 6789";
		String fName = "Daniel";
		String lName = "Trotter";
		accounts.add(new Account(accountID, fName, lName));
	}

	@Override
	public String toString() {
		String string = "";
		string += "Balance: " + balance;
		string += "\nAccounts:\n\t" + accounts;

		return string;
	}
}
