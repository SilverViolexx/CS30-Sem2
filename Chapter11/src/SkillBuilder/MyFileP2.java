package SkillBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFileP2 {

	public static void main(String[] args) {
		File textFile; 
		Scanner input = new Scanner(System.in);
		String response;
		
		//locate file(found in properties) with \\ in between
		textFile = new File("../Chapter11/src/SkillBuilder/zzz.txt"); 
		//OR textFile = new File("C:\\Users\\38207518\\git\\CS-30-Sem2\\Chapter11\\src\\SkillBuilder\\zzz.txt"); 
		
		//Checks if file already created
		if (textFile.exists()) {
			System.out.println("File Arlready Exists.");
		}
		else {
			//Exception handler that performs action when exception occurs so program doesn't crash
			//Defines block of code to be tested for errors while its being executed
			try {
				textFile.createNewFile(); //Creates file and returns true
				System.out.println("File Has Been Created"); //Need to refresh project to see it
			}
			//Block of code that will execute when error occurs
			catch (IOException e){
				System.out.println("File COuldn't Be Created");
				System.err.println("IOException: " + e.getMessage());
			}
		}
		
		//Deletes file if user wants
		System.out.println("Would you like to (K)eep or (D)elete this file?");
		response = input.next();
		
		if (response.equalsIgnoreCase("d")) {
			if (textFile.delete()) { //Deletes file and returns true
				System.out.println("File Has Been Deleted.");
			}
		}
		else {
			System.out.println("The File Has Been Kept And Remains The Same.");
		}
	}
}
