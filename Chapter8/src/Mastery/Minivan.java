package Mastery;

public class Minivan extends Vehicle{
	private String slideDoor;
	private String model, colour;
	
	//Constructor
	public Minivan() {
		slideDoor = "none";
	}
		
	//Overloading method
	public Minivan(int seat, double cargo, double ctyFuel, double hwyFuel, String md, String c, String s) {
		super(seat, cargo, ctyFuel, hwyFuel);		
		model = md;
		colour = c;
		slideDoor = s;
	}
		
	//Modifier method
	public void setDoor(String s) {
		slideDoor = s;
	}
	public void setModel(String md) {
		model = md;
	}
	public void setColour(String c) {
		colour = c;
	}	
		
	//Access method
	public String getDoor() {
		return(slideDoor);
	}
	public String getModel() {
		return(model);
	}
		public String getColour() {
		return(colour);
	}

	public String toString() {
		return("Make & Model: " + model + "\n" 				
				+ "Colour: " + colour + "\n"
				+ super.toString() + "\n"
			+ "Sliding Door(yes/no): " + slideDoor);
	}

	//Abstract method
	String vehicleType() {
		return("Minivan");
	}
	String vehicleModel() {
		return(model);
	}
	String vehicleColour() {
		return(colour);
	}
		
	
}
