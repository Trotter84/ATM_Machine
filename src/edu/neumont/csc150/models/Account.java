package edu.neumont.csc150.models;

import java.util.List;


public class Account {
	private String accountID;
	private String fName;
	private String lName;
	private Card card;
	private List<Transaction> transactions;

	public Account(String accountID, String fName, String lName) {
		setAccountID(accountID);
		setFName(fName);
		setLName(lName);
	}

//region =========== GETTERS||SETTERS ===========
//TODO: set validators

	public String getAccountID() {
		return accountID;
	}

	private void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getFName() {
		return fName;
	}

	private void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	private void setLName(String lName) {
		this.lName = lName;
	}

//endregion

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
		string += "Account ID:\n\t" + getAccountID();
		string += "\nName:\n\t" + getFName() + " " + getLName();
		string += "\nCard:\n\t" + card;
		string += "\nTransaction History:\n\t" + transactions;
		return string;
	}
}
