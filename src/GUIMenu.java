import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIMenu extends JFrame{
	private JFrame menuFrame;			// define menuFrame as a JFrame object for this window
	private JPanel contentPane;			// define contentPane as a JPanel for main content pane
	
	private JButton btnEasy;			// define btnEasy as a JButton to go to Easy mode
	private JButton btnModerate;		// define btnNormal as a JButton to go to Normal mode
	private JButton btnDifficult;		// define btnHard as a JButton to go to Hard mode
	private JButton btnResume;			// define btnResume as a JButton to go to Resume the game
	
	private JLabel lblWelcome;			// define lblWelcome as a JLabel to display text
	private JLabel lblOr;				// define lblOr as a JLabel to display text

	private GUIGame gameGUI;			// define gameGUI as GameGUI object for the next window
	
	private Player player;						// create player as Player object to store player's data
	private DefaultListModel<String> loadData;	// create loadData as DefaultListModel<String> array to store data from loaded file
	private JLabel lblLoaded;					// create lblLoaded as JLabel to display information text
	private JLabel lblLoadedName;				// create lblLoadedName as JLabel to display information text
	private JLabel lblSelectDiffidulty;			// create lblSelectDiffidulty as JLabel to display information text
	
	private int oldIndex;				// define oldIndex as an integer
	private Payload payload;			// define payload as a Payload object to store records data

	public GUIMenu(String init) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	MenuGUI class constructor
		*
		* Method parameters		:	init - the method permits a String parameters to be entered
		*
		* Method return			:	MenuGUI
		*
		* Synopsis				:	Constructor of the class MenuGUI. Creates an instance of the MenuGUI window frame. 
		* 								This class initializes and runs JFrame, contentPane, buttons, labels, 
		* 								load file, player and create GameGUI window.
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
		
		//-----------menuFrame-------------//
		menuFrame = new JFrame();					// instantiate menuFrame as JFrame
		contentPane = new JPanel();					// instantiate contentPane as JPanel
		player = new Player();						// instantiate player as Player to store player's data
		loadData = new DefaultListModel<String>();	// instantiate loadData asDefaultListModel<String> array to store data from loaded file
		oldIndex = -1;								// set oldIndex = -1 as default
		payload = new Payload();					// instantiate payload as Payload
		
		menuFrame.addWindowListener(new WindowAdapter() {	// add WindowListener to this window
			@Override
			public void windowOpened(WindowEvent e) {		// run this function when this window is opened
				
				loadFile();									// call loadFile() method to load file
				checkOldPlayer(init);						// call checkOldPlayer(init) method if players initial is already exist
				displayMenu();								// call displayMenu() method update UI

			}
		});
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);									// menuFrame setup
		menuFrame.setTitle("Number Cruncher");
		menuFrame.setBounds(640, 250, 768, 512);
		menuFrame.getContentPane().setLayout(null);
		menuFrame.setVisible(true);
		
		//----------contentPane------------//
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));											// contentPane setup
		menuFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
											//------------------buttons-----------------//
		//---------btnEasy-----------------//
		btnEasy = new JButton("Easy");																// instantiate btnEasy labeled "Easy"
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 12));											// set font
		btnEasy.setBounds(336, 107, 114, 32);														// set position and size
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {											// call goNext method when is clicked
				goNext(init, 1);
			}
		});
		contentPane.add(btnEasy);																	// add btnEasy to contentPane
		//---------btnNormal---------------//
		btnModerate = new JButton("Moderate");														// instantiate btnEasy labeled "Normal"
		btnModerate.setFont(new Font("Tahoma", Font.BOLD, 12));										// set font
		btnModerate.setBounds(336, 153, 114, 32);													// set position and size
		btnModerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {											// call goNext method when is clicked
				goNext(init, 2);
			}
		});
		contentPane.add(btnModerate);																// add btnNormal to contentPane
		//---------btnHard-----------------//
		btnDifficult = new JButton("Difficult");															// instantiate btnEasy labeled "Hard"
		btnDifficult.setFont(new Font("Tahoma", Font.BOLD, 12));									// set font
		btnDifficult.setBounds(336, 203, 114, 32);													// set position and size
		btnDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {											// call goNext method when is clicked
				goNext(init, 3);
			}
		});
		contentPane.add(btnDifficult);																// add btnHard to contentPane
		//---------btnResume---------------//
		btnResume = new JButton("Resume");															// instantiate btnEasy labeled "Hard"
		btnResume.setFont(new Font("Tahoma", Font.BOLD, 12));										// set font
		btnResume.setBounds(336, 306, 114, 32);														// set position and size
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {											// call this function when is click
				payload.setLoaded(true);															// set payload.loaded = true
				gameGUI = new GUIGame(player, payload);												// instantiate new gameGUI as new GameGUI window 
				menuFrame.dispose();																// close this window
			}
		});
		btnResume.setEnabled(false);																// disable btnResume button
		contentPane.add(btnResume);																	// add btnResume to contentPane		
										   //------------------labels-----------------//
		lblWelcome = new JLabel("Welcome " + init);													// instantiate lblWelcome as JLabel to display text "Welcome " + player's initials
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));										// set font
		lblWelcome.setBounds(57, 37, 182, 14);														// set position and size							
		contentPane.add(lblWelcome);																// add lblWelcome to contentPane
		
		lblOr = new JLabel("or");																	// instantiate lblOr as JLabel to display text "or"
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);										// set text to center
		lblOr.setBounds(370, 259, 46, 14);															// set position and size
		contentPane.add(lblOr);																		// add lblOr to contentPane
		
		lblLoaded = new JLabel("");																	// instantiate lblLoaded as JLabel to display text ""
		lblLoaded.setHorizontalAlignment(SwingConstants.CENTER);									// set text to center
		lblLoaded.setBounds(133, 390, 508, 23);														// set position and size
		contentPane.add(lblLoaded);																	// add lblLoaded to contentPane
		
		lblLoadedName = new JLabel("");																// instantiate lblLoadedName as JLabel to display text ""
		lblLoadedName.setHorizontalAlignment(SwingConstants.CENTER);								// set text to center
		lblLoadedName.setBounds(133, 360, 508, 23);													// set position and size
		contentPane.add(lblLoadedName);																// add lblLoadedName to contentPane
		
		lblSelectDiffidulty = new JLabel("Select Difficulty");										// instantiate lblSelectDiffidulty as JLabel to display text "Select Difficulty"
		lblSelectDiffidulty.setHorizontalAlignment(SwingConstants.CENTER);							// set text to center
		lblSelectDiffidulty.setFont(new Font("Tahoma", Font.BOLD, 12));								// set font
		lblSelectDiffidulty.setBounds(336, 74, 114, 14);											// set position and size
		contentPane.add(lblSelectDiffidulty);														// add lblSelectDiffidulty to contentPane
	}
	
	
	public void goNext(String init, int chosenDifficulty) {											
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void goNext
		*
		* Method parameters		:	input - the method permits a String and an integer parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method instantiate and setup new Player object for the chosen object then move
		* 								player to next window.
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		player = new Player();																		// instantiate player as new Player
		payload = new Payload();																	// instantiate payload as new Payload
		player.setInit(init);																		// call setInit to set player's initials
		player.setSaveIndex(oldIndex);																// set player's saveIndex
		player.setDifficultyLevel(chosenDifficulty,1);												// set difficulty and level
		player.addNewLives(chosenDifficulty, player.getTrackNumbers());								// set player's lives
		gameGUI = new GUIGame(player, payload);														// instantiate gameGUI as new GameGUI window 
		menuFrame.dispose();																		// close this window 
	}
	
	public void loadFile() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void loadFile
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method loads data from Save/Save.txt file and store in loadData 
		*  
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
		
		String temp_string;														// create temp_string as a String
		try {
			FileReader inputFile = new FileReader("Save/Save.txt");				// create and instantiate inputFile as a FileReader at path "Save/Save.txt"
			BufferedReader bufferInputFile = new BufferedReader(inputFile);		// create and instantiate bufferInputFile as a BufferedReader 
			
			while ( (temp_string = bufferInputFile.readLine()) != null) {		// when file is read
				loadData.addElement(temp_string);								// add data to loadData array
			}
			
			bufferInputFile.close();											// close bufferInputFile
			inputFile.close();													// close file

		} catch (Exception err) {												// show this JOptionPane
			JOptionPane.showMessageDialog(null, "File is not loaded");			// when can't load the file
		}
	}
	
	public void checkOldPlayer(String inputString) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void checkOldPlayer
		*
		* Method parameters		:	inputString - the method permits a String and a string parameters to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method checks if player's initials is already exist if so update player's data members 
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		player.setInit(inputString);									//set player initial = inputString
		
		int splitIndex;													//define splitIndex as an integer
		int index;														//define index as an integer
		String name = "";												//define name as a String
		
		for (index = 0; index < loadData.size(); index++) {						//go through every loaded data via 'index' variable
			//get name of each line in loadData
			splitIndex = loadData.get(index).indexOf(',');						//fine ',' index and store in splitIndex
			name = loadData.get(index).substring(0, splitIndex);				//name = String from the first index to splitIndex
			
			if (inputString.equals(name)) {										//if inputString == name
				//capture index
				player.setSaveIndex(index);										//set player's saveIndex = index
				oldIndex = index;												//set oldIndex = index
				//split by '/'
				String[] rawDataArray = new String[5];							//define and instantiate rawDataArray as a String array with 5 set of elements
																				//change this number when save file structure is changed
				rawDataArray = loadData.get(index).split("/");					//set rawDataArray = 
				
				//load player data and turn
				String[] loadedArray = new String[11];							//define and instantiate loadedArray as a String array with 10 set of elements
																				//for player's init, score, level, difficulty, lives
				loadedArray = rawDataArray[0].split(",");						//set loadedArray = rawDataArray[0] data when it is splited by ','
				player.loadedData(loadedArray);									//update player's data member to loadedArray
				player.setTurn(Integer.parseInt(rawDataArray[1]));				//set player's turn = rawDataArray[1]
				
				//load passes
				String[] tempArray = new String[player.getTrackNumbers()];		//define and instantiate tempArray as a String array with size of player's trackNumber
				tempArray = rawDataArray[2].split(",");							//set tempArray = rawDataArray[2] data when it is splited by ','
				for (int i = 0; i< tempArray.length; i++) {						//go through every elements in tempArray
					if (tempArray[i].equals("1")) {								//if tempArray[i] == 1 then
						player.setPass(i, StateCorrect.RIGHT);					//display Right icon
					} else {													//else
						player.setPass(i, StateCorrect.WRONG);					//display Wrong icon
					}
				}
				
				//load array
				tempArray = rawDataArray[3].split(",");							//set tempArray = rawDataArray[3] data when it is splited by ','
				for (int i = 0; i< tempArray.length; i++) {						//go through every elements in tempArray
					payload.addToAnswers(tempArray[i]);							//add elements to payload's answers
				}
				
				//load records
				tempArray = rawDataArray[4].split("!");							//set tempArray = rawDataArray[4] data when it is splited by ','
				for (int i = 0; i< tempArray.length; i++) {						//go through every elements in tempArray
					payload.addToRecords(tempArray[i]);							//add elements to payload's records
				}
				
				//prepare record data
				payload.prepareRecordData();									//edit and prepare payload data to be used

				break;															//break out the loop
			}
			
		}
		
	}
	
	public void displayMenu() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void displayMenu
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method display UI
		*  
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
		
		if (player.getSaveIndex() == -1) {
			lblWelcome.setText("Welcome " + player.getInit());							// display "Welcome " + player's initials
			btnResume.setEnabled(false);												// enable btnResume button
		} else {
			lblWelcome.setText("Welcome back!!! " + player.getInit());					// display "Welcome " + player's initials
			btnResume.setEnabled(true);													// enable btnResume button
			lblLoadedName.setText("( Continue )");										// set and display player's information
			lblLoaded.setText("( Score: " + player.getScore() + " Difficulty: " + 		
			player.getDifficulty() + " Level: " + player.getLevel()+")");	
		}
	}
}
