import java.util.*;

/**
 * This class is a representation of Slot machine.
 * It used for performing the following tasks.
 *   -- Generate outcomes.
 *   -- Count the credits.
 *   -- Hold the profit.
 *   -- Manage user interaction with the slot machine.
 *   -- Launch the slot machine.
 *   
 *   @Christopher State TKOMK1
 */

public class EnArmadBandit{

	// The money currently held by the user for use on the slot machine. 
	private int credits = 0;

	// The sum of all profits from the current game session.
	private int profit = 0;

	// The  outcome of each wheel.
	// E.g wheel[1] (wheel 1) outcome is held in outcome[1].
	public int [] outcome = new int[3];

	// This is a Random class instance. It is used in random number generation. 
	Random generator = new Random();

	// This field is used to hold SlotFrame class instance. The frame has the title SlotMachine.
	SlotFrame machine = new SlotFrame("SlotMachine", true);	

	// An instance of WinTable. It is used to derive profit for a given wheel combination.
	// Its also used to get sum of profits for all possible wheel combinations.
	WinTable wintb = new WinTable();

	/**
	 * This method is used to generate random outcomes for the three wheel. 
	 * It uses java random number generator to randomly created numbers between 0(inclusive) ...to ..10(exclusive)
	 * Three random generators are used here to associate outcome to each of the three wheels. 
	 */

	public void generate(){

		outcome[0] = generator.nextInt(10);
		outcome[1] = generator.nextInt(10);
		outcome[2] = generator.nextInt(10);
	}

	/**
	 * When the user makes a profit in the given spin, the credits incremented graphically. 
	 * This method is used to handle the graphic display, where the profit is applied to existing credit.
	 * The denomination on the credit counter is incremented by 1, followed by a 50ms pause .
	 * This gives the impression of existing credit gradually increasing in the credit counter.
	 */

	public void moneycounter(){
		try {
			for (int i = 0; i < profit;credits += 1, machine.setCredit(credits), machine.win(1),Thread.sleep(50),i++);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Displays the current wheel combination and profits earned.
	 */ 

	public void nwheels(){
		System.out.println("Your wheels are " + outcome[0] + outcome[1] + outcome[2]+ " " + "and you got " + new WinTable().pwin(outcome) + " credits. " + "Total credits is now" + " "+ (credits + profit));
	}

	/**
	 * This method is used to handle all user interactions on the slot machine.
	 * It
	 *     -- Handles credit button press
	 *     -- Roll button press.
	 *     -- Displays money counter when needed.
	 */

	public void Slotmachine(){

		while(true){

			//Get the machine event 
			String button = machine.getNextEvent();

			//Machine event is a creditButton click. One click adds 10 unit to credit.
			if (button.equals("creditbutton")){
				credits+= 10;

				//Set the credit.
				machine.setCredit(credits);
			}

			if (button.equals("rollbutton") && credits > 0 ){
				//The roll button is clicked.
				//Generate a random outcome for the three wheels
				this.generate();

				//Get the profit for the wheel combination.
				profit = wintb.pwin(outcome);

				//If profit is Zero. Apply the almost method of WinTable to slightly deviate the outcome.
				if  (profit == 0){
					wintb.almost(outcome);

				}

				//When each roll the credits are reduced by one unit.
				machine.setCredit(--credits);
				machine.roll(outcome);
				nwheels();

				if (profit > 0){

					//User had made some profit. 
					//To create a graphical illusion of the money gradually increasing in the credit counter we call the following method.
					moneycounter();

				}	

			}	

		}
	}

	/** 
	 * Returns the Nth digit in a Number . 
	 * E.g for number 786
	 *   getNthDigit(786,1) returns 6 
	 *   getNthDigit(786,2) returns 8
	 *   getNthDigit(786,3) returns 7
	 */

	public static int getNthDigit(int number, int n) {  

		//Default base is 10
		return (int) ((number / Math.pow(10, n - 1)) % 10);
	}

	/**
	 * This class is used to launch the Slot Machine . It uses the EnArmadBandit instance for slot machine representation.
	 * @param args
	 */

	public static void main(String[] args) {

		System.out.println("Your chance to win " + new WinTable().expectedprofit() + " % ");

		EnArmadBandit eb = new EnArmadBandit();
		eb.Slotmachine();
		
		

	}

}


