package edu.neumont.csc150.models;

public class Card {
	private String cardNum;

	public Card(String cardNum) {
		setCardNum(cardNum);
	}

//region =========== GETTERS||SETTERS ===========
//TODO: set validators

	public String getCardNum() {
		return cardNum;
	}

	private void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

//endregion

}
