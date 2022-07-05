public class savingAccounts extends bankAccount {
	private float _deposits;
	private float _withdrawals;
	private int _numberOfDeposits;
	private int _numberOfWithdrawals;

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

	public int getNumberOfDeposits() {
		return this._numberOfDeposits;
	}

	public void setNumberOfDeposits(int aNumberOfDeposits) {
		this._numberOfDeposits = aNumberOfDeposits;
	}

	public int getNumberOfWithdrawals() {
		return this._numberOfWithdrawals;
	}

	public void setNumberOfWithdrawals(int aNumberOfWithdrawals) {
		this._numberOfWithdrawals = aNumberOfWithdrawals;
	}

	public float getInterestRate() {
		throw new UnsupportedOperationException();
	}

	public void setInterestRate(float aInterestRate) {
		throw new UnsupportedOperationException();
	}
}