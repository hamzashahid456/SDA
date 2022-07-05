public class healthSavingAccounts extends bankAccount {
	private float _deposits;
	private float _withdrawals;

	public float getDeposits() {
		return this._deposits;
	}

	public void setDeposits(float aDeposits) {
		this._deposits = aDeposits;
	}

	public float getWithdrawals() {
		return this._withdrawals;
	}

	public void setWithdrawals(float aWithdrawals) {
		this._withdrawals = aWithdrawals;
	}
}