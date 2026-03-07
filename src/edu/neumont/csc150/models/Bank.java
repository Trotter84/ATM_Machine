package edu.neumont.csc150.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bank {
	private int balance;
	private Account account;
	private List<Account> accounts;

	public Bank() {
		setBalance(20580000);
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

	public List<Account> getAccounts() {
		return accounts;
	}

//endregion

	public Account createAccount(Person person) {
		String accountID = "123 45 6789";

		Account account = new Account(accountID, person);
		accounts.add(account);
		return account;
	}

	public Card createCard(Account owner) {
		Random random = new Random();
		StringBuilder cardNum = new StringBuilder();

		for (int i = 0; i < 16; i++) {
			if (i % 4 == 0 && i != 0) {
				cardNum.append(' ');
			}
			cardNum.append(random.nextInt(10));
		}

		Card card = new Card(owner, cardNum.toString());
		owner.setCard(card);
		return card;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###,###");

		String string = "";
		string += "Balance:\n\t$" + df.format(getBalance());
		for (Account account : getAccounts()) {
			string += "\n\nAccounts:\n\t" + account;
		}

		return string;
	}
}
