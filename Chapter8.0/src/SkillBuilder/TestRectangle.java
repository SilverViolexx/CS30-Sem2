package SkillBuilder;

import java.text.DecimalFormat;

public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#0.00");
		
		Rectangle rect = new Rectangle();
		rect.setLW(3,7);
		Rectangle rect2 = new Rectangle(3,6);
		
		System.out.println("Rectangle perimeter: " + rect.perimeter());
		System.out.println("Rectangle area: " + rect.area());
		Rectangle.displayAreaFormula();
		
		if (rect.compareTo(rect2) == 0) {
			System.out.println("The rectangles are equal.");
		}
		else {
			System.out.println("The rectangles are not equal.");
		}
		
		if(rect2.compareToArea(rect) == 0) {
			System.out.println("The rectangles have the same area.");
		}
		else if(rect2.compareToArea(rect) == -1) {
			System.out.println("Rectangle 1 has a smaller area than rectangle 2.");
		}
		else {
			System.out.println("Rectangle 2 has a smaller area than rectangle 1.");
		}
		
		System.out.println(rect2.toString());
	}

}