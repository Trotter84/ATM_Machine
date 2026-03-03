package edu.neumont.csc150.models;

public class Transaction {
	private String transactionID;
	private int amount;
	private String time;

	public Transaction(String transactionID, int amount, String time) {
		setTransactionID(transactionID);
		setAmount(amount);
		setTime(time);
	}

//region =========== GETTERS||SETTERS ===========
//TODO: set validators

	public String getTransactionID() {
		return transactionID;
	}

	private void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public int getAmount() {
		return amount;
	}

	private void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	private void setTime(String time) {
		this.time = time;
	}

//endregion

}
