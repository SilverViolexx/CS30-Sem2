/*
Program: WordGuess.java          Last Date of this Revision: March 17, 2026

Purpose: Create a WordGuessing Game application that uses a word from a file as the secret word. The file 
should contain a list of words, with one word per line. The WordGuess application should determine 
which word to use, by generating a random number that corresponds to one of the words in the file.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/
package Mastery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
	
	public static void main (String[] args) {
		
		//Loop sentinel - continues loop as long as input != sentinel
		final String FLAG = "!";

		//Create a File object with the name of your file is the parameter
		File textFile = new File("../Chapter11/src/Mastery/RandomWord");
		
		//Declare a File reader object
		FileReader reads;
		//Declare a BufferedReader object
		BufferedReader readF;
		//Create a random number object
		Random ranNum = new Random();
		
		Scanner input = new Scanner(System.in);

		int numWords = 0;
		int wordToGuess;
		String secretWord = "";
		String wordSoFar = "", updatedWord = "";
		String letterGuess, wordGuess = "";
		int numGuesses = 0;
		int tries = 15;

		/* select secret word */
		try {
			//initialize the file reader object to name of the file object
            reads = new FileReader(textFile);
            //initialize the BufferedReader object to the name of the file reader as a parameter
            readF = new BufferedReader(reads);
            //Get the number of words in the file using readFile
            while ((readF.readLine()) != null) {
            	numWords ++;
            }               		
                
             //Need to close and reopen it to read file again
             readF.close();
             reads.close();
                
             reads = new FileReader(textFile);           
             readF = new BufferedReader(reads);                
                
             //update the word to guess to the random object and number of words read plus one
             wordToGuess = ranNum.nextInt(1, numWords + 1);
                
 
             //Goes through lines in file until it gets to the secret word
             for (int i = 0; i < wordToGuess; i++) {
                	
            	//Assigns secret word
                secretWord = readF.readLine();         
                	            
             }                         
             //Capitalizes secret word
             secretWord = secretWord.toUpperCase();
               
             //close your BufferedReader object
             readF.close();
             //close your FileReader object
             reads.close();				
    	} 
		
		//Exception handling
		catch (FileNotFoundException e){
			System.out.println("File doesn't exist.");
			System.err.println("FileNotFOundException: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}

		/* begin the game */
		System.out.println("WordGuess game." + "\n");

        //iterate through the secret word, and update the word so far variable to represent using dashes 
        //the length of the secret word
        //output the word so far using dashes
		for (int i = 0; i < secretWord.length(); i ++) {
			wordSoFar += "-";
		}
		System.out.println(wordSoFar);


		/* allow player to make guesses*/
		do {
			//prompt for a letter
			System.out.print(tries + " Guesses Remaining." + "\n"
					+ "Guess A Letter (" + FLAG + " To Guess The Entire Word): ");
			letterGuess = input.next();
			letterGuess = letterGuess.toUpperCase();

			/* increment number of guesses */
			numGuesses += 1;
			tries -= 1;		

			/* player correctly guessed a letter--extract string in wordSoFar up to the letter
			 * guessed and then append guessed letter to that string. Next, extract rest of
			 * wordSoFar and append after the guessed letter
			 */
			
			int index = secretWord.indexOf(letterGuess);
			
			//indexOf - returns index where the first occurrence of "letterGuess" in the String
			//Runs code if letter guessed is in the word
			while (index >= 0) {
				//Extracts characters from the start of the word to just before the correctly guessed letter - replaces dash with letter guessed				
				updatedWord = wordSoFar.substring(0, index);
				updatedWord += letterGuess;
				updatedWord += wordSoFar.substring(index + 1, wordSoFar.length());
				wordSoFar = updatedWord;
				
				//Starts looking for letter after first instance of letter
				index = secretWord.indexOf(letterGuess, index + 1);				
			}

			/* display guessed letter instead of dash */
			System.out.println(wordSoFar + "\n");
		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(secretWord) && tries != 0); //Do-while checks condition at end
        
		/* finish game and display message and number of guesses */
		if (letterGuess.equals(FLAG)) {
			System.out.print("What Is Your Guess: ");
			wordGuess = input.next();
			wordGuess = wordGuess.toUpperCase();
		}		
		if (tries == 0) {
			System.out.println("Sorry, No More Guesses. You Lose.");
		}
		if (wordGuess.equals(secretWord) || wordSoFar.equals(secretWord)) {
			System.out.println("You Won!");
		}
		else {
			System.out.println("Sorry. You Lose.");
		}
		System.out.println("The Secret Word Is: " + secretWord);
		System.out.println("You Made " + numGuesses + " guesses.");      
		
	}
}
