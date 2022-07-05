import java.util.Scanner;
import static java.lang.System.*;
class task02 {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		double saving = read.nextDouble();
		double checking = read.nextDouble();
		
		Account savingAcc = new SavingAcc(saving);
		Account checkingAcc = new CheckingAcc(checking);
		
		System.out.println(savingAcc.getIncome());
		System.out.println(checkingAcc.getIncome());
		
//		System.out.println("Enter balance in saving account: ");
//		double savAcc = read.nextDouble();
//		
//		System.out.println("Enter balance in checking account: ");
//		double checkAcc = read.nextDouble();
		
	}
}
class Account {
	private double amount;
	public Account(double amount) {
	this.amount = amount;
}
public double getAmount() {
	return amount;
}
public double getIncome() {
	return 0;
}
}
class SavingAcc extends Account {
	public SavingAcc(double amount) {
	super(amount);
}
//Override the method for saving account
public double getIncome() {
	double am = getAmount();
	return (am = am + am  * 0.2);
}
}
class CheckingAcc extends Account {
	public CheckingAcc(double amount) {
	super(amount);
}
//Override the method for checking account
public double getIncome() {
	double am = getAmount();
	return (am = am + am * 0.05);
}
}