package SkillBuilder;

public class Puck extends Disk implements Comparable{ //implements Comparable - part of comparable interface
	private double weight;
	private boolean standard, youth;
	
	public double MIN_STD_W = 5;
	public double MAX_STD_W = 5.5;
	public double MIN_YTH_W = 4;
	public double MAX_YTH_W = 4.5;
	
	//Constructor method
	public Puck (double w) {
		super(1.5, 1); //inputs parameters of Disk(double r, double t) - radius = 1.5 and thickness = 1;
		weight = w;
		
		//Could also do this in another method - better to do it in constructor
		if (weight >= MIN_STD_W && weight <= MAX_STD_W) { //Could also js put numbers(5, 5.5, etc.)
			standard = true;
			youth = false;
		}
		else {
			standard = false;
			youth = true;
		}
	}
	//Modifier method
	public void setWeight(double w) {
		weight = w;
	}
	
	//Accessor method
	public double getWeight() {
		return(weight);
	}
	
	//Accessor method
	public String getDivision() {
		String div;
		
		if(standard) {
			div = "This Puck Is Standard.";
		}
		else {
			div = "This Puck Is Youth.";
		}
		
		return(div);	//Can also return string directly - return("abc");
	}
	
	
	public boolean equals(Object obj) {
		Puck testObj = (Puck)obj;
		
		if (testObj.getDivision() == getDivision()) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	//Comparable interface - compares 2 objects
	public int compareTo(Object p) {
		Puck testPuck = (Puck)p; //object called p, type casted as a puck - p takes on puck properties
		
		if (testPuck.getWeight() < getWeight()) {
			return(-1);
		}
		else if (testPuck.getWeight() == getWeight()) {
			return(0);
		}
		else {
			return(1);
		}
	}
	
	public String toString() {
		String puckString;
		
		puckString = "This Puck Has A Weight Of " + getWeight() + " And A Division In " + getDivision() + ".";
		return(puckString);
	}	
}
