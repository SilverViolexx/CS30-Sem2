package SkillBuilder;

public class Circle {
	private static double PI = 3.14;
	private double radius;
	
	//Constructor method - default 
	public Circle() {
		radius = 1;
	}
	
	//Overriding default method
	public Circle(double r) {
		radius = r;
	}
	
	//Modifier method - does same thing as overriding method - override method may not work for multiple variables
	public void setRadius(double newR) {
		radius = newR;
	}
	
	//Accessor method
	public double getRadius() {
		return radius;
	}
	
	public double area() {
		double circleArea; //variable occurs seen in this method
		
		circleArea = PI * radius * radius;
		return(circleArea);		
	}
	
	public boolean equals (Object obj) { //object from outside this class
		Circle testObj = (Circle)obj;
		
		if (testObj.getRadius() == radius) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	//Returns value of variable(s) in class - every class needs one except for main method
	public String toString() {
		String circleString;
		
		circleString = "Circle Has A Radius of " + radius;
		return(circleString);
	}
	
}
