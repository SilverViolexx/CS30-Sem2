package SkillBuilder;

import java.util.Scanner;
import java.io.*; //* imports every class in package (ie. File, BufferedReader) 

public class Roster {

	public static void main (String[] args) {
						
		Scanner input = new Scanner(System.in);
		
		File FileN;
		/*
		FileReader reads;
		BufferedReader readF;
		FileWriter writes;
		BufferedWriter writeF;
		*/
		String studentF, firstN, lastN;
		int numStu;
		
		//Object
		//StudentFile action = new StudentFile();
		
		System.out.print("Name This File: ");
		studentF = input.next();
		
		FileN = new File(studentF);
		
		System.out.print("Number Of Students: ");
		numStu = input.nextInt();
		
		//Write objects
		try {
			//Use both to write raw data to a file
			FileOutputStream out = new FileOutputStream(FileN);
			ObjectOutputStream writeN = new ObjectOutputStream(out);
			
			for (int i = 0; i < numStu; i ++) {
				System.out.print("First Name: ");
				firstN = input.next();
				
				System.out.print("Last Name: ");
				lastN = input.next();
				
				writeN.writeObject(new StudentFile(firstN, lastN));
			}
			writeN.close();
			System.out.println("Data has been written.");
			
			//Read objects
			InputStream in = new FileInputStream(FileN);
			ObjectInputStream readN = new ObjectInputStream(in);
			
			for (int p = 0; p < numStu; p ++) {
				System.out.println((StudentFile)readN.readObject());
			}
			
			readN.close();
			
			
		}
		catch (FileNotFoundException e){
			System.out.println("File doesn't exist.");
			System.err.println("FileNotFOundException: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class couldn't be used to cast object.");
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		
	}
	
	
	
	
}
