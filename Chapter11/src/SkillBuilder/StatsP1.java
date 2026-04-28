package SkillBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class StatsP1 {

	public static void main (String[] args0) {
		//Initialize
		//Absolute path - c:\\
		//Relative path(for cross device - sharing files) - ../ 
		File textFile = new File("C:\\Users\\38207518\\git\\CS-30-Sem2\\Chapter11\\src\\SkillBuilder\\test1.dat");
		//Use both FileReader + BufferedReader
		FileReader reads;
		BufferedReader readFile;
		
		String studentN, score;
		double scoreValue, average;
		double lowScore = 100;
		double highScore = 0;
		double totalScore = 0;
		int numScore = 0;
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		//Code that will be tested for errors
		try {
			//Pass FileReader (for simple/small file writing) to BufferedReader
			reads = new FileReader(textFile);
			readFile = new BufferedReader(reads);
			
			//Reads first line - reads name 
			//Pattern repeats
			while ((studentN = readFile.readLine()) != null) {
				//Reads second line - reads grade
				score = readFile.readLine();
				System.out.println(studentN + " " + score);
				
				numScore += 1;
				
				scoreValue = Double.parseDouble(score);
				totalScore += scoreValue;
				
				//Replaces lowest/highest score
				if (scoreValue < lowScore) {
					lowScore = scoreValue;
				}
				if (scoreValue > highScore) {
					highScore = scoreValue;
				}
				
			}
			
			average = totalScore / numScore;
			
			System.out.print("Low Score: " + percent.format(lowScore / 100) + "\n"
					+ "High Score: " + percent.format(highScore / 100) + "\n"
					+ "Average Score: " + percent.format(average / 100));
			
			readFile.close();
			reads.close();
			
		}
		//Executes code if error occurs
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
