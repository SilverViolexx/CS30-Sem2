package CrestMart;

public class Associate extends Employee{
	private double hourlyPay;
	
	public Associate() {
		hourlyPay = 0;
	}
	
	public Associate(String fn, String ln, double h) {
		super(fn, ln);
		hourlyPay = h;
	}
	
	double pay(double hours) {
		double payEarned;
		
		if (hours > 40) {
			payEarned = (hourlyPay * 40) + (hourlyPay * 1.5) * (hours - 40);
		}
		else {
			payEarned = hourlyPay * hours;
		}
		
		return payEarned;
	}
	
	public String toString() {
		return(super.toString() + " " + "Associate Pay Rate: " + hourlyPay);
	}
}
