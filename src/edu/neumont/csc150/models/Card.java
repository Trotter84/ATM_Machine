package edu.neumont.csc150.models;

public abstract class Card {
	private Account accountHolder;
	private String cardNum;

	public Card(Account accountHolder, String cardNum) {
		setAccountHolder(accountHolder);
		setCardNum(cardNum);
	}

	//region =========== GETTERS||SETTERS ===========
	public Account getAccountHolder() {
		return accountHolder;
	}

	private void setAccountHolder(Account accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getCardNum() {
		return cardNum;
	}

	private void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

//endregion

	@Override
	public String toString() {
		String string = "";
		string += "Name:\n\t\t\t" + accountHolder.getOwner().getFName() + ' ' + accountHolder.getOwner().getLName();
		string += "\n\t\tCard Number:\n\t\t\t" + getCardNum();

		return string;
	}
}
