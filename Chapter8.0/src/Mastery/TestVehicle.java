/*
Program: TestVehicle.java          Last Date of this Revision: April 20, 2026

Create a Vehicle class that is an abstract class defining the general details and actions associated with 
a vehicle. Create Car, Truck, and Minivan classes that inherit the Vehicle class. The Car, Truck, and 
Minivan classes should include additional members specific to the type of vehicle being represented. 
Create client code to test the classes.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30

*/
package Mastery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestVehicle {

	public static void main (String[] args) {
		//Initialize variables
		String action, view;
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> carList = new ArrayList<>();
		ArrayList<Vehicle> truckList = new ArrayList<>();
		ArrayList<Vehicle> vanList = new ArrayList<>();
		String[] actionList = {"a", "v", "q"};
		String prompt = "(A)dd Vehicle || (V)iew Catalogue || (Q)uit";		
		
		//Display program name
		System.out.println("VEHICLE CATALOGUE");
		
		//Loops until "q" is entered
		do {
			//Display prompt
			System.out.println("\n" + prompt);
			action = input.nextLine();	
			action = action.toLowerCase();
			
			//Keeps prompting user until valid input is entered
			while (!Arrays.asList(actionList).contains(action)) {
				System.out.println("Invalid option.");
				System.out.println("\n" + prompt);
				action = input.nextLine();
				action = action.toLowerCase();
			}	
		
			//Checks type of vehicle & adds object to according list
			if (action.equals("a")) {
				Vehicle obj = assignV();

				if (obj.vehicleType().equals("Car")) {
					carList.add(obj);
				}
				else if (obj.vehicleType().equals("Truck")) {
					truckList.add(obj);
				}
				else if (obj.vehicleType().equals("Minivan")) {
					vanList.add(obj);
				}
			}
			
			//Views list of objects
			else if (action.equals("v") ) {
				System.out.println("View: (C)ars || (T)rucks || (M)inivan");
				view = input.nextLine();
				view = view.toLowerCase();
				
				//Displays information of each object in arraylist for cars
				if (view.equals("c")) {	
					//Will display if list is empty
					if(carList.isEmpty()) {
						System.out.println("Car Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < carList.size(); i++) {							
							System.out.println(carList.get(i) + "\n"); 
						}					
					}
					
				}
				//Displays information of each object in arraylist for trucks
				else if (view.equals("t")) {			
					//Will display if list is empty
					if(truckList.isEmpty()) {
						System.out.println("Truck Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < truckList.size(); i++) {
							System.out.println(truckList.get(i) + "\n"); 						
						}						
					}
				}
				//Displays information of each object in arraylist for minvans
				else if (view.equals("m")) {	
					//Will display if list is empty
					if(vanList.isEmpty()) {
						System.out.println("Minivan Catalogue Is Empty");
					}
					else {
						for (int i = 0; i < vanList.size(); i++) {
							System.out.println(vanList.get(i) + "\n"); 
						}						
					}
				}
				//Will display if user inputs value not listed above
				else {
					System.out.println("Invalid option.");
				}
			}
		} while (!action.equalsIgnoreCase("q"));		
	}
	
	
	//Method that returns an object
	public static Vehicle assignV() {	
		//Initialize variables
		String type, make, colour, transmission, door;
		int seatNum;
		double cargoV, ctyEcon, hwyEcon, towCap;
		String[] typeList = {"c", "t", "m"};
		Scanner input = new Scanner(System.in);	
		String typePrompt = "Type Of Vehicle: (C)ar || (T)ruck || (M)inivan";
			
		//Prompt user to input information
		System.out.print("Make & Model Of Vehicle: ");
		make = input.nextLine();
		
		System.out.print("Colour Of Vehicle: ");
		colour = input.nextLine();
		
		System.out.print("Seat Capacity: ");
		seatNum = input.nextInt();
		input.nextLine();
		
		System.out.print("Cargo Volume(m²): ");
		cargoV = input.nextDouble();
		input.nextLine();
		
		System.out.print("City Fuel Economy(km/L): ");
		ctyEcon = input.nextDouble();
		input.nextLine();
		
		System.out.print("Highway Fuel Economy(km/L): ");
		hwyEcon = input.nextDouble();
		input.nextLine();		
		
		System.out.println(typePrompt);
		type = input.nextLine();
		type = type.toLowerCase();
		
		//Keeps prompting user until valid value is entered
		while(!Arrays.asList(typeList).contains(type)) {
			System.out.println("Invalid option.");

			System.out.println(typePrompt);
			type = input.nextLine();
			type = type.toLowerCase();
		}
		
		//Returns car object
		if (type.equals("c")) {		
			System.out.print("Transmission Type(Auto/Manual): ");
			transmission = input.nextLine();
			//Returns object with data inputted
			return (new Car(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, transmission));
		}
		//Returns truck object
		else if (type.equals("t")) {		
			System.out.print("Towing Capacity(kg): ");
			towCap = input.nextDouble();
			input.nextLine();		
			//Returns object with data inputted
			return (new Truck(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, towCap));
		}
		//Returns minivan object
		else if (type.equals("m")) {		
			System.out.print("Sliding Door(yes/no): ");
			door = input.next();
			//Returns object with data inputted
			return (new Minivan(seatNum, cargoV, ctyEcon, hwyEcon, make, colour, door));
		}		
		return null;		
	}	
}

