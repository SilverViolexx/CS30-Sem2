package SkillBuilder;

public class Rectangle implements Comparable{
	private double length, width;
	
	//Constructor method
	public Rectangle() {
		length = 2; //Default length
		width = 4; //Default width
	}
	
	//Overloading constructor method
	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	
	//Access method
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	//Modifier method
	public void setLW(double l, double w) {
		length = l;
		width = w;
	}
	
	//Area calculation
	public double area() {
		return (getLength() * getWidth());
	}
	
	//Perimeter calculation
	public double perimeter() {
		return ((2 * getLength()) + (2 * getWidth()));
		}

	//Area formula
	public static void displayAreaFormula() {
		System.out.println("The formula for the area of a rectangle is a = (2 * length) + (2 * width).");
	}
	
	//Compares if 2 rectangles are equal
	public int compareTo(Object rect) {
		Rectangle same = (Rectangle) rect;
		
		if (same.getLength() < getLength() && same.getWidth() < getWidth()) {
			return(-1);
		}
		else if (same.getLength() == getLength() & same.getWidth() == getWidth()) {
			return(0);
		}
		else {
			return(1);
		}
	}
	
	public int compareToArea(Object rect) {
		Rectangle testR = (Rectangle)rect;
		
		double a1 = testR.getLength() * testR.getWidth();
		double a2 = getLength() * getWidth();
		
		if (a1 < a2) {
			return(-1);
		}
		else if (a1 == a2) {
			return(0);
		}
		else {
			return(1);
		}
	}
	
	//Returns a string that represents the rectangle
	public String toString() {
		String retangleString;
			
		retangleString = "The second rectangle has a length of " + getLength() + " and a width of " + getWidth() + ".";
		return (retangleString);
	}
	
}