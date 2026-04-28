/*
Program: BreakAPlate.java          Last Date of this Revision: February 24, 2026

Purpose: Create BreakAPlate application that simulates a game booth at a carnival with breaking plates.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/
package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BreakAPlate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Container to organize GUI components
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Display area for plate images
		JLabel plateDis = new JLabel("");
		plateDis.setBounds(37, 34, 368, 114);
		panel.add(plateDis);
		
		//Display area for reward images and text
		JLabel reward = new JLabel("");
		reward.setHorizontalAlignment(SwingConstants.CENTER);
		reward.setForeground(new Color(0, 0, 128));
		reward.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		reward.setBounds(99, 209, 244, 124);
		panel.add(reward);
		
		//Start button
		JButton startGame = new JButton("Start");
		startGame.setBackground(SystemColor.inactiveCaptionBorder);
		startGame.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		startGame.setForeground(new Color(0, 0, 128));
		startGame.setBounds(152, 167, 132, 34);
		panel.add(startGame);
		
		//Initialize images
		ImageIcon ogPlate = new ImageIcon ("../Chapter_10/src/Mastery/plate.png");
		ImageIcon plate2 = new ImageIcon ("../Chapter_10/src/Mastery/2 Broken Plates.png");
		ImageIcon plate3 = new ImageIcon ("../Chapter_10/src/Mastery/3 Broken Plates.png");
		ImageIcon placeHolder = new ImageIcon ("../Chapter_10/src/Mastery/placeholder.png");
		ImageIcon plush = new ImageIcon ("../Chapter_10/src/Mastery/tiger.png");
		ImageIcon sticker = new ImageIcon ("../Chapter_10/src/Mastery/sticker.png");
		
		//Set image in display area for plates
		plateDis.setIcon(ogPlate);
		
		//Set image in display area for reward and position text
		reward.setIcon(placeHolder);
		reward.setHorizontalTextPosition(JLabel.CENTER);
		reward.setVerticalTextPosition(JLabel.TOP);
		
		//Waits for start button to be clicked
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Picks between 1 and 0 three times and adds it together
				Random r = new Random();
				int ran1 = r.nextInt(2);
				int ran2 = r.nextInt(2);	
				int ran3 = r.nextInt(2);	
				int total = ran1 + ran2 + ran3;
				startGame.setText("Play Again");
			
				//Displays prize and/or text based on the sum
				if (total == 3) {
					plateDis.setIcon(plate3);
					reward.setIcon(plush);
					reward.setText("You win a prize!");
				}
				else if (total == 2) {
					plateDis.setIcon(plate2);
					reward.setIcon(sticker);
					reward.setText("You win a prize!");
				}
				else {
					plateDis.setIcon(ogPlate);
					reward.setText("You missed, nice try!");
					reward.setIcon(placeHolder);
				}

			}
		});
	
	}
}
