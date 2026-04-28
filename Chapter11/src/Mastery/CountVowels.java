/*
Program: CounterVowels.java          Last Date of this Revision: March 17, 2026

Purpose: Create a CountVowels application that count the number of vowels 
in a text file. The application should prompt the user for the file name.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/
package Mastery;
import java.io.*; 
import java.util.Scanner;

public class CountVowels {

	public static void main (String[] args) {
		File textFile;
	    FileReader in;
	    BufferedReader readFile;
	    String fileName;
	    String lineInFile, lowercaseText;
	    char letter;
	    int vowelSum = 0;	      

	    /* prompt the user for the name of the file */
	    System.out.print("Please Enter A File: ");
	    Scanner input = new Scanner(System.in);
	    fileName = input.next();

	    /* count the vowels in the file */
	    try {
	    	//new File object required
	    	textFile = new File (fileName);
	        //new File reader object required
	    	in = new FileReader(textFile);
	        //new BufferedReader object required
	    	readFile = new BufferedReader(in);

	        //read the lines from the file
	    	while ((lineInFile = readFile.readLine()) != null) {
	    		//as lines are read convert them to lower case
	    		lowercaseText = lineInFile.toLowerCase().replaceAll("\\W", "");
	    		
	    		//iterate through the lower case text
	    		for (int i = 0; i < lowercaseText.length(); i ++) {
	    			letter = lowercaseText.charAt(i);	//Can also use substring instead for char
	    			
	    			//check if each character traverse through is a vowel
	    			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
	    				//update total vowels
	    				vowelSum += 1;
	    			}    			
	    		}
	    	}                
	    
	    	//user wants to know the number of vowels inside a file name
	    	System.out.println("There Are " + vowelSum + " Vowel(s) In This File.");
	    	
	    	//close BufferedReader object
	    	readFile.close();
	    	//close FileReader object
	    	in.close();
	           
		}
	    catch (FileNotFoundException e){
	    	System.out.println("File doesn't exist.");
			System.err.println("FileNotFOundException: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}
	
}
