package edu.neumont.csc150.models;

public class DebitCard extends Card implements Refillable {
	public DebitCard(Account accountHolder, String cardNum) {
		super(accountHolder, cardNum);
	}

	@Override
	public boolean deposit() {
		return false;
	}
}
