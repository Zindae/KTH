
/**
 * This is the WinTable class.
 */ 

public class WinTable{
	
	private static final int[] EQUAL_WHEEL_COMBINATION_CREDIT_VALUE= {5, 25,25,25,25,25,60,140,160,180};
	
	/** 
	 *  The method pwin with integer of wheel will
	 *  check and return a value if the right combination 
	 *  of the three wheel is met.
	 */	
	public int pwin(int[] wheel) {		
		if (isWheelCombinationEqual(wheel)&&wheel[0]>=0&&wheel[0]<=9){
			return EQUAL_WHEEL_COMBINATION_CREDIT_VALUE[wheel[0]];
		}else if (wheel[0] == wheel[1] && wheel[2] == 5)
			return 10;
		else if (wheel[0] == wheel[1] && wheel[2] == 2)
			return 5;		
		else if (wheel[2] == 2)
			return 2;
		else 
			return 0;		
	}
	
	/**
	 * Return true if wheel combinations are equal . i.e. combinations of 000,111,999,
	 * @param wheel
	 * @return
	 */
	public boolean isWheelCombinationEqual(int[] wheel){
		return (wheel!=null&&wheel.length==3&&(wheel[0]==wheel[1]&& wheel[1]==wheel[2]));
	}
	
	/**
	 * Almost method with integer of wheel, will calculate and < 75 % of the cases
	 * return and change the outcome to an almost winning combination.
	 */ 
	
	public void almost(int[] wheel) {
		if (Math.random()*100 <75){
			applyAlmostRuleForOutcome(wheel, 0, 1);
			applyAlmostRuleForOutcome(wheel, 0, 2);
			applyAlmostRuleForOutcome(wheel, 1, 2);			
		}		
	}
	
	public void applyAlmostRuleForOutcome(int[] wheel, int equalsIndx1, int equalsIndx2){
		int missingIndx= 3- (equalsIndx1+equalsIndx2);
		
		if ((wheel[equalsIndx1] == wheel[equalsIndx2]) && (wheel[equalsIndx2] <= 9))
			wheel[missingIndx] = wheel[equalsIndx1]+1;		
		
		else if ((wheel[equalsIndx1] == wheel[equalsIndx2]) && (wheel[equalsIndx2] == 10))
			wheel[missingIndx] = wheel[equalsIndx1]-1;
	}
	
	/**
	 * Double method "expectedprofit" will calculate all the possible
	 *  combinations of winning and will then return a sum of all possibilties
	 */ 
		public double expectedprofit(){
			int[] wheel = new int[3];
			double sum = 0;
			for (int i=0;i<1000;i++){
				wheel[0] = NEnArmadBandit.getNthDigit(i, 10, 3);
				wheel[1] = NEnArmadBandit.getNthDigit(i, 10, 2);
				wheel[2] = NEnArmadBandit.getNthDigit(i, 10, 1);
				sum += pwin(wheel);
			}
			return sum/10;
	
		
	}
	
}
