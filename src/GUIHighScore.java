import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIHighScore extends JFrame {
	private JFrame tableFrame;										// define tableFrame as a JFrame object for this window
	private JPanel contentPane;										// define contentPane as a JPanel for main content pane
	private JLabel lblGameOver;										// define lblGameOver as a JLabel
	private JLabel lblYourScore;									// define lblYourScore as a JLabel

	private DefaultListModel<String> loadData;						// define loadData as String DefaultListModel
	private ArrayList<String> names;								// define names as String ArrayList
	private ArrayList<Integer> scores;								// define scores as Integer ArrayList
	
	private JLabel[] topLists;										// define topLists as JLabel Array
	
	private Player player;											// define player as Player
	
	public GUIHighScore(Player InputPlayer) {							
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	HighScoreTable class constructor
		*
		* Method parameters		:	player - the method permits a Player object parameters to be entered
		*
		* Method return			:	HighScoreTable
		*
		* Synopsis				:	Constructor of the class HighScoreTable. Creates an instance of the HighScoreTable window frame. 
		* 								This class initializes and runs JFrame, contentPane, labels, 
		* 								to display Top High Score Player
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
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		tableFrame = new JFrame();							// instantiate menuFrame as JFrame
		loadData = new DefaultListModel<String>();			// instantiate loadData as String DefaultListModel
		topLists = new JLabel[5];							// instantiate topLists as JLabel for 5 elements
		names = new ArrayList<String>();					// instantiate names as String ArrayList
		scores = new ArrayList<Integer>();					// instantiate scores as Integer ArrayList
		player = InputPlayer;								// set player = InputPlayer;
		
		tableFrame.addWindowListener(new WindowAdapter() {	// add WindowListener to this window
			@Override
			public void windowOpened(WindowEvent e) {		// run this function when this window is opened

				loadFile();									// call loadFile() method to load file
				compareNewScoreToHighScore();				// call compareNewScoreToHighScore() method to find player position
				saveFileAndDisplay();						// call saveFileAndDisplay() method to update UI
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 450, 300);						// set position and size
		
		//----------contentPane------------//
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// tableFrame setup
		tableFrame.setBounds(640, 250, 720, 480);
		tableFrame.getContentPane().setLayout(null);
		tableFrame.setVisible(true);
		
		contentPane = new JPanel();										// contentPane setup
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tableFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblGameOver = new JLabel("GAME OVER!!");						// instantiate lblGameOver as JLabel
		lblGameOver.setForeground(Color.RED);							// set color to red
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);		// set Alignment to Center
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 16));			// set Font
		lblGameOver.setBounds(282, 24, 167, 28);						// set position and size
		contentPane.add(lblGameOver);									// add lblGameOver to contentPane
		
		lblYourScore = new JLabel("Your Score: " + player.getScore());	// instantiate lblYourScore as JLabel
		lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);		// set Alignment to Center
		lblYourScore.setFont(new Font("Tahoma", Font.BOLD, 14));		// set Font
		lblYourScore.setBounds(261, 72, 208, 16);						// set position and size
		contentPane.add(lblYourScore);									// add lblYourScore to contentPane
		
		topLists[0] = new JLabel("1. ");								// instantiate topLists[0] as JLabel
		topLists[0].setHorizontalAlignment(SwingConstants.LEFT);		// set Alignment to Left
		topLists[0].setFont(new Font("Tahoma", Font.BOLD, 14));			// set Font
		topLists[0].setBounds(300, 130, 208, 16);						// set position and size
		contentPane.add(topLists[0]);									// add topLists[0] to contentPane
		
		topLists[1] = new JLabel("2. ");								// instantiate topLists[1] as JLabel
		topLists[1].setHorizontalAlignment(SwingConstants.LEFT);		// set Alignment to Left
		topLists[1].setFont(new Font("Tahoma", Font.BOLD, 14));			// set Font
		topLists[1].setBounds(300, 180, 208, 16);						// set position and size
		contentPane.add(topLists[1]);									// add topLists[1] to contentPane
		
		topLists[2] = new JLabel("3.");									// instantiate topLists[2] as JLabel
		topLists[2].setHorizontalAlignment(SwingConstants.LEFT);		// set Alignment to Left
		topLists[2].setFont(new Font("Tahoma", Font.BOLD, 14));			// set Font
		topLists[2].setBounds(300, 230, 208, 16);						// set position and size
		contentPane.add(topLists[2]);									// add topLists[2] to contentPane
		
		topLists[3] = new JLabel("4.");									// instantiate topLists[3] as JLabel
		topLists[3].setHorizontalAlignment(SwingConstants.LEFT);		// set Alignment to Left
		topLists[3].setFont(new Font("Tahoma", Font.BOLD, 14));			// set Font
		topLists[3].setBounds(300, 280, 208, 16);						// set position and size
		contentPane.add(topLists[3]);									// add topLists[3] to contentPane
		
		topLists[4] = new JLabel("5.");									// instantiate topLists[4] as JLabel
		topLists[4].setHorizontalAlignment(SwingConstants.LEFT);		// set Alignment to Left
		topLists[4].setFont(new Font("Tahoma", Font.BOLD, 14));			// set Font
		topLists[4].setBounds(300, 330, 208, 16);						// set position and size
		contentPane.add(topLists[4]);									// add topLists[4] to contentPane

	}
	
	public void loadFile() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void loadFile
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method loads data and store in loadData
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
		
		String temp_string;														//define temp_string as a String
		try {
			FileReader inputFile = new FileReader("Save/HighScore.txt");		//define inputFile as a FileReader from "Save/HighScore.txt"
			BufferedReader bufferInputFile = new BufferedReader(inputFile);		//define bufferInputFile as a BufferedReader
			
			while ((temp_string = bufferInputFile.readLine()) != null) {		
				loadData.addElement(temp_string);								//add temp_string toloadData
			}
			
			bufferInputFile.close();											//close bufferInputFile
			inputFile.close();													//close inputFile

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Can't find or load the file");	//show "Can't find or load the file" on JOptionPane
		}
	}
	
	public void compareNewScoreToHighScore() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void compareNewScoreToHighScore
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method compare player's to the list of top 5 high score
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
		
		int splitIndex;																//define splitIndex as an integer
		boolean written;															//define written as a boolean
		String name;																//define name as a string
		int value;																	//define value as an integer
		written = false;															//set written = false
		
		for (int i = 0; i < 5; i++) {												
			splitIndex = loadData.get(i).indexOf(',');								//fine index of ','
			name = loadData.get(i).substring(0, splitIndex);						//set name = string in loadData.get(i) before ','
			value = Integer.parseInt(loadData.get(i).substring(splitIndex + 1));	//set value = the rest of the string
			names.add(name);														//add name to names array
			scores.add(value);														//add value to scores array
		}
		
		for (int i = 0; i < 5; i++) {												//from 0 to 4
			if (!written) {															//if written == false
				if (player.getScore() > scores.get(i)) {							//if player.getScore() > scores.get() at index i then
					names.add(i,player.getInit());									//add player's init to names at this index
					scores.add(i,player.getScore());								//add player's score to scores at this index
					written = true;													//set written = true
				}
			}
		}
	}
	
	public void saveFileAndDisplay() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void saveFileAndDisplay
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method saves data to "Save/HighScore.txt"
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
		
		try {
			FileWriter outputFile = new FileWriter("Save/HighScore.txt");					//define outputFile as a FileWriter from "Save/HighScore.txt"
			BufferedWriter bufferedOutputFile = new BufferedWriter(outputFile);				//define bufferedOutputFile as a BufferedWriter
			
			int position;																	//set position as an integer
			
			for (int i = 0; i < 5; i++) {													
				bufferedOutputFile.write(names.get(i)+","+scores.get(i));					//write name and score to file
				bufferedOutputFile.newLine();												
				position = i +1;															//set position = i+1
				topLists[i].setText(position+". "+names.get(i)+ "  ("+scores.get(i)+")");	//set topLists label to display top 5 list
			}

			bufferedOutputFile.close();														//close bufferedOutputFile
			outputFile.close();																//close outputFile
			
			
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Can't save file");							//display "Can't save file" when crash
		}
	}
}
