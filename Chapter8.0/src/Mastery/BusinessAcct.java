package Mastery;

import java.text.NumberFormat;

public class BusinessAcct extends Account{
	int MIN_BALANCE = 500;
	int FEE = 10;
	
	//Overloading method
	public BusinessAcct(double amt, String fName, String lName, String str, String c, String prov, String postal) {
		super(amt, fName, lName, str, c, prov, postal);
	}
	
	public String BusinessMinFee() {
		NumberFormat money = NumberFormat.getCurrencyInstance();
		double amt = getBalance();
		
		if (amt < MIN_BALANCE) {
			super.withdrawal(FEE);
			amt = getBalance();
			return ("Minimum Of " + money.format(MIN_BALANCE) + " Required In Account. " + money.format(FEE) + " Withdrawal Fee Applied." + "\n"
					+ "New Balance: " + money.format(amt));
		}
		else {
			return("The Required Minimum Of " + money.format(MIN_BALANCE) + " Is Met. No Fee Applied." + "\n"
					+ "New Balance: " + money.format(amt));
		}
	}
	
	//Abstract method
	String acctType() {
		return("Business");
	}
	
	public String toStringBA() {
		return(toString());
	}
}
