package SkillBuilder;

public class Disk extends Circle{ //inherits values from Circle class - needs to be in same package
	private double thickness;
	
	//Overload constructor method
	public Disk(double r, double t) { //r came first - needs to be initialized first
		super(r); //super - takes value from anther class (Circle)
		thickness = t;
	}
	
	//Modifier method
	public void setThickness(double newT) {
		thickness = newT;
	}
	
	//Accessor method
	public double getThickness( ) {
		return thickness;
	}
	
	public double volume() {
		double v;
		
		v = super.area() * thickness;
		
		return v;
	}
	
	//Checks if another object equals this one
	public boolean equals(Object obj) {
		Disk testObj = (Disk)obj;
		
		if (testObj.getRadius() == super.getRadius() && testObj.getThickness() == thickness) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	//Returns value of variable(s) in class
	public String toString() {
		String diskString;
			
		diskString = "Circle Has A Radius Of " + super.getRadius() + " And A Thickness Of " + thickness + ".";
		return(diskString);
	}
		
		
	
}
