import java.util.*;

/**
 * The class manages the profit creation aspects of the slot machine. Its also
 * used to get the expected profit for various outcomes.
 */

public class WinTable{

	/** 
	 * This class is used to hold the profit amount , when the
	 * wheel[0], wheel[1], wheel[2] are equal.
	 * E.g. when wheel combination is wheel[0] = wheel[1] = wheel[2] = 2 . the profits
	 * gives credit_value[2]= 25.
	 */ 

	private static final int[] credit_value = {5,25,25,25,25,25,60,140,160,180};

	/**
	 * This method returns the profit value for the given combination of the
	 * wheel values. The outcome each wheel is represented by int [].
	 * 
	 * @param wheel 
	 * 			The wheel outcome values.
	 * @return The profit for the given wheel combination.
	 */

	public int pwin(int[] wheel) {

		if (isWheelCombinationEqual(wheel) && wheel[0] >= 0 && wheel[0] <=9){

			// Wheel combination are equal and within the valid range.
			return credit_value[wheel[0]];
		}

		else if (wheel[0] == wheel[1] && wheel[2] == 5)
			return 10;

		else if (wheel[0] == wheel[1] && wheel[2] == 2)
			return 5;

		else if (wheel[2] == 2)
			return 2;

		else 
			return 0;
	}

	/**
	 * Return true if wheel combinations are equal . i.e. combinations of
	 * 000,111,999,
	 * 
	 * @param wheel
	 *            The wheel outcome values.
	 * @return true - if the wheel combination are equal. i.e.
	 *         wheel[0]=wheel[1]=wheel[2]
	 */

	public boolean isWheelCombinationEqual(int[] wheel){
		return ((wheel[0] == wheel[1] && wheel[1] == wheel[2]));
	}

	/**
	 * This method is used to process the wheel outcomes. It makes sure
	 * than in 75% of cases the outcomes are altered, so it looks like , final
	 * outcomes are very close to winning combination.
	 */

	public void almost(int[] wheel) {
		if (Math.random()*100 <75){

			if ((wheel[0] == wheel[1]) && (wheel[1] <= 8))
				wheel[2] = wheel[0]+1;

			else if ((wheel[0] == wheel[1]) && (wheel[1] == 9))
				wheel[2] = wheel[0]-1;

			else if ((wheel[0] == wheel[2]) && (wheel[0] <= 8))
				wheel[1] = wheel[0]+1;

			else if ((wheel[0] == wheel[2]) && (wheel[0] == 9))
				wheel[1] = wheel[0]-1;

			else if ((wheel[1] == wheel[2]) && (wheel[1] <= 8))
				wheel[0] = wheel[1]+1;

			else if ((wheel[1] == wheel[2]) && (wheel[1] == 9))
				wheel[0] = wheel[1]-1;
		}

	}

	/**
	 * The method computes the expected profit for all possible combinations of wheel outcomes.
	 * @return
	 *       The expected profit from all possible outcomes.
	 */

	public double expectedprofit(){
		int[] wheel = new int[3];
		double sum = 0;

		//Numbers 0 ....999 covers all possible combinations. 
		//So we iterate over that and map those to wheel outcomes i.e. array of wheel[].
		//An number like 234 is mapped to wheel[0]=2 , wheel[1]=3, wheel[2]=4
		for (int i = 0; i < 1000; i++){
			wheel[0] = EnArmadBandit.getNthDigit(i, 3);
			wheel[1] = EnArmadBandit.getNthDigit(i, 2);
			wheel[2] = EnArmadBandit.getNthDigit(i, 1);
			sum += pwin(wheel);
		}
		return sum/10;

	}


}