/*
VEHICLE CATALOGUE

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
a
Make & Model Of Vehicle: Toyota
Colour Of Vehicle: Red
Seat Capacity: 4
Cargo Volume(m²): 0.8
City Fuel Economy(km/L): 9.2
Highway Fuel Economy(km/L): 8.7
Type Of Vehicle: (C)ar || (T)ruck || (M)inivan
c
Transmission Type(Auto/Manual): auto

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
a
Make & Model Of Vehicle: Honda
Colour Of Vehicle: Grey
Seat Capacity: 5
Cargo Volume(m²): 0.9
City Fuel Economy(km/L): 9.4
Highway Fuel Economy(km/L): 8.5
Type Of Vehicle: (C)ar || (T)ruck || (M)inivan
C
Transmission Type(Auto/Manual): Manual

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
v
View: (C)ars || (T)rucks || (M)inivan
c
Make & Model: Toyota
Colour: Red
Seat Capacity: 4
Cargo Volume(m²): 0.8
City Fuel Economy(km/L): 9.2
Highway Fuel Economy(km/L): 8.7
Transmission Type: auto

Make & Model: Honda
Colour: Grey
Seat Capacity: 5
Cargo Volume(m²): 0.9
City Fuel Economy(km/L): 9.4
Highway Fuel Economy(km/L): 8.5
Transmission Type: Manual


(A)dd Vehicle || (V)iew Catalogue || (Q)uit
a
Make & Model Of Vehicle: Ford
Colour Of Vehicle: Black
Seat Capacity: 2
Cargo Volume(m²): 11.3
City Fuel Economy(km/L): 12.6
Highway Fuel Economy(km/L): 11.4
Type Of Vehicle: (C)ar || (T)ruck || (M)inivan
t
Towing Capacity(kg): 2500

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
a
Make & Model Of Vehicle: Ram
Colour Of Vehicle: Blue
Seat Capacity: 2
Cargo Volume(m²): 13.1
City Fuel Economy(km/L): 13.2
Highway Fuel Economy(km/L): 12.7
Type Of Vehicle: (C)ar || (T)ruck || (M)inivan
t
Towing Capacity(kg): 3000

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
v
View: (C)ars || (T)rucks || (M)inivan
t
Make & Model: Ford
Colour: Black
Seat Capacity: 2
Cargo Volume(m²): 11.3
City Fuel Economy(km/L): 12.6
Highway Fuel Economy(km/L): 11.4
Towing Capacity(kg): 2500.0

Make & Model: Ram
Colour: Blue
Seat Capacity: 2
Cargo Volume(m²): 13.1
City Fuel Economy(km/L): 13.2
Highway Fuel Economy(km/L): 12.7
Towing Capacity(kg): 3000.0


(A)dd Vehicle || (V)iew Catalogue || (Q)uit
v
View: (C)ars || (T)rucks || (M)inivan
m
Minivan Catalogue Is Empty

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
h
Invalid option.

(A)dd Vehicle || (V)iew Catalogue || (Q)uit
q

*/
