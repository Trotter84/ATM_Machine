package edu.neumont.csc150.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;


public class Account {
	private String accountID;
	private Person owner;
	private int balance;
	private Card card;
	private List<Transaction> transactions;

	public Account(Person owner, String accountID, int balance) {
		transactions = new ArrayList<>();

		setOwner(owner);
		setAccountID(accountID);
		setBalance(balance);
	}

//region =========== GETTERS||SETTERS ===========
//TODO: set validators

	public String getAccountID() {
		return accountID;
	}

	private void setAccountID(String accountID) {
		if (owner.getFName().equalsIgnoreCase("Dev")) {
			this.accountID = "f8 d7 cc 05";
		} else {
			this.accountID = accountID;
		}
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Card getCard() {
		return card;
	}

	//	TODO: Get Card set to owner
	protected void setCard(Card card) {
		if (this.card == null) {
			this.card = card;
		}
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	private void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	//endregion

	/**
	 * Captures the date and time at the time of being called.
	 *
	 * @return {@code String} <b>date</b> and <b>time</b> formatted as m/d/yy, h:mm
	 */
	protected String createTimestamp() {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		DateTimeFormatter customFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		String timestamp = localDateTime.format(customFormatter);

		return timestamp;
	}

	public void swipeCard(int amount) {
		setBalance(getBalance() - amount);
		Transaction transaction = new Transaction(amount, createTimestamp());
		transactions.add(transaction);
	}

	private boolean deposit() {
//		if success
		return true;
//		if fail
//		return false;
	}

	private boolean withdraw() {
//		if success
		return true;
//		if fail
//		return false;
	}

	@Override
	public String toString() {
		String string = "";
		string += "\n\tAccount ID:\n\t\t" + getAccountID();
		string += "\n\tName:\n\t\t" + owner.getFName() + ' ' + owner.getLName();
		string += "\n\tBalance:\n\t\t$" + getBalance();
		if (getCard() != null) {
			string += "\n\tCard:\n\t\t" + getCard();
		}
		for (Transaction transaction : getTransactions()) {
			string += "\n\n\tTransaction History:\n" + transaction;
		}
		return string;
	}
}
