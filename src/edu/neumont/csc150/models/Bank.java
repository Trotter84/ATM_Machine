package edu.neumont.csc150.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bank {
	private int balance;
	private Account account;
	private List<Account> accounts;

	//	for demo
	private String[] availableUIDs = {
			"f8 d7 cc 05", "39 38 d1 11", "ea da 27 02", "77 50 2b 15"
	};
	static int availableUIDCount = 4;

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
		if (balance < 0) {
			this.balance = 0;
		} else {
			this.balance = balance;
		}
	}

	public List<Account> getAccounts() {
		return accounts;
	}

//endregion

	/**
	 * Creates a new {@code Account} instance and assigns it to an <b>owner</b> {@code Person}.
	 *
	 * @param person
	 *
	 * @return {@code Account}
	 */
	public Account createAccount(Person owner, int initialDeposit) {

		Account account = new Account(owner, numGenerator(10), initialDeposit);
		accounts.add(account);
		owner.addAccount(account);
		return account;
	}

	/**
	 * Creates a new {@code Card} instance and assigns it to an <b>owner</b> {@code Account}.
	 *
	 * @param owner
	 *
	 * @return {@code Card}
	 */
	public Card createCard(Account owner) {

		Card card = new Card(owner, numGenerator(16));
		owner.setCard(card);
		return card;
	}

	public boolean verifyCard(Card card, Account recipient) {
		if (card.getCardNum() == recipient.getCard().getCardNum()) {
//			TODO: call card action
			return true;
		}
		return false;
	}

	/**
	 * Generates a <b>String</b> of digits. For creating a new {@code Card} or {@code Account ID}
	 *
	 * @param length {@code int} <b>inclusive</b> - how many digits will be created.
	 *
	 * @return random digit sequence as String
	 */
	private String numGenerator(int length) {
		Random random = new Random();
		StringBuilder numString = new StringBuilder();

		for (int i = 0; i < length; i++) {
			if (i % 4 == 0 && i != 0) {
				numString.append(' ');
			}
			numString.append(random.nextInt(10));
		}
		return numString.toString();
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
