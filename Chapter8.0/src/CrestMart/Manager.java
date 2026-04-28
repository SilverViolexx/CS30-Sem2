package CrestMart;

public class Manager extends Employee{
	private double yearlySalary;
	
	//Constructor
	public Manager(String f, String l, double y) {
		super(f, l);
		yearlySalary = y;
	}
	
	public String getFN() {
		return(super.getFN());
	}
	
	@Override
	double pay(double weeks) {
		double payEarned;
		
		payEarned = weeks * 5;
		return(payEarned); //brackets around returned - preference, can do w/o
	}
	
}
