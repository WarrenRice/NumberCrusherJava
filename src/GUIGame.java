import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIGame extends JFrame{
	private JFrame gameFrame;			// define gameFrame as a JFrame object for this window
	private JPanel contentPane;			// define contentPane as a JPanel for main content pane

	private JButton btnOK;				// define btnOK as a JButton		
	
	private JLabel lblPlayerInfo;		// define lblPlayerInfo as a JLabel to display player's information
	private JLabel lblShowMax;			// define lblShowMax as a JLabel to display number range
	private JLabel lblLiveLabel;		// define lblLiveLabel as a JLabel to display in game labels
	private JLabel lblInputBox;			// define lblInputBox as a JLabel to display in game labels
	private JLabel lblResultLabel;		// define lblResultLabel as a JLabel to display in game labels
	private JLabel lblLastArrow0;		// define lblLastArrow0 as a JLabel to display in game labels
	private JLabel lblLastArrow1;		// define lblLastArrow1 as a JLabel to display in game labels
	private JLabel lblLastArrow2;		// define lblLastArrow2 as a JLabel to display in game labels
	private JLabel lblLastGuess1;		// define lblLastGuess1 as a JLabel to display in game labels
	private JLabel lblLastGuess2;		// define lblLastGuess2 as a JLabel to display in game labels
	private JLabel lblLastGuess0;		// define lblLastGuess0 as a JLabel to display in game labels
	private JLabel lblNote0;			// define lblNote0 as a JLabel to display information
	private JLabel lblNote1;			// define lblNote1 as a JLabel to display information
	private JLabel lblNote2;			// define lblNote2 as a JLabel to display information
	
	private ImageIcon tooHi;			// define tooHi as an ImageIcon to store assist arrow icon
	private ImageIcon tooLo;			// define tooLo as an ImageIcon to store assist arrow icon
	
	private ArrayList<Track> tracks;	// define tracks as an ArrayList<Track> array to store Track panels

	private int now_Level, now_Difficulty, now_Turn; 	// define now_Level, now_Difficulty, now_Turn as medium parameters
	
	private GUIHighScore highScoreTable;				// define highScoreTable as HighScoreTable object for the next window
	
	private JButton btnShowMode; 						// define btnShowMode as a JButton
	private Player player;								// define player as Player
	private DefaultListModel<String> loadData;			// create loadData as DefaultListModel<String> array to store data from loaded file
	private Payload payload;							// define payload as Payload
	
	public GUIGame(Player inputPlayer, Payload inputPayload) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	GameGUI class constructor
		*
		* Method parameters		:	player - the method permits a Player object parameters to be entered
		*
		* Method return			:	GameGUI
		*
		* Synopsis				:	Constructor of the class GameGUI. Creates an instance of the GameGUI window frame. 
		* 								This class initializes and runs JFrame, contentPane, buttons, labels, 
		* 								run game mechanics, save file when window is closed and create HighScoreTable 
		* 								window when game ends.
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
		
		player = inputPlayer;													// set player object = inputPlayer
		payload = inputPayload;													// set payload object = inputPayload
		gameFrame = new JFrame();												// instantiate gameFrame as JFrame
		gameFrame.addWindowListener(new WindowAdapter() {						// add WindowListener to this window			
			@Override
			public void windowClosing(WindowEvent e) {							// run this function when this window is closing
				editData();														// call editData() to update and save file
			}
		});

																				//set player = inputPlayer
		now_Level = player.getLevel();											//set now_Level = player's Level
		now_Difficulty = player.getDifficulty();								//set now_Difficulty = player's Difficulty
		now_Turn = player.getTurn();											//set now_Turn = player.getTurn()
		loadData = new DefaultListModel<String>();								//instantiate loadData asDefaultListModel<String> array to store data from loaded file
		
		tooHi = new ImageIcon("Image/arrowUp.png");								//instantiate tooHi as ImageIcon at image path "Image/arrowUp.png"
		tooLo = new ImageIcon("Image/arrowDown.png");							//instantiate tooLo as ImageIcon at image path "Image/arrowDown.png"
		
		//-----------gameFrame-------------//
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// gameFrame setup
		gameFrame.setTitle("Number Cruncher");									
		gameFrame.setBounds(640, 250, 960, 720);								
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setVisible(true);
		
		//----------contentPane------------//
		contentPane = new JPanel();												// contentPane setup
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		gameFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		

		initializeLabels();														//call initializeLabels() to initialize and display UI
		initializeTracks();														//call initializeTracks() to initialize and display tracks

		
		btnOK = new JButton("OK");												//instantiate btnOK as an JButton set label to "OK"
		btnOK.setBounds(43, 558, 75, 25);										//set position and size
		btnOK.addActionListener(new ActionListener() {							
			public void actionPerformed(ActionEvent e) {						//call methods when this button is clicked
				
				getPlayerInputs();												//call getPlayerInputs() to get player inputs
				checkGameOver();												//call checkGameOver() to check if game is over

				if (allPass(player.getPasses())) {								//check if every guesses are correct
					JOptionPane.showMessageDialog(null,player.updateScore());	//display player update new score
					
					levelUP();													//call levelUP() to update player's data members
					resetRound();												//call resetRound() to reset UI and variables
				}

			}
		});
		contentPane.add(btnOK);													//add btnOK to contentPane 
		
	}
	

	public boolean allPass(ArrayList<StateCorrect> inputPasses) {						
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	boolean allPass
		*
		* Method parameters		:	inputPasses - the method permits a Boolean array parameters to be entered
		*
		* Method return			:	boolean
		*
		* Synopsis				:	This method will check if player's guesses are all correct or not
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
		
		for (int i = 0; i < inputPasses.size(); i++) {								//go through every elements in input array
			if (inputPasses.get(i) == StateCorrect.WRONG) {												//if found some guesses are incorrect then
				return false;														//then return false
			}
		}
		return true;																//return true
	}
	
	public boolean gameOver(ArrayList<Integer> inputLives) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	boolean gameOver
		*
		* Method parameters		:	inputLives - the method permits an Integer array parameters to be entered
		*
		* Method return			:	boolean
		*
		* Synopsis				:	This method will check if player's lives is below 0 or not
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
		
		for (int i = 0; i < inputLives.size(); i++) {								//go through every elements in input array
			if (inputLives.get(i) < 0) {											//if found some lives is below 0
				return true;														//then return true
			}
		}
		return false;																//return false
	}

	public void onoffAllTracks(ArrayList<Track> inputTracks, StateMachine onoff) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void onoffAllTracks
		*
		* Method parameters		:	inputTracks, onoff - the method permits a Track array parameters, and a MachineState to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method will enable or disable every Tracks
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
		
		for (int i = 0; i< inputTracks.size(); i++) {								//go through every elements in input array
			inputTracks.get(i).setEnableTrack(onoff);								//set enable or disable
		}
	}
	
	public void getPlayerInputs() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getPlayerInputs
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method gets player guessing inputs and check if the input is correct
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
		
		for (int i =0; i < player.getTrackNumbers(); i++) {				//run trough all tracks
			boolean result;												//create result as a StateCorrect
			tracks.get(i).enterInput(player.getMax());					//get player input and check if input is in range from 0 to maximum of each level
			
			result = tracks.get(i).checkInput();						//result = true when guess is correct
			
			if (result) {												//if this track is correct
				tracks.get(i).setEnableTrack(StateMachine.OFF);			//disable this track
				tracks.get(i).showCorrectionLogo(StateCorrect.RIGHT);	//display correct icon
				player.setPass(i, StateCorrect.RIGHT);
			} else {													//if this track is wrong
				player.deductOneLive(i);								//deduct this track's live by 1
				tracks.get(i).cleanInputBox();							//clear textField
				tracks.get(i).showCorrectionLogo(StateCorrect.WRONG);	//display wrong icon
				player.setPass(i, StateCorrect.WRONG);
				
				tracks.get(i).addRecord();								//record input
				tracks.get(i).showRecord(now_Turn);						//show record of this turn
			}
			
																		//set player passes[i] to true if guess is correct and false if guess is wrong
			tracks.get(i).setLivesDisplay(player.getLives().get(i));	//update lives on track on UI
		}				
		now_Turn = now_Turn + 1;										//set now_Turn = now_Turn + 1
		player.setTurn(now_Turn);
	}
	
	public void checkGameOver() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void checkGameOver
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method checks if game is over or not. If the game is over, it will create HighScoreTable window
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
		
		if (gameOver(player.getLives())) {								//check if game is over when one of lives below 0
			for (int i =0; i < player.getTrackNumbers(); i++) {			//run trough all tracks
				tracks.get(i).setEnableTrack(StateMachine.OFF);			//disable all tracks
												
			}
			btnOK.setEnabled(false);									//disable btnOK button
			highScoreTable = new GUIHighScore(player);					//instantiate highScoreTable frame as HighScoreTable object to display high score
			removeData();												//call removeData() to remove data from save file
			gameFrame.dispose();										//close this window
		}
	}
	
	
	public void levelUP() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void levelUP
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method level UP player's level, difficulty and update data members
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
		
		player.plusAllLives();										//add lives to remaining lives
		now_Level++;												//set now_Level = now_Level + 1
		
		if (now_Level == 10) {										//if now_Level == 10 then					
			now_Difficulty++;										//go to next difficulty
			now_Level = 1;											//set now_Level back to 1
			if (now_Difficulty < 4) {								
				player.setTrackNumbers();							//add new tracks to UI
				player.addNewLives(now_Difficulty, 2);				//update new lives to new tracks UI
			} else {												//finish the game
				btnOK.setEnabled(false);							//disable btnOK button
				highScoreTable = new GUIHighScore(player);			//instantiate highScoreTable frame as HighScoreTable object to display high score
				removeData();										//call removeData() to remove data from save file
				gameFrame.dispose();								//close this window
			}

		}
		
		player.setDifficultyLevel(now_Difficulty, now_Level);		//update player's data members
	}
	
	public void resetRound() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void resetRound
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method resets UI and variables
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
		
		onoffAllTracks(tracks,StateMachine.ON);							//enable all tracks
		for (int i =0; i < player.getTrackNumbers(); i++) {				//run through every tracks
			tracks.get(i).setVisible(true);								//display every tracks
			tracks.get(i).genNewAnswer(player.getMax());				//generate new set for random numbers
			tracks.get(i).setNowInputInt(-1);							//set default inputs
			player.setPass(i, StateCorrect.WRONG);
			tracks.get(i).setLivesDisplay(player.getLives().get(i));	//update track displays
			tracks.get(i).cleanInputBox();								//clear input box
			tracks.get(i).clearRecord();								//clear input record
		}
		now_Turn = 0;													//set now_Turn back to 0
		player.setTurn(now_Turn); 						
		now_Level = player.getLevel();									//set now_Leve = player's level
		now_Difficulty = player.getDifficulty();						//set now_Difficulty = player's difficulty
		lblShowMax.setText("Guess Number from 1 to " + player.getMax());						//update UI to show valid input number
		lblPlayerInfo.setText("Player: " + player.getInit() + " Difficulty: " + 				//update UI to show player's Initial, Difficulty, Level and Score
				now_Difficulty + " Level: " + now_Level + " Score: " + player.getScore());
	}
	

	
	public void loadData() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void loadData
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method loads data and store in loadData
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
	
	public void saveData() {

		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void saveData
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method save data to file
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
		
		try {																			//try

			FileWriter outputFile = new FileWriter("Save/Save.txt");					// create and instantiate outputFile as a FileWriter at path "Save/Save.txt"
			BufferedWriter bufferedOutputFile = new BufferedWriter(outputFile);			// create and instantiate bufferedOutputFile as a BufferedWriter
			
			for (int i = 0; i < loadData.size(); i++) {									// write loadData to file 
				bufferedOutputFile.write(loadData.get(i));
				bufferedOutputFile.newLine();
			}

			bufferedOutputFile.close();													// close bufferedOutputFile
			outputFile.close();															// close outputFile

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Can't save the file");					// show "Can't save the file" on JOptionPane 
		}
		
	}
	
	public void editData() {

		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void editData
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method edits data before saving file
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
		
		loadData();																//call loadData()
		
		String savingDate;														//define savingDate as a String
		savingDate = player.prepareSaveData();									//set savingDate = player's prepareSaveData() as a string
		savingDate = savingDate + "/";											//add "/" to savingDate
		for (int i =0; i < player.getTrackNumbers(); i++) {						//add answers to savingDate
			savingDate = savingDate + tracks.get(i).getAnswer();				
			if (i < player.getTrackNumbers()-1) {								
				savingDate = savingDate + ",";									//separate them with ','
			}
		}
		savingDate = savingDate + "/";											//add "/" to savingDate
		
		for (int i = 0; i < player.getTrackNumbers(); i++) {					
			savingDate = savingDate + tracks.get(i).getRecords();				//add records array of each tracks to savingDate
			
			if (i < player.getTrackNumbers()-1) {								
				savingDate = savingDate + "!";									//separate them with '!'
			}
		}
		
		if (player.getSaveIndex() == -1) {										//use new save add new line
			
			loadData.addElement(savingDate);									//add new data to loadData

		} else {																//use old save overwrite old data
					
			loadData.set(player.getSaveIndex(),savingDate);						//edit new data to loadData

		}
		
		saveData();																//call saveData()
		JOptionPane.showMessageDialog(null, "Save game while closing");			//show "Save game while closing" on JOptionPane
	}
	
	
	public void removeData() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void removeData
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method remove data when game is over
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
		
		loadData(); 															//call loadData()
		
		if (player.getSaveIndex() != -1) {										//if is old player
			loadData.remove(player.getSaveIndex());								//remove player's data at saveIndex from loadData
		}

		saveData();																//call saveData()

	}
	
	public void initializeTracks() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void initializeTracks
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method initialize tracks on the UI
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
		*							2023-05-30		W. Poomarin				Fix bugs when loaded the game generate new random numbers
		*							2023-05-31		W. Poomarin				Fix save and load previous player's state
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		tracks = new ArrayList<Track>();										// instantiate tracks as ArrayList<Track> array
		int i;
		for (i = 0; i < 7;i++) {												// for i = 0 to t = 6
			tracks.add(new Track(i, 150+110*i));								// instantiate and add tracks to contentPane
			contentPane.add(tracks.get(i));										// add tracks to contentPane
			
			if (i < player.getTrackNumbers()) {
				tracks.get(i).setLivesDisplay(player.getLives().get(i));		//update lives
				tracks.get(i).genNewAnswer(player.getMax());					//generate the first set for random numbers
			} else {
				tracks.get(i).setVisible(false);								//setVisible(false) unused tracks
			}
		}
		
		//load and update track
		if (payload.getLoaded()) {												//if player chooses to resume the game
			for (i = 0; i < player.getTrackNumbers();i++) {						//go through every tracks
				//load answers
				tracks.get(i).setAnswer(payload.getAnswers().get(i));			//update tracks' answer according the save data
				//load passes and show results
				if(player.getPass(i) == StateCorrect.RIGHT) {					//if player has already passed this track then
					tracks.get(i).setInputBox(payload.getAnswers().get(i));		//display correct answer
					tracks.get(i).setEnableTrack(StateMachine.OFF);				//disable track
					tracks.get(i).showCorrectionLogo(StateCorrect.RIGHT);		//display RIGHT icon
				} else {														//else 
					tracks.get(i).showCorrectionLogo(StateCorrect.WRONG);		//display WRONG icon
				}
				//load records and show records
				tracks.get(i).loadRecords(payload.getRecords().get(i));			//load old records to tracks
				
				if (tracks.get(i).getRecords().size() == 0) {
					tracks.get(i).showCorrectionLogo(StateCorrect.NONE);		//display NONE icon
				}
				
				tracks.get(i).initRecord();										//display previous records

			}
		}
	}
	
	
	public void printModeNumbers() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void printModeNumbers
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method is meant for debugging to show the generated mode numbers
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		int index;														//define index as integer
		System.out.println("\n---Mode Numbers---");						//display text 
		for (index = 0; index < player.getTrackNumbers(); index++) {	//display the generated mode numbers 
			System.out.print(tracks.get(index).getAnswer() + " ");
		}
		System.out.println("\n------------------");						//display text
	}
	
	
	public void initializeLabels() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void initializeLabels
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method initialize and display UI layout and labels
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
		*							2023-05-30		W. Poomarin				Fix bugs when loaded the game generate new random numbers
		*							2023-05-31		W. Poomarin				Fix save and load previous player's state
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		lblPlayerInfo = new JLabel("Player: " + player.getInit() + " Difficulty: " + 
				player.getDifficulty() + " Level: " + player.getLevel() + 
				" Score: " + player.getScore());								// instantiate lblPlayerInfo as JLabel to display player's information
		lblPlayerInfo.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblPlayerInfo.setBounds(10, 11, 732, 23);								// set position and size
		contentPane.add(lblPlayerInfo);											// add lblPlayerInfo to contentPane

		lblShowMax = new JLabel("Guess Number from 1 to " + player.getMax());;	// instantiate lblShowMax as JLabel to display number range
		lblShowMax.setFont(new Font("Tahoma", Font.BOLD, 12));					// set font
		lblShowMax.setBounds(10, 45, 234, 14);									// set position and size
		contentPane.add(lblShowMax);											// add lblShowMax to contentPane
		
		lblLiveLabel = new JLabel("Lives:");									// instantiate lblLiveLabel as JLabel to display game information
		lblLiveLabel.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLiveLabel.setBounds(10, 137, 75, 14);								// set position and size
		contentPane.add(lblLiveLabel);											// add to contentPane
		
		lblInputBox = new JLabel("Enter Number:");								// instantiate lblInputBox as JLabel to display game information
		lblInputBox.setFont(new Font("Tahoma", Font.BOLD, 12));					// set font
		lblInputBox.setBounds(10, 178, 88, 14);									// set position and size
		contentPane.add(lblInputBox);											// add to contentPane
		
		lblResultLabel = new JLabel("Results:");								// instantiate lblResultLabel as JLabel to display game information
		lblResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblResultLabel.setBounds(10, 218, 88, 14);								// set position and size
		contentPane.add(lblResultLabel);										// add to contentPane
		
		lblLastArrow0 = new JLabel("Last Assist Arrow");						// instantiate lblLastArrow0 as JLabel to display game information
		lblLastArrow0.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastArrow0.setBounds(10, 310, 108, 14);								// set position and size
		contentPane.add(lblLastArrow0);											// add to contentPane
		
		lblLastArrow1 = new JLabel("Previous Assist Arrow#1");					// instantiate lblLastArrow1 as JLabel to display game information
		lblLastArrow1.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastArrow1.setBounds(10, 415, 168, 14);								// set position and size
		contentPane.add(lblLastArrow1);											// add to contentPane
		
		lblLastArrow2 = new JLabel("Previous Assist Arrow#2");					// instantiate lblLastArrow2 as JLabel to display game information
		lblLastArrow2.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastArrow2.setBounds(11, 515, 167, 14);								// set position and size
		contentPane.add(lblLastArrow2);											// add to contentPane
		
		lblLastGuess0 = new JLabel("Last Guess:");								// instantiate lblLastGuess0 as JLabel to display game information
		lblLastGuess0.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastGuess0.setBounds(10, 260, 88, 14);								// set position and size
		contentPane.add(lblLastGuess0);											// add to contentPane
		
		lblLastGuess1 = new JLabel("Previous Guess#1:");						// instantiate lblLastGuess1 as JLabel to display game information
		lblLastGuess1.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastGuess1.setBounds(10, 365, 147, 14);								// set position and size
		contentPane.add(lblLastGuess1);											// add to contentPane
		
		lblLastGuess2 = new JLabel("Previous Guess:#2");						// instantiate lblLastGuess2 as JLabel to display game information
		lblLastGuess2.setFont(new Font("Tahoma", Font.BOLD, 12));				// set font
		lblLastGuess2.setBounds(11, 465, 146, 14);								// set position and size
		contentPane.add(lblLastGuess2);											// add to contentPane
		
		lblNote0 = new JLabel("Note:");											// instantiate lblLiveLabel as JLabel to display game information
		lblNote0.setFont(new Font("Tahoma", Font.BOLD, 12));					// set font
		lblNote0.setBounds(10, 638, 49, 32);									// set position and size
		contentPane.add(lblNote0);												// add to contentPane
		
		lblNote1 = new JLabel("UP Arrow mean the guess is too high and");		// instantiate lblLiveLabel as JLabel to display game information
		lblNote1.setIcon(tooHi);												// add icon tooHi
		lblNote1.setFont(new Font("Tahoma", Font.PLAIN, 12));					// set font
		lblNote1.setBounds(46, 638, 272, 32);									// set position and size
		contentPane.add(lblNote1);												// add to contentPane
		
		lblNote2 = new JLabel("DOWN Arrow mean the guess is too low.");			// instantiate lblLiveLabel as JLabel to display game information
		lblNote2.setIcon(tooLo);												// add icon tooLo
		lblNote2.setFont(new Font("Tahoma", Font.PLAIN, 12));					// set font
		lblNote2.setBounds(317, 638, 321, 32);									// set position and size
		contentPane.add(lblNote2);												// add to contentPane
	}
}