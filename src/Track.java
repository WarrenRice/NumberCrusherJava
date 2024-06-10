import javax.swing.ImageIcon;							//import the library
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Track extends JPanel{						//create Player Track extends from JPanel
	
	private ImageIcon rightIcon;						//define rightIcon as ImageIcon
	private ImageIcon wrongIcon;						//define wrongIcon as ImageIcon
	private ImageIcon tooHi;							//define tooHi as ImageIcon									
	private ImageIcon tooLo;							//define tooLo as ImageIcon

	private JTextField textField;						//define textField as JTextField
	private JLabel lblTrackNumber;						//define lblTrackNumber as JLabel
	private JLabel lblLives;							//define lblLives as JLabel
	private JLabel lblResultIcon;						//define lblResultIcon as JLabel
	
	private String nowInputString;						//define nowInputString as String
	private int nowInputInt;							//define nowInputInt as integer
	private int answer;									//define answer as integer
	private int id;										//define id as integer
	
	private ArrayList<Integer> records;					//define records as Integer ArrayList
	
	private JLabel lblPreviousNumber0;					//define lblPreviousNumber0 as JLabel
	private JLabel lblPreviousSign0;					//define lblPreviousSign0 as JLabel
	private JLabel lblPreviousNumber1;					//define lblPreviousNumber1 as JLabel
	private JLabel lblPreviousSign1;					//define lblPreviousSign1 as JLabel
	private JLabel lblPreviousNumber2;					//define lblPreviousNumber2 as JLabel
	private JLabel lblPreviousSign2;					//define lblPreviousSign2 as JLabel
	
	public Track(int inputId, int x) {					//create Track constructor method
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Track class constructor
		*
		* Method parameters		:	inputId, x - the method permits integer parameters to be entered
		*
		* Method return			:	Track
		*
		* Synopsis				:	This method creates Track object with initial data members and set position of the tracks
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
		*							2023-06-06		W. Poomarin				Fix bugs when the show X marks load empty records
		*
		** =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */
		
		this.rightIcon = new ImageIcon("Image/right.png");		//instantiate rightIcon	= ImageIcon("Image/right.png")
		this.wrongIcon = new ImageIcon("Image/wrong.png");		//instantiate wrongIcon	= ImageIcon("Image/wrong.png")
		this.tooHi = new ImageIcon("Image/arrowUp.png");		//instantiate tooHi	= ImageIcon("Image/arrowUp.png")			
		this.tooLo = new ImageIcon("Image/arrowDown.png");		//instantiate tooLo	= ImageIcon("Image/arrowDown.png")
		
		this.id = inputId;										//set id = inputId
		this.nowInputInt = -1;									//set nowInputInt = -1
		this.nowInputString = "";								//set nowInputString = ""
		this.clearRecord();										//call clearRecord() to clear records array
		
		this.setBounds(x, 80, 120, 495);						//set Track position and size
		this.setLayout(null);									//set setLayout(null)
		setVisible(true);										//show track
		
		lblTrackNumber = new JLabel("Track" + (id + 1));						//instantiate lblTrackNumber as JLabel
		lblTrackNumber.setFont(new Font("Tahoma", Font.BOLD, 12));				//set font
		lblTrackNumber.setBounds(36, 21, 46, 14);								//set position and size
		add(lblTrackNumber);													//add to Track
		
		lblLives = new JLabel("-1");											//instantiate lblLives as JLabel
		lblLives.setFont(new Font("Tahoma", Font.BOLD, 12));					//set font
		lblLives.setHorizontalAlignment(SwingConstants.CENTER);					//set Alignment to Center
		lblLives.setBounds(36, 60, 46, 14);										//set position and size
		add(lblLives);															//add to Track
		
		textField = new JTextField();											//instantiate textField as JLabel
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));					//set font
		textField.setBounds(27, 97, 64, 20);									//set position and size
		add(textField);															//add to Track
		textField.setColumns(10);
		
		lblResultIcon = new JLabel("");											//instantiate lblResultIcon as JLabel
		lblResultIcon.setIcon(null);											//set icon
		lblResultIcon.setHorizontalAlignment(SwingConstants.CENTER);			//set Alignment to Center
		lblResultIcon.setBounds(41, 128, 36, 36);								//set position and size
		add(lblResultIcon);														//add to Track
		
		lblPreviousNumber0 = new JLabel("");									//instantiate lblPreviousNumber0 as JLabel
		lblPreviousNumber0.setHorizontalAlignment(SwingConstants.CENTER);		//set Alignment to Center
		lblPreviousNumber0.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousNumber0.setBounds(10, 175, 100, 32);							//set position and size
		add(lblPreviousNumber0);												//add to Track
		
		lblPreviousSign0 = new JLabel("");										//instantiate lblPreviousSign0 as JLabel
		lblPreviousSign0.setHorizontalAlignment(SwingConstants.CENTER);			//set Alignment to Center
		lblPreviousSign0.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousSign0.setBounds(43, 225, 32, 32);							//set position and size
		add(lblPreviousSign0);													//add to Track
		
		lblPreviousNumber1 = new JLabel("");									//instantiate lblPreviousNumber1 as JLabel
		lblPreviousNumber1.setHorizontalAlignment(SwingConstants.CENTER);		//set Alignment to Center
		lblPreviousNumber1.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousNumber1.setBounds(10, 275, 100, 32);							//set position and size
		add(lblPreviousNumber1);												//add to Track
		
		lblPreviousSign1 = new JLabel("");										//instantiate lblPreviousSign1 as JLabel
		lblPreviousSign1.setHorizontalAlignment(SwingConstants.CENTER);			//set Alignment to Center
		lblPreviousSign1.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousSign1.setBounds(43, 325, 32, 32);							//set position and size
		add(lblPreviousSign1);													//add to Track
		
		lblPreviousNumber2 = new JLabel("");									//instantiate lblPreviousNumber2 as JLabel
		lblPreviousNumber2.setHorizontalAlignment(SwingConstants.CENTER);		//set Alignment to Center
		lblPreviousNumber2.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousNumber2.setBounds(10, 375, 100, 32);							//set position and size
		add(lblPreviousNumber2);												//add to Track
		
		lblPreviousSign2 = new JLabel("");										//instantiate lblPreviousSign2 as JLabel
		lblPreviousSign2.setHorizontalAlignment(SwingConstants.CENTER);			//set Alignment to Center
		lblPreviousSign2.setFont(new Font("Tahoma", Font.BOLD, 12));			//set font
		lblPreviousSign2.setBounds(43, 425, 32, 32);							//set position and size
		add(lblPreviousSign2);													//add to Track
		
		lblResultIcon.setIcon(null);
	}

	public void genNewAnswer(int max) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setInit
		*
		* Method parameters		:	max - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method generates the random mode number
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
		
		GenerateNumber generatedNumber;						//define generatedNumber as GenerateNumber Object
		generatedNumber = new GenerateNumber();				//instantiate generatedNumber as GenerateNumber Object
		generatedNumber.generateModeNumber(max);			//call generateModeNumber() to generate modeNumber
		answer = generatedNumber.getModeNumber();			//set answer = modeNumber
	}
	
	public int getAnswer() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getAnswer
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method return data members: amswer 
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
		
		return this.answer;						//return answer
	}
	
	public void setAnswer(int input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setAnswer
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets data members: amswer 
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
		
		this.answer = input;						//set answer = input
	}
	
	public void setLivesDisplay(int input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setLivesDisplay
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets lblLives text to input value 
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
		
		lblLives.setText(Integer.toString(input));		//set lblLives text to input value
	}
	
	
	public void enterInput(int max) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void enterInput
		*
		* Method parameters		:	max - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method gets player input number and check if the input is valid or not.
		* 								It will set nowInputInt	= -1 if the input is invalid.		 
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
		
		this.nowInputString = this.textField.getText();				//set nowInputString = input in textField
		try {
			int temp;												//define temp as integer
			temp = Integer.parseInt(this.nowInputString);			//set temp = conversion of nowInputString to integer

			if (temp > 0 && temp <= max) {							//if temp in range then
				this.nowInputInt = temp;							//set nowInputInt = temp

			} else {
				this.nowInputInt = -1;								//set nowInputInt = -1

			}
		}catch(Exception e) {
			this.nowInputInt = -1;									//set nowInputInt = -1
		}
	}
	
	public boolean checkInput() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void checkInput
		*
		* Method parameters		:	none
		*
		* Method return			:	boolean
		*
		* Synopsis				:	This method checks if the guess is correct	 
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
		
		//System.out.println(this.id+":"+this.answer+"<>"+this.nowInputInt);
		if (this.answer == this.nowInputInt) {						//if answer == nowInputInt then
			return true;											//return true
		} else {
			return false;											//return false
		}
	}
	
	public int getNowInputInt() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getNowInputInt
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method returns data member: nowInputInt
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
		
		return this.nowInputInt;									//return nowInputInt
	}
	
	public void setNowInputInt(int input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setNowInputInt
		*
		* Method parameters		:	input - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets data member: nowInputInt
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
		
		this.nowInputInt = input;									//set nowInputInt = input
	}
	
	public void setEnableTrack(StateMachine onoff) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setEnableTrack
		*
		* Method parameters		:	onoff - the method permits a MachineState Enums to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sets enable and disable this track
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
		
		if (onoff == StateMachine.ON) {							//if onoff == MachineState.ON then
			this.textField.setEnabled(true);					//enable track
		} else {												
			this.textField.setEnabled(false);					//disable track
		}
	}
	
	public void clearRecord() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void clearRecord
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method clear records array and clean display
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
			lblResultIcon.setIcon(null);				//set lblResultIcon to null
			lblPreviousNumber0.setText("");				//set lblPreviousNumber0 text to ""
			lblPreviousNumber1.setText("");				//set lblPreviousNumber1 text to ""
			lblPreviousNumber2.setText("");				//set lblPreviousNumber2 text to ""
			lblPreviousSign0.setIcon(null);				//set lblPreviousSign0 to null
			lblPreviousSign1.setIcon(null);				//set lblPreviousSign1 to null
			lblPreviousSign2.setIcon(null);				//set lblPreviousSign2 to null
		} catch (Exception e) {
			
		}
		this.records = new ArrayList<Integer>();		//clear records by create new ArrayList<Integer>
	}
	
	public void addRecord() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void addRecord
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method add new element to records Array at index 0
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
		
		this.records.add(0,this.nowInputInt);			//add nowInputInt to index 0
	}
	
	public ArrayList<Integer> getRecords() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void getRecord
		*
		* Method parameters		:	none
		*
		* Method return			:	ArrayList<Integer>
		*
		* Synopsis				:	This method return records Array
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

		return this.records;							//return records
	}
	
	public void showRecord(int turn) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void showRecord
		*
		* Method parameters		:	turn - the method permits an integer to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method displays the previous guesses and display assistance arrows
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
			lblPreviousNumber0.setText(String.valueOf(records.get(0)));				//set lblPreviousNumber0 text to records.get(0)
			if (records.get(0) == -1) {												//if records.get(0) == -1 then
				lblPreviousNumber0.setText("invalid input");						//set lblPreviousNumber0 text to "invalid input"
				lblPreviousSign0.setIcon(null);										//set arrow to null
			}
			else if (records.get(0) > answer) {										//if records.get(0) > answer
				lblPreviousSign0.setIcon(tooHi);									//set arrow to tooHi
			} else {
				lblPreviousSign0.setIcon(tooLo);									//set arrow to tooLo
			}
		
			if (turn > 0) {															//if turn > 0 then
				lblPreviousNumber1.setText(String.valueOf(records.get(1)));			//set lblPreviousNumber1 to records.get(1)
				if (records.get(1) == -1) {											//if records.get(1) == -1
					lblPreviousNumber1.setText("invalid input");					//set lblPreviousNumber1 text to "invalid input"
					lblPreviousSign1.setIcon(null);									//set arrow to null
				}
				else if (records.get(1) > answer) {									//if records.get(1) > answer
					lblPreviousSign1.setIcon(tooHi);								//set arrow to tooHi
				} else {
					lblPreviousSign1.setIcon(tooLo);								//set arrow to tooLo
				}
				if (turn > 1) {														//if turn > 1 then
					lblPreviousNumber2.setText(String.valueOf(records.get(2)));		//set lblPreviousNumber2 to records.get(2)
					if (records.get(2) == -1) {										//if records.get(2) == -1
						lblPreviousNumber2.setText("invalid input");				//set lblPreviousNumber2 text to "invalid input"
						lblPreviousSign2.setIcon(null);								//set arrow to null
					}
					else if (records.get(2) > answer) {								//if records.get(2) > answer
						lblPreviousSign2.setIcon(tooHi);							//set arrow to tooHi
					} else {
						lblPreviousSign2.setIcon(tooLo);							//set arrow to tooLo
					}
				}
			}
		} catch (Exception err) {
			
		}
	}
	
	public void initRecord() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void initRecord
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method initialize and display old records to tracks
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
		
		if (records.size() > 0) {													//if records.size() > 0 then
			lblPreviousNumber0.setText(String.valueOf(records.get(0)));				//set lblPreviousNumber0 text to records.get(0)
			if (records.get(0) == -1) {												//if records.get(0) == -1 then
				lblPreviousNumber0.setText("invalid input");						//set lblPreviousNumber0 text to "invalid input"
				lblPreviousSign0.setIcon(null);										//set arrow to null
			}
			else if (records.get(0) > answer) {										//if records.get(0) > answer
				lblPreviousSign0.setIcon(tooHi);									//set arrow to tooHi
			} else {
				lblPreviousSign0.setIcon(tooLo);									//set arrow to tooLo
			}
			if (records.size() > 1) {												//if records.size() > 1 then
				lblPreviousNumber1.setText(String.valueOf(records.get(1)));			//set lblPreviousNumber1 to records.get(1)
				if (records.get(1) == -1) {											//if records.get(1) == -1
					lblPreviousNumber1.setText("invalid input");					//set lblPreviousNumber1 text to "invalid input"
					lblPreviousSign1.setIcon(null);									//set arrow to null
				}
				else if (records.get(1) > answer) {									//if records.get(1) > answer
					lblPreviousSign1.setIcon(tooHi);								//set arrow to tooHi
				} else {
					lblPreviousSign1.setIcon(tooLo);								//set arrow to tooLo
				}
				if (records.size() > 2) {											//if records.size() > 2 then
					lblPreviousNumber2.setText(String.valueOf(records.get(2)));		//set lblPreviousNumber2 to records.get(2)
					if (records.get(2) == -1) {										//if records.get(2) == -1
						lblPreviousNumber2.setText("invalid input");				//set lblPreviousNumber2 text to "invalid input"
						lblPreviousSign2.setIcon(null);								//set arrow to null
					}
					else if (records.get(2) > answer) {								//if records.get(2) > answer
						lblPreviousSign2.setIcon(tooHi);							//set arrow to tooHi
					} else {
						lblPreviousSign2.setIcon(tooLo);							//set arrow to tooLo
					}
				}
			}
		}
	}
	
	
	public void showCorrectionLogo(StateCorrect correct) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void showCorrectionLogo
		*
		* Method parameters		:	correct - the method permits a boolean to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method displays the previous guesses and display assistance arrows
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
		
		if (correct == StateCorrect.RIGHT) {									//if correct == StateCorrect.RIGHT then
			lblResultIcon.setIcon(rightIcon);									//display rightIcon
		} else if (correct == StateCorrect.WRONG) {
			lblResultIcon.setIcon(wrongIcon);									//display wringIcon
		} else {
			lblResultIcon.setIcon(null);	
		}
		
	}
	
	public void cleanInputBox() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void cleanInputBox
		*
		* Method parameters		:	none
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method displays clean textField input box
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
		
		this.textField.setText("");												//set textField text to ""
	}
	
	public void loadRecords(String inputRecords) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void loadRecords
		*
		* Method parameters		:	inputRecords - the method permits a String to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method loads and converts data to records
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
		
		String[] stringArray = inputRecords.split(",");				//define and instantiate stringArray as String[] with inputRecords data
			
		for (int i = 0; i < stringArray.length; i++) {				//go through stringArray
			if (!stringArray[i].equals("")) {						//
				records.add(Integer.parseInt(stringArray[i]));		//covert to integer
			} 
		}
	}
	
	public void setInputBox(int input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setInputBox
		*
		* Method parameters		:	input - the method permits an Integer to be entered
		*
		* Method return			:	void 
		*
		* Synopsis				:	This method set textField inbox
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
		
		textField.setText(String.valueOf(input));					//set textField to input
	}
}