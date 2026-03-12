package edu.neumont.csc150.models;

public class CreditCard extends Card implements Refillable {
	private float interestRate;

	public CreditCard(Account accountHolder, String cardNum, float interestRate) {
		super(accountHolder, cardNum);
		setInterestRate(interestRate);
	}

	public float getInterestRate() {
		return interestRate;
	}

	private void setInterestRate(float interestRate) {
		if (interestRate < 0) {
			this.interestRate = 0;
		} else {
			this.interestRate = interestRate;
		}
	}

	@Override
	public boolean deposit() {
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\nInterest Rate: \n\t\t\t" + getInterestRate() + '%';
	}

}
