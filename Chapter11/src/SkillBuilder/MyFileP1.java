package SkillBuilder;

import java.io.File;
import java.util.Scanner;

public class MyFileP1 {

		public static void main (String[] args) {
			File textFile;
			Scanner input = new Scanner(System.in);
			String fileName;
			
			//Obtain file name from user
			System.out.println("Enter The File Name: ");
			fileName = input.nextLine();
			
			//Determine if file exits or not
			textFile = new File(fileName);
			
			if (textFile.exists()) {
				System.out.println("File Exists.");
				//When entering file use path(found in properties) with ..
				//ie. ../Chapter11/src/SkillBuilder/TestFile.txt
			}
			else {
				System.out.println("File Doesn't Exists.");
			}
		}
}
