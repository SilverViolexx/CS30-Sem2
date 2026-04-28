/*
Program: TicTacToe.java          Last Date of this Revision: March 2, 2026

Purpose: Create a TicTacToe application that allows 2 players to play a computerized tic-tac-toe game.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {

	//Initialize variables that show up in other methods
	private JFrame frame;
	private JLabel promptDis;
	private JButton[][] grid;
	private String currPlayer;
	private int turnNum;
	private boolean stillPlay;
	private JButton reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Container to organize GUI components
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Display are for who's turn it is/winner
		promptDis = new JLabel("Player X's Turn");
		promptDis.setVerticalAlignment(SwingConstants.BOTTOM);
		promptDis.setHorizontalAlignment(SwingConstants.CENTER);
		promptDis.setFont(new Font("Calibri", Font.BOLD, 30));
		promptDis.setForeground(new Color(0, 0, 128));
		promptDis.setBounds(88, 21, 257, 48);
		panel.add(promptDis);
		
		//Container to organize tictactoe buttons
		JPanel tttPanel = new JPanel();
		tttPanel.setBounds(82, 69, 274, 236);
		panel.add(tttPanel);
		tttPanel.setLayout(new GridLayout(3, 3));
		
		//Button to restart game
		reset = new JButton("Play Again");
		reset.setFont(new Font("Calibri", Font.BOLD, 20));
		reset.setForeground(new Color(0, 0, 128));
		reset.setBounds(143, 315, 141, 32);
		panel.add(reset);
		reset.setVisible(false);
		
		//Assign values to variables
		currPlayer = "X";
		turnNum = 0;
		stillPlay = true;
		grid = new JButton[3][3];
		
		//Nested loop to create 9 buttons in a 3 by 3
		for (int rows = 0; rows < 3; rows ++) {
			for (int cols = 0; cols < 3; cols ++) {
				//Initialize button
				JButton spot = new JButton("");
				spot.setFont(new Font("Calibri", Font.BOLD, 20));
				spot.setForeground(new Color(0, 0, 128));
				
				//Stores button in a 2-D array + adds button to panel to display
				grid[rows][cols] = spot;
				tttPanel.add(spot);
				
				//saves which row + column the button belongs to
				final int r = rows;
				final int c = cols;
				
				//Waits for start button to be clicked
				spot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Checks if button is empty + if the game is ongoing
						if (spot.getText().equals("") && stillPlay) {
							//Calls method with button + position
							whoGoes(spot, r, c);
						}
					}
				});				
			}
		}	
	}
	//Method that handles player moves
	public void whoGoes (JButton spot, int rows, int cols) {
		//Sets button text to either "X" or "O"
		spot.setText(currPlayer);
		//Counts number of turns
		turnNum ++;
		
		//Checks if current player won - game over, calls for game to restart using method
		if (checkWinner(rows, cols)) {
			promptDis.setText("Player " + currPlayer + " Wins!");
			stillPlay = false;
			reset.setVisible(true);
			restartGame();
		}
		//Checks if it's a draw - game over, calls for game to restart using method
		else if (turnNum == 9) {
			promptDis.setText("It's A Tie!");
			stillPlay = false;
			reset.setVisible(true);
			restartGame();
		}
		//Game continues - switches player's turn
		else {
			if (currPlayer.equals("X") && stillPlay == true) {
				currPlayer = "O";
				promptDis.setText("Player " + currPlayer + "'s Turn");
			}
			else {
				currPlayer = "X";
				promptDis.setText("Player " + currPlayer + "'s Turn");
			}
		}
	}
	
	//Method that checks if there's a winner
	private boolean checkWinner(int rows, int cols) {
		//Retrieves wither "X" or "O" from buttons
		String checkSpot = grid[rows][cols].getText();
		
		//Checks horizontal for winner
		if (grid[rows][0].getText().equals(checkSpot) &&
			grid[rows][1].getText().equals(checkSpot) &&	
			grid[rows][2].getText().equals(checkSpot)) {
			return true;
		}
		//Checks vertical for winner
		else if (grid[0][cols].getText().equals(checkSpot) &&
			grid[1][cols].getText().equals(checkSpot) &&	
			grid[2][cols].getText().equals(checkSpot)) {
			return true;
		}
		//Checks diagonal(top left to bottom right) for winner
		else if (grid[0][0].getText().equals(checkSpot) &&
			grid[1][1].getText().equals(checkSpot) &&	
			grid[2][2].getText().equals(checkSpot)) {
			return true;
		}
		//Checks diagonal(top right to bottom left) for winner
		else if (grid[0][2].getText().equals(checkSpot) &&
			grid[1][1].getText().equals(checkSpot) &&	
			grid[2][0].getText().equals(checkSpot)) {
			return true;
		}
		//No winner yet
		return false;
	}
	
	//Method to restart the game
	private void restartGame() {
		//Waits for button to be clicked
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Clears all button of text
				for (int rows = 0; rows < 3; rows ++) {
					for (int cols = 0; cols < 3; cols ++) {
						grid[rows][cols].setText("");
					}
				}
				
				//Resets game variables
				currPlayer = "X";
				turnNum = 0;
				stillPlay = true;
				promptDis.setText("Player X's Turn");
				
				//Hides "Play Again" button
				reset.setVisible(false);
			}
		});
	}
}
