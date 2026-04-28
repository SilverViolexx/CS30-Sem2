package Mastery;

import java.text.NumberFormat;

public class PersonalAcct extends Account{
	int MIN_BALANCE = 100;
	int FEE = 2;	
	
	//Overloading method
	public PersonalAcct(double amt, String fName, String lName, String str, String c, String prov, String postal) {
		super(amt, fName, lName, str, c, prov, postal);
	}
	
	public PersonalAcct(String ID) {
        super(ID);
    }
	
	public String PersonalMinFee() {
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
		return("Personal");
	}
	
	public String toStringPA() {
		return(toString());
	}
}