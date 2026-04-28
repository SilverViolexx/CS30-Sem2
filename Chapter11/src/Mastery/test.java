package Mastery;

import java.io.*;

public class test {

	public static void main (String[] args) {
		File textFile = new File("C:\\Users\\38207518\\git\\CS-30-Sem2\\Chapter11\\src\\Mastery\\tester.txt");
		FileReader reads;
		BufferedReader readFile;
		double totalBalance = 0;
		double amount;
		String eachLine;

		try{
		reads = new FileReader(textFile);
		readFile = new BufferedReader(reads);

		while ((eachLine  = readFile.readLine()) != null) {
				amount = Double.parseDouble(eachLine);
				totalBalance = totalBalance + amount;
			}
		
		System.out.println("Total Balance: $" + totalBalance);
		
		readFile.close();
		reads.close();
		}
		catch (FileNotFoundException e) {
		System.out. println("File Doesn’t Exist.");
		System.err.println("FileNotFoundException: " + e.getMessage());
		}
		catch (IOException e) {
		System.out. println("Problem Reading File.");
		System.err.println("IOException: " + e.getMessage());
		}
		
	}
}
