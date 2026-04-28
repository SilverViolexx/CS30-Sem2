package Mastery;

import java.text.NumberFormat;

public class UEmployee {
	private String fName, lName;
	private double salary;
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	//Constructor method - default
	public UEmployee() {
		fName = "default last name";
		lName = "default first name";
		salary = 0;
	}
	
	//Overloading method
	public UEmployee(String f, String l,  double s) {
		fName = f;
		lName = l;
		salary = s;
	}
	
	//Modifier method
	public void setFName(String f) {
		fName = f;
	}
	public void setLName(String l) {
		fName = l;
	}
	public void setSalary(double s) {
		salary = s;
	}
	
	//Access method
	public String getFName() {
		return(fName);
	}
	public String getLName() {
		return(lName);
	}
	public double getSalary() {
		return(salary);
	}
	
	//Return employee information
	public String toString() {
		return("Empolyee Name: " + fName + " " + lName + "\n"
				+ "Salary Amount: " + money.format(salary));
	}
	
}
