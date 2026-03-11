package edu.neumont.csc150.models;


public class Person {
	private String fName;
	private String lName;
	private int age;
	private Account account;

	public Person(String fName, String lName, int age) {
		setFName(fName);
		setLName(lName);
		setAge(age);
		setAccount(account);
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

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public Account getAccount() {
		return account;
	}

	private void setAccount(Account account) {
		this.account = account;
	}

//endregion

	protected void addAccount(Account account) {
		setAccount(account);
	}

	@Override
	public String toString() {
		return getFName() + ' ' + getLName();
	}
}
