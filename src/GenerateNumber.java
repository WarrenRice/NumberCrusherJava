import java.util.Random;  

public class GenerateNumber {

	private int[] numberArray;							//define numberArray as integer array
	private int modeNumber;								//define modeNumber as integer

	public GenerateNumber() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	generateRandomArray class constructor
		*
		* Method parameters		:	limitRange - the method permits integer parameters to be entered
		*
		* Method return			:	generateRandomArray
		*
		* Synopsis				:	This method generate mode number from set of random numbers
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
		
		this.modeNumber = 0;							//set modeNumber = 0
		this.numberArray = new int[1000];				//instantiate numberArray from 1000 elements
	}
	
	public void generateRandomArray(int limitRange) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void generateRandomArray
		*
		* Method parameters		:	limitRange - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method generates random number (from 1 to limitRange) from every elements in numberArray 
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
		
		Random rng = new Random();												//define and instantiate rng as new Random object
		int counter;															//define counter as an integer
		int randomNumber;														//define randomNumber as an integer
		for (counter = 0; counter < this.numberArray.length; counter++) {		//go through every element in numberArray
			randomNumber = rng.nextInt(1, limitRange+1);						//set randomNumber = random number (from 1 to limitRange+1)
			this.numberArray[counter] = randomNumber;							//set numberArray[counter] = randomNumber
		}
	}
	
	public void selectionSorting() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void selectionSorting
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method sorts numberArray from low to high
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
		
		int i;				//define i as integer
		int j;				//define j as integer
		int min;			//define min as integer
		int temp;			//define temp as integer
		
		for (i = 0; i < this.numberArray.length-1; i++) {			//go through numberArray from 0 to numberArray.length-1
			min = i;												//set index min = i
			//comparing
			for (j = i + 1; j < numberArray.length; j++) {			//go through numberArray from i+1 to numberArray.length
				if (this.numberArray[j] < this.numberArray[min]) {	//numberArray[j] < numberArray[min]
					min = j;										//set index min = j
				}
			}
			//swapping
			if (min != i) {											//if min is not equal to i
				temp = this.numberArray[i];							//set temp = numberArray[i]
				this.numberArray[i] = this.numberArray[min];		//set numberArray[i] = numberArray[min]
				this.numberArray[min] = temp;						//set numberArray[min] = temp
			}
		}
	}
	
	public int findModeNumber() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int findModeNumber
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method determine the mode number by counting the same number will return
		* 								the number if there is that number is the only one that has maximum count 
		* 								and return if that number is not the only one that has maximum count.
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
		
		int index;					//define index as an integer
		int count;					//define count as an integer				
		int maxCount;				//define maxCount as an integer
		int currentNumber;			//define currentNumber as an integer
		int outPutNumber;			//define outPutNumber as an integer
		
		count = 1;								//set count = 1
		maxCount = 1;							//set maxCount = 1
		outPutNumber = 0;						//set outPutNumber = 0
		currentNumber = this.numberArray[0];	//set currentNumber = numberArray[0]

		for (index = 1; index < this.numberArray.length; index++) {			//go through every elements in numberArray
			if (this.numberArray[index] == currentNumber) {					//if numberArray[index] == currentNumber (same number) then
				count = count + 1;											//set count = count + 1
				if (index == this.numberArray.length - 1) {					//if index == last index then
					if (count > maxCount) {									//if count > maxCount (fine maxCount) then
						maxCount = count;									//set maxCount = count
						outPutNumber = this.numberArray[index];				//set outPutNumber = numberArray[index]
					} else if (count == maxCount) {							//if count == maxCount (if the same maxCount
						outPutNumber = 0;									//set outPutNumber = 0
					}
				}
			} else {														//else (difference number)
				if (count > maxCount) {										//if count > maxCount (fine maxCount) then
					maxCount = count;										//set maxCount = count
					outPutNumber = this.numberArray[index-1];				//set outPutNumber = numberArray[index-1]
				} else if (count == maxCount) {
					outPutNumber = 0;										//set outPutNumber = 0
				}
				currentNumber = this.numberArray[index];					//set currentNumber = numberArray[index] (New Number)
				count = 1;													//reset count = 1
			}
		}

		return outPutNumber;												//return outPutNumber
	}
	
	public void generateModeNumber(int limitRange) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void generateModeNumber
		*
		* Method parameters		:	limitRange - the method permits an integer parameter to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	This method will regenerates array of random number until it find the mode number 
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
		
		while (this.modeNumber == 0) {										//while modeNumber == 0 do
			this.generateRandomArray(limitRange);							//call generateRandomArray(limitRange) to generate random number in array
			
			
			this.selectionSorting();										//call selectionSorting() to sort array
			
			
			this.modeNumber = this.findModeNumber();						//set modeNumber = return from the method findModeNumber()
			

		}
	}
	
	
	public void printArray() {																	//for debugging purpose
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void printArray
		*
		* Method parameters		:	none
		*
		* Method return			:	void
		*
		* Synopsis				:	This method is meant for debugging purpose and display the current numberArray in the console
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
		
		int index;														//define index as an integer
		for (index = 0; index< this.numberArray.length; index++) {		//go through every elements in numberArray
			System.out.print(this.numberArray[index]+",");				//print numberArray[index]
		}
		System.out.println();											//print newline
	}
	
	public int getModeNumber() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int getModeNumber
		*
		* Method parameters		:	none
		*
		* Method return			:	int
		*
		* Synopsis				:	This method return modeNumber
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
		
		return this.modeNumber;							//return modeNumber
	}
	
	public int[] getArray() {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	int[] getArray
		*
		* Method parameters		:	none
		*
		* Method return			:	int[]
		*
		* Synopsis				:	This method return numberArray 
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
		
		return this.numberArray; 						//return numberArray
	}
}

