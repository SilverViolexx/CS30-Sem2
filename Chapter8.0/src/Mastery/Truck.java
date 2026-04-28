package Mastery;

public class Truck extends Vehicle{
	private double towingCap;
	private String model, colour;

	//Constructor
	public Truck() {
		towingCap = 0;
		model = "none";
		colour = "blank";
	}
		
	//Overloading method
	public Truck(int seat, double cargo, double ctyFuel, double hwyFuel, String md, String c, double t) {
		super(seat, cargo, ctyFuel, hwyFuel);		
		model = md;
		colour = c;
		towingCap = t;
	}
		
	//Modifier method
	public void setModel(String md) {
		model = md;
	}
	public void setColour(String c) {
		colour = c;
	}	
	public void setTow(double t) {
		towingCap = t;
	}
		
	//Access method
	public String getModel() {
		return(model);
	}
		public String getColour() {
		return(colour);
	}
	public double getTow() {
		return(towingCap);
	}

	public String toString() {
		return("Make & Model: " + model + "\n" 				
				+ "Colour: " + colour + "\n"
				+ super.toString() + "\n"
				+ "Towing Capacity(kg): " + towingCap);
	}

	//Abstract method
	String vehicleType() {
		return("Truck");
	}
	String vehicleModel() {
		return(model);
	}
	String vehicleColour() {
		return(colour);
	}
	
}
