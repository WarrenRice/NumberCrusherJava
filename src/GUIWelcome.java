import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIWelcome extends JFrame {
		
		private GUIMenu menuGUI;									// define menuGUI as a MenuGUI object for the next window
		private JPanel contentPane;									// define contentPane as a JPanel for main content pane
		
		private JLabel lblGameName;									// define lblGameName as a JLabel to display text
		private JLabel lblNameInput;								// define lblNameInput as a JLabel to display text
		
		private JTextField textFieldPlayerNameInput;				// define textFieldPlayerNameInput as a JTextField for player to enter initials
		private JButton btnPlayerNameInput;							// define btnPlayerNameInput as a JButton this run action when is clicked
		private JLabel lblNote;										// define lblNote as JLabel to display text note

	public GUIWelcome() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	WelcomeGUI class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	WelcomeGUI
		*
		* Synopsis				:	Constructor of the class WelcomeGUI. Creates an instance of the WelcomeGUI window frame. 
		* 								This class initializes and runs JFrame, JTextField, contentPane, buttons, labels, 
		* 								 and create WelcomeGUI window.
		* 
		* References			:   Oracle. (2023). Class String. Retrieved May 30, 2023, 
		* 								from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html		
		*
		*							Oracle. (2023). Class JFrame. Retrieved May 30, 2023, 
		*								from https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
		*
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-05-16		W. Poomarin				Build UI layout
		*							2023-05-19		W. Poomarin				Finish mode generator
		*							2023-05-21		W. Poomarin				Finish game mechanic
		*							2023-05-23		W. Poomarin				Finish first programming
		*							2023-05-25		W. Poomarin				Add commends
		*							2023-05-27		W. Poomarin				Add Method to display mode
		*							2023-05-28		W. Poomarin				Finish save/load file
		*							2023-05-29		W. Poomarin				Add References
		*							2023-05-30		W. Poomarin				Fix bugs when loaded but the game generate new random numbers
		*							2023-05-31		W. Poomarin				Fix save and load previous player's state
		*							2023-06-02		W. Poomarin				Record player's actions 
		*							2023-06-05		W. Poomarin				Add Payload class to save and load player's actions
		*							2023-06-06		W. Poomarin				Fix bugs when the show X marks load empty record
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// close button setup
		setBounds(640, 250, 768, 512);								// set up window size			
		
		//----------set up contentPane------------//
		contentPane = new JPanel();									// instantiate contentPane as JPanel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);							
		contentPane.setLayout(null);

		
		lblGameName = new JLabel("Welcome to Number Cruncher");		// instantiate JLabel and set label to "Welcome to Number Cruncher"
		lblGameName.setHorizontalAlignment(SwingConstants.CENTER);	// set position to center
		lblGameName.setFont(new Font("Tahoma", Font.BOLD, 16));		// set font
		lblGameName.setBounds(138, 140, 419, 20);					// set size and position
		contentPane.add(lblGameName);								// add lblGameName to contentPane
		
		textFieldPlayerNameInput = new JTextField();				// instantiate JTextField
		textFieldPlayerNameInput.setBounds(313, 210, 156, 26);		// set size and position
		textFieldPlayerNameInput.setFont(new Font("Tahoma", Font.BOLD, 16));	// set size and position
		textFieldPlayerNameInput.setColumns(10);					
		contentPane.add(textFieldPlayerNameInput);					// add textFieldPlayerNameInput to contentPane
		
		lblNameInput = new JLabel("Enter Your Initial:");			// instantiate JLabel and set label to "Enter Your Initial:"
		lblNameInput.setBounds(138, 213, 147, 20);					// set size and position
		lblNameInput.setFont(new Font("Tahoma", Font.BOLD, 16));	// set font
		contentPane.add(lblNameInput);								// add lblNameInput to contentPane
		
		lblNote = new JLabel("");									// instantiate JLabel and set label to ""
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);		// set position to center
		lblNote.setBounds(313, 261, 156, 14);						// set size and position
		contentPane.add(lblNote);									// add lblNote to contentPane
		
		btnPlayerNameInput = new JButton("OK");						// instantiate JButton and set label to "OK"
		btnPlayerNameInput.setBounds(495, 210, 62, 27);				// set size and position
		btnPlayerNameInput.addActionListener(new ActionListener() { // run goNext() when is clicked
			public void actionPerformed(ActionEvent e) {			// call goNext() when button is clicked
				goNext();											
			}
		});
		contentPane.add(btnPlayerNameInput);
	}
	
	public void goNext() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Void goNext
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method get player's initials and pass to new window
		* 
		* Modifications			:
		*							Date			Developer				Notes
		*							----			---------				-----
		*							2023-05-16		W. Poomarin				Build UI layout
		*							2023-05-19		W. Poomarin				Finish mode generator
		*							2023-05-21		W. Poomarin				Finish game mechanic
		*							2023-05-23		W. Poomarin				Finish first programming
		*							2023-05-25		W. Poomarin				Add commends
		*							2023-05-27		W. Poomarin				Add Method to display mode
		*							2023-05-28		W. Poomarin				Finish save/load file
		*							2023-05-29		W. Poomarin				Add References
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		String init = "";											// create init as a String to store player's initial
		init = textFieldPlayerNameInput.getText();					// call getText() to get player's input
		if (init.equals("") || init.length()>3) {					// if init is not "" and longer than 3 letters
			lblNote.setText("please enter your 3 initials");		// display text "please enter your 3 initials"
		} else {
			menuGUI = new GUIMenu(init);							// instantiate and create MenuGUI window
			dispose();												// close this window
		}
	}
}
