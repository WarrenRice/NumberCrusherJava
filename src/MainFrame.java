import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
	}

	private JPanel welcomeGUI;						// defines welcomeGUI as a JPanel for content pane
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		* Method				:	void main(String[] args)
		*
		* Method parameters		:	args - the method permits String command line parameters to be entered
		*
		* Method return			:	void
		*
		* Synopsis				:	The method runs the application.
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIWelcome game = new GUIWelcome();				//create Welcome Scene GUI object
					game.setTitle("Number Cruncher");				//set title
					game.setVisible(true);							//display Welcome Scene
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
