package SkillBuilder;

public class Hockey {
	
	public static void main (String[] args) {
		
		//Puck(...) - overloading method
		Puck stdPuck = new Puck(4.0); //weight = 4
		Puck ythPuck = new Puck(5.5);
		
		Circle testC = new Circle(3.0);
		Circle testC2 = new Circle(2.2);
		
		System.out.println("The Puck Has A Radius Of " + stdPuck.getRadius() + "." + "\n"
				+ "The Puck Has A Weight Of " + stdPuck.getWeight() + "\n"
				+ stdPuck.getDivision());
		
		System.out.println("The Puck Has A Radius Of " + ythPuck.getRadius() + "." + "\n"
				+ "The Puck Has A Weight Of " + ythPuck.getWeight() + "\n"
				+ ythPuck.getDivision());
		
		System.out.println(testC.toString());
		System.out.println(testC2.toString());
		
	}

}
