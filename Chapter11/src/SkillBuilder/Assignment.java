package SkillBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment {

	public static void main (String[] args) {
		File textFile; 
		FileReader reads;
		BufferedReader readFile;
		String eachLine;
		
		//Locating file
		textFile = new File("../Chapter11/src/SkillBuilder/AssingmentFile.txt");
		
		try {
			reads = new FileReader(textFile);
			readFile = new BufferedReader(reads);
			
			while ((eachLine = readFile.readLine()) != null) {
				System.out.println(eachLine);
			}
			
			//Must close methods in reverse order of when its opened
			readFile.close();
			reads.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found.");
			System.err.println("FileNotFOundException: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}
		
}
