package edu.neumont.csc150.models;

public class Person {
	private String fName;
	private String lName;
	private String dob;
	private Account account;

	public Person(String fName, String lName) {
		setFName(fName);
		setLName(lName);
//		setAccount(account);
	}

//region =========== GETTERS||SETTERS ===========

	public String getFName() {
		return fName;
	}

	private void setFName(String fName) {
		if (fName == null || fName.isBlank()) {
			throw new IllegalArgumentException("First name can not be NULL or BLANK.");
		}
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	private void setLName(String lName) {
		if (lName == null || lName.isBlank()) {
			throw new IllegalArgumentException("Last name can not be NULL or BLANK.");
		}
		this.lName = lName;
	}

	public Account getAccount() {
		return account;
	}

	private void setAccount(Account account) {
		this.account = account;
	}

//endregion

}
