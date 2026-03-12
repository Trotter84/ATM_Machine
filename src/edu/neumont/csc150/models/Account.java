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
	private List<Receipt> receipts;

	public Account(Person owner, String accountID, int balance) {
		receipts = new ArrayList<>();

		setOwner(owner);
		setAccountID(accountID);
		setBalance(balance);
	}

//region =========== GETTERS||SETTERS ===========

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

	private void setOwner(Person owner) {
		if (owner != null) {
			this.owner = owner;
		}
	}

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

	public Card getCard() {
		return card;
	}

	protected void setCard(Card card) {
		if (this.card == null) {
			this.card = card;
		}
	}

	public List<Receipt> getTransactions() {
		return receipts;
	}

	private void setTransactions(List<Receipt> receipts) {
		this.receipts = receipts;
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

	public boolean chargeAccount(int amount) {
		boolean status = withdraw(amount);
		if (status) {
			Receipt receipt = new Receipt(amount, createTimestamp());
			receipts.add(receipt);
		}
		return status;
	}

	private boolean deposit(int amount) {
		if (amount > 0) {
			setBalance(getBalance() + amount);
			Receipt receipt = new Receipt(amount, createTimestamp());
			receipts.add(receipt);
			return true;
		} else {
			return false;
		}
	}

	private boolean withdraw(int amount) {
		if (amount > 0 && amount <= getBalance()) {
			setBalance(getBalance() - amount);
			return true;
		} else return false;
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
		for (Receipt receipt : getTransactions()) {
			string += "\n\n\tTransaction History:\n" + receipt;
		}
		return string;
	}
}
