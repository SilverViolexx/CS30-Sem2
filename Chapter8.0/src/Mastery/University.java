/*
Program: University.java          Last Date of this Revision: April 9, 2026

Purpose: Create a UEmployee class that contains member variables for the university employee name and salary. 
The UEmployee class should contain member methods for returning the employee name and salary.
Create Faculty and Staff classes that inherit the UEmployee class. The Faculty class should include 
members for storing and returning the department name. The Staff class should include members for 
storing and returning the job title.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/
package Mastery;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class University {

	public static void main (String[] args) {
		//Initialize variables
		String action;
		Scanner input = new Scanner(System.in);
		ArrayList<UEmployee> list = new ArrayList<>();
		String prompt = "(C)ontinue Assigning || (V)iew Employees || (E)nd Program: ";
		
		//Continues looping code until "e" is entered
		do {
			list.add(assignE());
			
			System.out.print("\n" + prompt);
			action = input.next();
		
			//Checks if user wants to view employees
			if (action.equalsIgnoreCase("v") ) {
				//Displays information of each object in arraylist
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i)); 
				}
	
				System.out.print("\n" + prompt);
				action = input.next(); 
			}
			while (!action.equalsIgnoreCase("v") && !action.equalsIgnoreCase("c") && !action.equalsIgnoreCase("e")) {
				System.out.print("Invalid option." + "\n" + prompt);
				action = input.next();
			}
		} while (!action.equalsIgnoreCase("e"));			
	}
	
	public static UEmployee assignE() {
		//Initialize variables
		String fName, lName, title, dep, choice;
		double salary;	
		String prompt = "Is The Employee A (S)taff or (F)aculty: ";
		Scanner input = new Scanner(System.in);
		
		//Prompt user to input data
		System.out.print("Employee First Name: ");
		fName = input.next();
		System.out.print("Employee Last Name: ");
		lName = input.next();
		System.out.print("Employee Salary($): ");
		salary = Double.parseDouble(input.next());
		
		System.out.print(prompt);
		choice = input.next();
		
		//Loops until user enters valid input
		while(!choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("f")) {
			System.out.println("Invalid option.");

			System.out.print(prompt);
			choice = input.next();
		}
		
		//Checks if employee is staff or faculty
		if (choice.equals("s")) {
			System.out.print("Employee Job Title: ");
			title = input.next();
				
			//Returns object with data inputted
			return (new Staff(fName, lName, salary, title));
		}
		else if(choice.equals("f")) {
			System.out.print("Employee Department: ");
			dep = input.next();			
				
			//Returns object with data inputted
			return (new Faculty(fName, lName, salary, dep));
		}
		else {
			return null;
		}
	}	
}

/*
Employee First Name: Amanda
Employee Last Name: Ly
Employee Salary: 42000
Is The Employee A (S)taff or (F)aculty: s
Employee Job Title: cashier

(C)ontinue Assigning || (V)iew Employees || (E)nd Program: c
Employee First Name: John
Employee Last Name: Smith
Employee Salary: 45000
Is The Employee A (S)taff or (F)aculty: k
Invalid option.
Is The Employee A (S)taff or (F)aculty: f
Employee Department: R&D

(C)ontinue Assigning || (V)iew Employees || (E)nd Program: v
Empolyee Name: Amanda Ly
Salary Amount: $42,000.00
Job Title: cashier

Empolyee Name: John Smith
Salary Amount: $45,000.00
Department: R&D


(C)ontinue Assigning || (V)iew Employees || (E)nd Program: j
Invalid option.
(C)ontinue Assigning || (V)iew Employees || (E)nd Program: e

*/
