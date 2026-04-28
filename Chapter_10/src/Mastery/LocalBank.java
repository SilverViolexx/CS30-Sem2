/*
Program: LocalBank.java          Last Date of this Revision: March 3, 2026

Purpose: Create LocalBankGUI application that implements a GUI for the Local Bank case study.

Author: Amanda Ly
School: CHHS
Course: Computer Programming 30
 
*/

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class LocalBank {

	//Initialize variables that show up in other methods
	private JFrame frame;
	private JTextField fNameDis, lNameDis, balanceDis, accNumDis, wAmtDis, dAmtDis;
	private JButton submit;
	private JLabel resultDis;
	private String fName, lName, accID, result;
	private double balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBank window = new LocalBank();
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
	public LocalBank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Container to organize GUI components
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Display area for output
		resultDis = new JLabel("");
		resultDis.setForeground(new Color(0, 0, 128));
		resultDis.setFont(new Font("Calibri", Font.BOLD, 15));
		resultDis.setBounds(27, 183, 399, 66);
		panel.add(resultDis);
		
		//Button for user input
		submit = new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setFont(new Font("Calibri", Font.BOLD, 20));
		submit.setForeground(new Color(0, 0, 128));
		submit.setVisible(false);
		submit.setBounds(27, 259, 133, 28);
		panel.add(submit);		
		
		//New object
		Bank action = new Bank();
		
		//Drop list of possible actions
		JComboBox prompt = new JComboBox();
		prompt.setBackground(SystemColor.inactiveCaptionBorder);
		prompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Method that resets text boxes + its visibility
				hideBoxes();
				
				//Method that overrides text of the boxes
				override(fNameDis, "First Name:");
				override(lNameDis, "Last Name:");
				override(balanceDis, "Starting Balance:");
				override(accNumDis, "Account ID:");
				override(wAmtDis, "Withdraw Amount:");
				override(dAmtDis, "Deposit Amount:");
				
				//When "Add An Account" is selected
				if (prompt.getSelectedItem().equals("Add An Account")) {
					//Displays boxes needed
					fNameDis.setVisible(true);
					lNameDis.setVisible(true);
					balanceDis.setVisible(true);
					resultDis.setVisible(true);
					submit.setVisible(true);
					
					//Waits for user to click button
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Set values for variables using user input
							fName = fNameDis.getText();
							lName = lNameDis.getText();
							balance = Double.parseDouble(balanceDis.getText());
							//Uses method to create an account + displays information
							accID = action.addAccount(fName, lName, balance);
							resultDis.setText("Account created. Account ID is: " + accID);
						}
					});
				}
				//When "Remove An Account" is selected
				else if (prompt.getSelectedItem().equals("Remove An Account")) {
					//Displays boxes needed
					accNumDis.setVisible(true);
					resultDis.setVisible(true);
					submit.setVisible(true);
					
					//Waits for user to click button
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Set values for variables using user input
							accID = accNumDis.getText();
							
							//Uses method to delete an account + displays information
							result = action.deleteAccount(accID);
							resultDis.setText(result);
						}
					});
					
				}
				else if (prompt.getSelectedItem().equals("Withdraw")) {
					//Displays boxes needed
					accNumDis.setVisible(true);
					wAmtDis.setVisible(true);
					resultDis.setVisible(true);
					submit.setVisible(true);
					
					//Waits for user to click button
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Set values for variables using user input
							accID = accNumDis.getText();
							balance = Double.parseDouble(wAmtDis.getText());
		
							//Uses method to withdraw money + displays information
							result = action.transaction(2, accID, balance);
							resultDis.setText(result);
						}
					});
					
				}
				else if (prompt.getSelectedItem().equals("Deposit")) {
					//Displays boxes needed
					accNumDis.setVisible(true);
					dAmtDis.setVisible(true);
					resultDis.setVisible(true);
					submit.setVisible(true);
					
					//Waits for user to click button
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Set values for variables using user input
							accID = accNumDis.getText();
							balance = Double.parseDouble(dAmtDis.getText());
		
							//Uses method to deposit money + displays information
							result = action.transaction(1, accID, balance);
							resultDis.setText(result);
						}
					});
					
				}
				else if (prompt.getSelectedItem().equals("Check Balance")) {
					//Displays boxes needed
					accNumDis.setVisible(true);
					resultDis.setVisible(true);
					submit.setVisible(true);
					
					//Waits for user to click button
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Set values for variables using user input
							accID = accNumDis.getText();
		
							//Uses method to check balance + displays information
							result = action.checkBalance(accID);
							resultDis.setText(result);
						}
					});
					
				}
			}
		});
		prompt.setFont(new Font("Calibri", Font.BOLD, 20));
		prompt.setForeground(new Color(0, 0, 128));
		prompt.setModel(new DefaultComboBoxModel(new String[] {"Please Choose An Option:", "Add An Account", "Remove An Account", "Withdraw", "Deposit", "Check Balance"}));
		prompt.setBounds(27, 27, 255, 28);
		panel.add(prompt);
		
		//Area for user to input information
		fNameDis = new JTextField();
		fNameDis.setText("First Name:");
		fNameDis.setForeground(new Color(0, 0, 128));
		fNameDis.setFont(new Font("Calibri", Font.BOLD, 15));
		fNameDis.setBounds(27, 75, 255, 28);
		panel.add(fNameDis);
		fNameDis.setColumns(10);
		fNameDis.setVisible(false);
		
		lNameDis = new JTextField();
		lNameDis.setText("Last Name:");
		lNameDis.setForeground(new Color(0, 0, 128));
		lNameDis.setFont(new Font("Calibri", Font.BOLD, 15));
		lNameDis.setColumns(10);
		lNameDis.setBounds(27, 113, 255, 28);
		panel.add(lNameDis);
		lNameDis.setVisible(false);
		
		balanceDis = new JTextField();
		balanceDis.setText("Starting Balance:");
		balanceDis.setForeground(new Color(0, 0, 128));
		balanceDis.setFont(new Font("Calibri", Font.BOLD, 15));
		balanceDis.setColumns(10);
		balanceDis.setBounds(27, 149, 255, 28);
		panel.add(balanceDis);
		balanceDis.setVisible(false);
		
		accNumDis = new JTextField();
		accNumDis.setText("Account ID:");
		accNumDis.setForeground(new Color(0, 0, 128));
		accNumDis.setFont(new Font("Calibri", Font.BOLD, 15));
		accNumDis.setColumns(10);
		accNumDis.setBounds(27, 75, 255, 28);
		panel.add(accNumDis);
		accNumDis.setVisible(false);	
		
		wAmtDis = new JTextField();
		wAmtDis.setText("Withdraw Amount:");
		wAmtDis.setForeground(new Color(0, 0, 128));
		wAmtDis.setFont(new Font("Calibri", Font.BOLD, 15));
		wAmtDis.setColumns(10);
		wAmtDis.setBounds(27, 113, 255, 28);
		panel.add(wAmtDis);
		wAmtDis.setVisible(false);
		
		dAmtDis = new JTextField();
		dAmtDis.setText("Deposit Amount:");
		dAmtDis.setForeground(new Color(0, 0, 128));
		dAmtDis.setFont(new Font("Calibri", Font.BOLD, 15));
		dAmtDis.setColumns(10);
		dAmtDis.setBounds(27, 113, 255, 28);
		panel.add(dAmtDis);
		dAmtDis.setVisible(false);
		
	}
	//Method that resets text boxes + its visibility
	public void hideBoxes() {
		fNameDis.setVisible(false);
		lNameDis.setVisible(false);
		balanceDis.setVisible(false);
		accNumDis.setVisible(false);
		wAmtDis.setVisible(false);
		dAmtDis.setVisible(false);
			
		fNameDis.setText("First Name:");
		lNameDis.setText("Last Name:");
		balanceDis.setText("Starting Balance:");
		resultDis.setText("");
		accNumDis.setText("Account ID:");
		wAmtDis.setText("Withdraw Amount:");
		dAmtDis.setText("Deposit Amount:");
		
		//Loop that ensures that only the most recent ActionListener responds
		for (ActionListener al : submit.getActionListeners()) {
			submit.removeActionListener(al);
		}
	}
	//Method that makes it so the prompt disappears when the user types
	public void override(JTextField area, String ogPrompt) {
		area.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (area.getText().equals(ogPrompt)) {
					area.setText("");
				}
			}
		});
	}
}