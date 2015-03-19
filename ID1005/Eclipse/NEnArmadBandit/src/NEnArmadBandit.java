import java.util.*;

public class NEnArmadBandit{
	/** 
	 * @Credits, Is the money you win, and add in deposit
	 * @Profit, is the money you earn from the winning the game at this time.
	 * @Outcome, is what the {3} wheels returns from WinTable
	 * @Random, random generator which i call generator
	 */ 

	private int credits = 0;
	private int profit = 0;
	public int [] outcome = new int[3];
	Random generator = new Random();

	/**
	 * The SlotMachines intern name will from now on be "machine"!.
	 * The Title of this applet will be SlotMachine
	 * @return boolean fallBackMode, true
	 * 
	 * The class WinTable will from now on be defined as wintb.
	 */

	SlotFrame machine = new SlotFrame("SlotMachine", true);	
	WinTable wintb = new WinTable();

	/**
	 * Generate(), will return the NextInt with a generated
	 * number of 10 from Random.
	 * We let the random numbers from 0 to 10 be in the wheels, outcome
	 */ 

	public void generate(){

		outcome[0] = generator.nextInt(10);
		outcome[1] = generator.nextInt(10);
		outcome[2] = generator.nextInt(10);

		/**	
		 * If you un-comment this you choose that the SlotMachine wheels will
		 * always stops on the combinations {9,9,9} and return 180 in credits.

			outcome[0] = 9;
			outcome[1] = 9;
			outcome[2] = 9;

		 */

	}

	/**
	 * If i is smaller then profit it will run the "for loop"
	 * Credits will be added by one
	 * machine.setCredit will trigger to show the new credits amount in the graphic display
	 * And machine.win will trigger the SlotFrame to show a red sign when it's a winning combination
	 * 
	 * Try Thread.sleep (50), means that the credits that is earned will be enumberate 
	 * with a delay of 50 ms between each credit
	 * 
	 * Catch a InterruptedException
	 */ 

	public void moneycounter(){
		try {
			for (int i = 0; i < profit;credits += 1, machine.setCredit(credits), machine.win(1),Thread.sleep(50),i++);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Print-out your wheels and the profit you earn
	 */ 
	public void nwheels(){
		System.out.println("Your wheels are " + outcome[0] + outcome[1] + outcome[2]+ " " + "and your got " + new WinTable().pwin(outcome) + " " + "Your total credits is now" + " "+ (credits + profit));
	}

	/**
	 * This is the main function, SlotMachine. 
	 * Here is the program that invokes all of the important functions
	 */ 

	public void Slotmachine(){

		/**
		 * While loop, if everything is true it continues to the loop the function
		 */ 

		while(true){

			/**
			 * @String Invokes the getNextEvent using the defined string method button.
			 * 
			 * If button equals the creditbutton, it will add 10 credits to deposit.
			 * machine.setCredit triggers the SlotFrame and will display the graphic Credit to show 10.
			 */ 

			String button = machine.getNextEvent();

			if (button.equals("creditbutton")){
				credits+= 10;
				machine.setCredit(credits);
			}

			/**
			 * If button equals the rollbutton and the credits is more then 0, run this =>
			 * Generate random from class => private void generate()
			 * Remove one Credit for each press on rollbutton
			 * machine.roll is defined in SlotFrame, only triggers the rolling mechanism
			 * 
			 * Profit is now defined as wintb(WinTable).pwin(method in WinTable) returned outcome.
			 * Credits will now be added to to the profit
			 */ 

			if (button.equals("rollbutton") && credits > 0 ){

				this.generate();

				profit = wintb.pwin(outcome);

				if  (profit == 0){
					wintb.almost(outcome);

				}
				machine.setCredit(--credits);
				machine.roll(outcome);
				nwheels();

				//credits += profit;

				/**
				 * If the profit, the money you earn is equal to 0, 
				 * which means no winning combinations it will =>
				 * Run the class declared in the winTable, and method almost.
				 */ 
				if (profit > 0){
					moneycounter();
				}	

			}	

		}
	}

	/**
	 * This is the public main function, Main
	 * Here is writes Your chance to win with a reference to WinTables method expectedprofit
	 * 
	 * It invoke a new EnArmadBandit and a new reference to SlotMachine eb
	 */ 

	public static void main(String[] args) {


		System.out.println("Your chance to win " + new WinTable().expectedprofit() + " % ");

		NEnArmadBandit eb = new NEnArmadBandit();

		eb.Slotmachine();

	}
	
    /** 
     * Returns the Nth digit in a Number . If 931 is a Number of base 10. It returns 3  for input values 931,10,2 .
     */
	public static int getNthDigit(int number, int base, int n) {    
		  return (int) ((number / Math.pow(base, n - 1)) % base);
    }
}



