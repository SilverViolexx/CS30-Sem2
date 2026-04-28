package CrestMart;

public abstract class Employee {
	private String fName, lName;
	
	//Constructor
	public Employee() {
		fName = "No first name";
		lName = "No last name";
	}
	
	public Employee(String f, String l) {
		fName = f;
		lName = l;
	}
	
	public String getFN() {
		return(fName);
	}
	public String getLN() {
		return(lName);
	}
	
	public String toString() {
		return(fName + " " + lName);
	}
	
	abstract double pay(double period);
}
