
/**
 * This is a Test program class used to override the number generation scheme
 * provided by the default EnArmadBandit. This is a launcher class for staring
 * the slot machine instance.
 */

public class TestProgram extends EnArmadBandit {

	// This counter is used to hold the current try count by the user.
	// Hitting the spin/roll button increments the tries by one.
	int tries = 0;

	// The number set from which the numbers are picked up to decide a wheel
	// combination. The program exits after the fourth combination.
	public static final int[] SERIES={999, 888, 551, 669};

	/**
	 * This method overrides the wheel outcome generation algorithm provided by
	 * the super class EnArmadBandit.
	 */

	public void generate() {

		// The counter deciding the current try performed by the user.
		tries++;

		// This field is used to hold the index of the arrays , which hold the
		// out come combination number.
		// The numeric value at index seriesIndex for array SERIES holds the
		// value to be shown in the current outcome.
		int seriesIndex = 0;

		// This flag indicates that the out come generated must further modified
		// to make, it look like it just missed the number held at SERIES[seriesIndex]
		boolean applyAlmostOutcome = false;

		switch (tries){
		case 1 : 
			// Pick the outcome from SERIES[0]
			seriesIndex = 0;
			break;

		case 2 : 
			// Pick the outcome from SERIES[1]
			seriesIndex = 1;
			break;

		case 3 :
			// Pick the outcome from SERIES[2]
			seriesIndex = 2;
			applyAlmostOutcome = true;
			break;

		case 4 :
			// Pick the outcome from SERIES[3]
			seriesIndex = 3;
			applyAlmostOutcome = true;
			break;

			// Exit the TestProgram
		case 5 : System.exit(0);

		default :
			break;

		}

		// Extract each digit and map it to associated out come . E.g. 678
		// gets mapped to outcome[0] = 6, outcome[1] = 7 , outcome[2] = 8
		// In the following three lines.
		outcome[0] = EnArmadBandit.getNthDigit(SERIES[seriesIndex], 3);
		outcome[1] = EnArmadBandit.getNthDigit(SERIES[seriesIndex], 2);
		outcome[2] = EnArmadBandit.getNthDigit(SERIES[seriesIndex], 1);

		if (applyAlmostOutcome) {
			new WinTable().almost(outcome);
		}

	}

	/**
	 * This is the launcher application. This method launches the Slot machine.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProgram et = new TestProgram();

		// Displays the slot machine.
		et.Slotmachine();
	}

}
