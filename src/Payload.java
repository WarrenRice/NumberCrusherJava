import java.util.ArrayList;

public class Payload {
	private boolean loaded;									//define loaded as a boolean to store Player decision about loading game
	private ArrayList<Integer> answers;						//define answers as an Integer array to store old answers
	private ArrayList<String> records;						//define records as an String array to store old records
	
	public Payload() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	Payload class constructor
		*
		* Method parameters		:	none
		*
		* Method return			:	Payload
		*
		* Synopsis				:	This method create Payload object with initial data members for passing loaded data.
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
		
		this.loaded = false;								//set loaded = false
		this.answers = new ArrayList<Integer>();			//instantiate answers as ArrayList<Integer>
		this.records = new ArrayList<String>();				//instantiate records as ArrayList<String>
	}

	public void addToAnswers(String input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void addToAnswers
		*
		* Method parameters		:	input - the method permits a String parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method add elements to answers array
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
		
		answers.add(Integer.parseInt(input));				//add elements to answers
	}
	
	public ArrayList<Integer> getAnswers() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	ArrayList<Integer> getAnswers()
		*
		* Method parameters		:	none
		*
		* Method return			:	ArrayList<Integer>
		*
		* Synopsis				:	This method return data member: answers
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
		
		return answers;										//return answers
	}

	public void addToRecords(String input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void addToRecords
		*
		* Method parameters		:	input - the method permits a String parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method add elements to records array
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
		
		records.add(input);									//add elements to records
	}
	
	public ArrayList<String> getRecords() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	ArrayList<Integer> getRecords()
		*
		* Method parameters		:	none
		*
		* Method return			:	ArrayList<Integer>
		*
		* Synopsis				:	This method return data member: records
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
		
		return records;										//return records
	}
	
	public void prepareRecordData() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void prepareRecordData()
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method prepare and edit records String to be easier to use
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
		
		String trimmedString;												//define trimmedString as a String
		for (int i = 0; i < this.records.size(); i++) {						//go through every elements in records
			trimmedString = records.get(i).replaceAll("\\[|\\]| ", "");		//remove '[',']',' '
			records.set(i, trimmedString);									//replace trimmedString in the same index
		}

	}
	
	public void setLoaded(boolean input) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void setLoaded
		*
		* Method parameters		:	input - the method permits an boolean parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method updates loading state
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
		
		this.loaded = input;												//set loaded = input
	}
	
	public boolean getLoaded() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	boolean getLoaded
		*
		* Method parameters		:	none
		*
		* Method return			:	boolean
		*
		* Synopsis				:	This method returns  loading state
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
		
		return this.loaded;													//return input
	}

}

