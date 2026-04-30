/*
Program: TestVehicle.java          Last Date of this Revision: April 27, 2026

Create PersonalAcct and BusinessAcct classes that inherit the Account class presented in Chapter 8. 
A personal account requires a minimum balance of $100. If the balance falls below this amount, then 
$2.00 is charged (withdrawn) to the account. A business account requires a minimum balance of $500, 
otherwise the account is charged $10. Create client code to test the classes.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30

*/
package Mastery;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount {
	public static Scanner input = new Scanner(System.in);
	public static void main (String[] args) {
		String acctID, accType, street, city, province, postalCode;	
		String notOption = "---- INVALID OPTION ----";
		String accNotFound = "---- Account Not Found ----" + "\n";
		int actionAcc, transaction;
		double withdraw, deposit;
		boolean exist;
		Account obj;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		ArrayList<PersonalAcct> PAccList = new ArrayList<>();
		ArrayList<BusinessAcct> BAccList = new ArrayList<>();
		
		System.out.print("Banking App" + "\n");
		
		//Loops until 5 is entered
		do {
			System.out.print("\n"
					+ "1. Create New Account" + "\n"
				+ "2. Withdraw/Deposit"  + "\n"
				+ "3. View Account Details"  + "\n"
				+ "4. Change Address" + "\n"
				+ "5. Exit"  + "\n" 
				+ "------------------------------------------" + "\n"
				+ "Input Choice(1-5): ");
			actionAcc = input.nextInt();
			input.nextLine();
			
			//Create account
			if (actionAcc == 1) {
				obj = bank(input);
				exist = false;
				
				//Object created
				if (obj != null) {
					//Personal or business account type - someone can have 2 accounts to their name(personal & business)
					if (obj.acctType().equalsIgnoreCase("personal")) {
					
						//Checks list of personal accounts for duplicates
						for (int i = 0; i < PAccList.size(); i++) {
							if (obj.getID().equals(PAccList.get(i).getID())) {
								exist = true;
								System.out.print("Account Already Exists." + "\n");
								break;
							}
						}
						//Adds object to list if it doesn't exist
						if(!exist) {
							PAccList.add((PersonalAcct) obj);
							System.out.print("\n" + "Personal Account Created!" + "\n"
								+ "Minimum Of $100 Required In Account Or $2 Fee Will Apply For Each Withdrawal." +"\n");
							System.out.print("Account ID: " + obj.getID() + "\n");
						}
					}				
					else if (obj.acctType().equalsIgnoreCase("business")) {
					
						//Checks list of business accounts for duplicates
						for (int i = 0; i < BAccList.size(); i++) {
							if (obj.getID().equals(BAccList.get(i).getID())) {
								exist = true;
								System.out.print("Account Already Exists." + "\n");
								break;
							}
						}
						//Creates an account
						if(!exist) {
							BAccList.add((BusinessAcct) obj);
							System.out.print("\n" + "Business Account Created!" + "\n"
								+ "Minimum Of $500 Required In Account Or $10 Fee Will Apply For Each Withdrawal." +"\n");
							System.out.print("Account ID: " + obj.getID() + "\n");
						}
					}
				}
			}
			
			//Transactions
			else if (actionAcc == 2) {
				//Prompts account ID and account type
				System.out.print("Account ID: ");
				acctID = input.nextLine();
				
				System.out.print("(B)usiness OR (P)ersonal Account: ");
				accType = input.nextLine();
				
				//Transactions for business accounts
				if (accType.equalsIgnoreCase("b")) {	
					//No business accounts created
					if (BAccList.isEmpty()) {
						System.out.print("No Business Accounts Exist. Please Create An Account First." + "\n");
					} 
					else {
						//Uses method to check if account ID matches an existing account
						BusinessAcct account = findBAcct(BAccList, acctID);
						
						//Account exists
						if (account != null) {
							//Display possible actions
							System.out.print("1. Withdraw" + "\n"
								+ "2. Deposit" +"\n"
								+ "Input Choice(1-2): ");
							transaction = input.nextInt();
							input.nextLine();
					
							//Withdraw from account
							if(transaction == 1) {
								System.out.print("Enter Withdrawal Amount($): ");
								withdraw = input.nextDouble();
								input.nextLine();
								account.withdrawal(withdraw);
								
								System.out.println(account.BusinessMinFee());
								
							}
							//Deposit in account
							else if(transaction == 2) {
								System.out.print("Enter Deposit Amount($): ");
								deposit = input.nextDouble();
								input.nextLine();
								account.deposit(deposit);
								
								System.out.print("New Balance: " + money.format(account.getBalance()) + "\n");
							}	
							//Invalid input
							else {
								System.out.print(notOption + "\n");
							}						
						}
						//Account not in arraylist
						else {
							System.out.print(accNotFound + "\n");
						}
					}
					
				}			
				//Transactions for personal accounts
				else if (accType.equalsIgnoreCase("p")) {		
					//No personal accounts created
					if (PAccList.isEmpty()) {
						System.out.print("No Personal Accounts Exist. Please Create An Account First." + "\n");
					} 
					else {			
						//Uses method to check if account ID matches an existing account
						PersonalAcct account = findPAcct(PAccList, acctID);
						
						//Account exists
						if (account != null) {
							//Display possible actions
							System.out.print("1. Withdraw" + "\n"
								+ "2. Deposit" +"\n"
								+ "Input Choice(1-2): ");
							transaction = input.nextInt();
							input.nextLine();
					
							//Withdraw from account
							if(transaction == 1) {
								System.out.print("Enter Withdrawal Amount($): ");
								withdraw = input.nextDouble();
								input.nextLine();
								account.withdrawal(withdraw);
								
								System.out.println(account.PersonalMinFee());
							}
							//Deposit in account
							else if(transaction == 2) {
								System.out.print("Enter Deposit Amount($): ");
								deposit = input.nextDouble();
								input.nextLine();
								account.deposit(deposit);
								
								System.out.print("New Balance: " + money.format(account.getBalance()) + "\n");
							}			
							//Invalid input
							else {
								System.out.print(notOption + "\n");	
							}
						}
						//Account not found in arraylist
						else {
							System.out.print(accNotFound + "\n");
						}
					}			
				}		
				//Invalid input
				else {
					System.out.print(notOption + "\n");
				}
			}

			//View account details
			else if (actionAcc == 3) {
				//Prompts account ID and account type
				System.out.print("Account ID: ");
				acctID = input.nextLine();
				
				System.out.print("(B)usiness OR (P)ersonal Account: ");
				accType = input.nextLine();
				
				//View details for business accounts
				if (accType.equalsIgnoreCase("b")) {		
					//Uses method to check if account ID matches an existing account
					BusinessAcct account = findBAcct(BAccList, acctID);
					
					//Account exists
					if (account != null) {
						System.out.print(account.toStringBA());
					}
					//Account doesn't exists
					else {
						System.out.print(accNotFound + "\n");
					}
				}
				//View details for personal accounts
				else if (accType.equalsIgnoreCase("p")) {	
					//Uses method to check if account ID matches an existing account
					PersonalAcct account = findPAcct(PAccList, acctID);
					
					//Account exists
					if (account != null) {
						System.out.print(account.toStringPA());
					}
					//Account doesn't exists
					else {
						System.out.print(accNotFound + "\n");
					}
				}
				//Invalid input
				else {
					System.out.print(notOption + "\n");
				}
			} 
			
			//Change Address
			else if (actionAcc == 4) {
				//Prompts account ID and account type
				System.out.print("Account ID: ");
				acctID = input.nextLine();
				
				System.out.print("(B)usiness OR (P)ersonal Account: ");
				accType = input.nextLine();
				
				//Change address for business accounts
				if (accType.equalsIgnoreCase("b")) {	
					//Uses method to check if account ID matches an existing account
					BusinessAcct account = findBAcct(BAccList, acctID);
					
					//Account exists
					if (account != null) {
							System.out.print("\n" + "Enter Address Information" + "\n"
								+ "Street: ");
							street = input.nextLine();
				
							System.out.print("City: ");
							city = input.nextLine();
				
							System.out.print("Province: ");
							province = input.nextLine();
				
							System.out.print("Postal Code: ");
							postalCode = input.nextLine();
							
							account.changeAddress(street, city, province, postalCode);
					}
					else {
						System.out.print(accNotFound + "\n");
					}
				}
				//Change address for personal accounts
				else if (accType.equalsIgnoreCase("p")) {	
					//Uses method to check if account ID matches an existing account
					PersonalAcct account = findPAcct(PAccList, acctID);
					
					//Account exists
					if (account != null) {
						//Prompts user for information
						System.out.print("\n" + "Enter Address Information" + "\n"
							+ "Street: ");
						street = input.nextLine();
			
						System.out.print("City: ");
						city = input.nextLine();
			
						System.out.print("Province: ");
						province = input.nextLine();
				
						System.out.print("Postal Code: ");
						postalCode = input.nextLine();
							
						//Use method to change address using info inputted
						account.changeAddress(street, city, province, postalCode);
					}
					//Account not found
					else {
						System.out.print(accNotFound + "\n");
					}
				}
				//Invalid input
				else { 
					System.out.print(notOption + "\n");
				}
			}
			
			//End program
			else if (actionAcc == 5) {
				continue;
			}
			//Invalid input
			else {
				System.out.print(notOption + "\n");
			}
			
		} while (actionAcc != 5);
	}
	
	//Method that returns an object
	public static Account bank(Scanner input) {
		//Initialize variables
		String fName, lName, street, city, province, postalCode, type;
		double balance;
		
		//Prompt user for information to create object
		System.out.print("\n" + "First Name: ");
		fName = input.nextLine();
		
		System.out.print("Last Name: ");
		lName = input.nextLine();
		
		System.out.print("Initial Balance($): ");
		balance = input.nextDouble();
		input.nextLine();	
		
		System.out.print("\n" + "Enter Address Information" + "\n"
						+ "Street: ");
		street = input.nextLine();
		
		System.out.print("City: ");
		city = input.nextLine();
		
		System.out.print("Province: ");
		province = input.nextLine();
		
		System.out.print("Postal Code: ");
		postalCode = input.nextLine();
		
		System.out.print("(B)usiness OR (P)ersonal Account: ");
		type = input.nextLine();
		
		//Keeps prompting user until valid value is entered
		while(!type.equalsIgnoreCase("p") && !type.equalsIgnoreCase("b")) {
			System.out.println("Invalid option.");

			System.out.print("(B)usiness OR (P)ersonal Account: ");
			type = input.nextLine();
		}
		
		//Returns personal account
		if (type.equalsIgnoreCase("p")) {
			return (new PersonalAcct(balance, fName, lName, street, city, province, postalCode));
		}
		//Returns business account
		else if (type.equalsIgnoreCase("b")) {
			return (new BusinessAcct(balance, fName, lName, street, city, province, postalCode));
		}
		return null;
	}
		
	//Method checks if the personal account exists
	public static PersonalAcct findPAcct(ArrayList<PersonalAcct> list, String id) {
		//Checks each object in an arraylist
		for (int i = 0; i < list.size(); i++) {
			PersonalAcct account = list.get(i);
			//Returns account if it exists in an arraylist
			if (id.equalsIgnoreCase(account.getID())) {
				return account;
			}
		}
		return null;
	}
	
	//Method checks if the business account exists
	public static BusinessAcct findBAcct(ArrayList<BusinessAcct> list, String id) {
		//Checks each object in an arraylist
		for (int i = 0; i < list.size(); i++) {
			BusinessAcct account = list.get(i);
			//Returns account if it exists in an arraylist
			if (id.equalsIgnoreCase(account.getID())) {
				return account;
			}
		}
		return null;
	}
}

