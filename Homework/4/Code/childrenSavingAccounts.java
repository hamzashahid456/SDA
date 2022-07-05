public class childrenSavingAccounts extends bankAccount {
	private float _savings;
	private float _interestRate;
	private float _fees;

	public float getSavings() {
		return this._savings;
	}

	public void setSavings(float aSavings) {
		this._savings = aSavings;
	}

	public float getInterestRate() {
		return this._interestRate;
	}

	public void setInterestRate(float aInterestRate) {
		this._interestRate = aInterestRate;
	}

	public float getFees() {
		return this._fees;
	}

	public void setFees(float aFees) {
		this._fees = aFees;
	}
}