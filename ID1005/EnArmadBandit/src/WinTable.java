import java.util.*;

/**
 * This is the WinTable class.
 */ 

public class WinTable{
	
	/** 
	 *  The method pwin with integer of wheel will
	 *  check and return a value if the right combination 
	 *  of the three wheel is met.
	 */
 
	public int pwin(int[] wheel) {
		
		if (wheel[0] == 9 && wheel[1] == 9 && wheel[2] == 9)
			return 180;
		
		else if (wheel[0] == 8 && wheel[1] == 8 && wheel[2] == 8)
			return 160;
		
		else if (wheel[0] == 7 && wheel[1] == 7 && wheel[2] == 7)
			return 140;
		
		else if (wheel[0] == 6 && wheel[1] == 6 && wheel[2] == 6)
			return 60;
		
		else if (wheel[0] == 5 && wheel[1] == 5 && wheel[2] == 5)
			return 25;
		
		else if (wheel[0] == 4 && wheel[1] == 4 && wheel[2] == 4)
			return 25;
		
		else if (wheel[0] == 3 && wheel[1] == 3 && wheel[2] == 3)
			return 25;
		
		else if (wheel[0] == 2 && wheel[1] == 2 && wheel[2] == 2)
			return 25;
		
		else if (wheel[0] == 1 && wheel[1] == 1 && wheel[2] == 1)
			return 25;
		
		else if (wheel[0] == 0 && wheel[1] == 0 && wheel[2] == 0)
			return 5;
		
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
	 * Almost method with integer of wheel, will calculate and < 75 % of the cases
	 * return and change the outcome to an almost winning combination.
	 */ 
	
	public void almost(int[] wheel) {
		if (Math.random()*100 <75){
			
			if ((wheel[0] == wheel[1]) && (wheel[1] <= 9))
				wheel[2] = wheel[0]+1;
			
			else if ((wheel[0] == wheel[1]) && (wheel[1] == 10))
				wheel[2] = wheel[0]-1;

			else if ((wheel[0] == wheel[2]) && (wheel[0] <= 9))
				wheel[1] = wheel[0]+1;
			
			else if ((wheel[0] == wheel[2]) && (wheel[0] == 10))
				wheel[1] = wheel[0]-1;
			
			else if ((wheel[1] == wheel[2]) && (wheel[1] <= 9))
				wheel[0] = wheel[1]+1;
			
			else if ((wheel[1] == wheel[2]) && (wheel[1] == 10))
				wheel[0] = wheel[1]-1;
		}
		
	}
	/**
	 * Double method "expectedprofit" will calculate all the possible
	 *  combinations of winning and will then return a sum of all possibilties
	 */ 
		public double expectedprofit(){
			int[] wheel = new int[3];
			double sum = 0;
			
			for (int i = 0; i < 10; i++){
				for (int j = 0; j < 10; j++){
					for(int k = 0; k < 10; k++){
						wheel[0] = i;
						wheel[1] = j;
						wheel[2] = k;
				
						sum += pwin(wheel);	
					
					}
				}
				
			}
			return sum/10;
	
		
	}
	
}
