package edu.neumont.csc150.models;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;


public class Transaction {
	private String transactionID;
	private float amount;
	private String time;

	public Transaction(float amount, String time) {
		setTransactionID(createTransactionID());
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

	public float getAmount() {
		return amount;
	}

	private void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	private void setTime(String time) {
		this.time = time;
	}

//endregion

	/**
	 * Generates a random 16 digit String in Hex format.
	 *
	 * @return {@code String} Hex ID
	 */
	private String createTransactionID() {
		Random random = new Random();
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			hexString.append(Integer.toHexString(random.nextInt(16)).toUpperCase());
		}
		return hexString.toString();
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault(Locale.Category.FORMAT));

		String string = "";
		string += "\t\tTransaction ID:\n\t\t\t" + getTransactionID();
		string += "\n\t\tAmount:\n\t\t\t" + nf.format(getAmount());
		string += "\n\t\tTransaction Time:\n\t\t\t" + getTime();

		return string;
	}
}
