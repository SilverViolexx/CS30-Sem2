package CrestMart;

import java.text.NumberFormat;
import java.util.Scanner;

public class CrestMart {

	public static void payEmployee(Employee emp, double payTime) {
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
		double pay;
		
		System.out.println(emp); //System.out.print(object) will automatically print toString();
		
		pay = emp.pay(payTime);
		
		System.out.println(money.format(pay));
	}
	
	public static void main (String[] args) {
		Manager emp1 = new Manager("Alex", "Smith", 50000);
		Associate emp2 = new Associate("Samantha", "Jackson", 18);
		
		Scanner input = new Scanner(System.in);
		
		String action;
		int empNum;
		double payTime;
		
		
			
		do {
			Employee emp = emp1;
			System.out.println("(E)mployee || (M)anager || (Q)uit");
			action = input.next();
			
			if(!action.equalsIgnoreCase("Q")) {
				System.out.println("Enter Employee Number(1 or 2): ");
				empNum = input.nextInt();
				
				switch (empNum) {
					case 1: emp = emp1; break;
					case 2: emp = emp2; break;
				}
				if(!action.equalsIgnoreCase("E")) {
				System.out.println(emp);
				}
				else if(!action.equalsIgnoreCase("P")) {
					System.out.println("Enter The Hours For Associate "
							+ "OR Pay Period For Manager ");
					payTime = input.nextDouble();
					payEmployee(emp, payTime);
				}
			}			
			
			
		} while(!action.equalsIgnoreCase("Q"));
	}
 	
}