/*
Example 1:
Banking App

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 2
Account ID: account
(B)usiness OR (P)ersonal Account: p
No Personal Accounts Exist. Please Create An Account First.

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 9
---- INVALID OPTION ----

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 1

First Name: Amanda
Last Name: Ly
Initial Balance($): 50

Enter Address Information
Street: Crescent Heights
City: Calgary
Province: Alberta
Postal Code: T8R 8L2
(B)usiness OR (P)ersonal Account: p

Personal Account Created!
Minimum Of $100 Required In Account Or $2 Fee Will Apply For Each Withdrawal.
Account ID: ALy

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 2
Account ID: ALy
(B)usiness OR (P)ersonal Account: p
1. Withdraw
2. Deposit
Input Choice(1-2): 1
Enter Withdrawal Amount($): 10
Minimum Of $100.00 Required In Account. $2.00 Withdrawal Fee Applied.
New Balance: $38.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 2
Account ID: ALy
(B)usiness OR (P)ersonal Account: p
1. Withdraw
2. Deposit
Input Choice(1-2): 2
Enter Deposit Amount($): 100
New Balance: $138.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 2
Account ID: ALy
(B)usiness OR (P)ersonal Account: p
1. Withdraw
2. Deposit
Input Choice(1-2): 1
Enter Withdrawal Amount($): 5
The Required Minimum Of $100.00 Is Met. No Fee Applied.
New Balance: $133.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 3
Account ID: ALy
(B)usiness OR (P)ersonal Account: p
Account Holder's Name: Amanda Ly
Adress: Crescent Heights, Calgary, Alberta, T8R 8L2
Current balance: $133.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 1

First Name: John
Last Name: Smith
Initial Balance($): 300

Enter Address Information
Street: Crescent Heights
City: Calgary
Province: Alberta
Postal Code: N8D 2S9
(B)usiness OR (P)ersonal Account: B

Business Account Created!
Minimum Of $500 Required In Account Or $10 Fee Will Apply For Each Withdrawal.
Account ID: JSmith

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 2
Account ID: JSmith
(B)usiness OR (P)ersonal Account: b
1. Withdraw
2. Deposit
Input Choice(1-2): 1
Enter Withdrawal Amount($): 20
Minimum Of $500.00 Required In Account. $10.00 Withdrawal Fee Applied.
New Balance: $270.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 4
Account ID: JSmith
(B)usiness OR (P)ersonal Account: b

Enter Address Information
Street: Richmond
City: Vancouver
Province: British Columbia
Postal Code: M5B 9K3

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 3
Account ID: JSmith
(B)usiness OR (P)ersonal Account: b
Account Holder's Name: John Smith
Adress: Richmond, Vancouver, British Columbia, M5B 9K3
Current balance: $270.00

1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 3
Account ID: hello
(B)usiness OR (P)ersonal Account: p
---- Account Not Found ----


1. Create New Account
2. Withdraw/Deposit
3. View Account Details
4. Change Address
5. Exit
------------------------------------------
Input Choice(1-5): 5
 */