
public class TestProgram extends NEnArmadBandit {
	int tries = 0;
	//The Series of Numbers that are generated.
	public static final int[] SERIES={999,888,551,669};
	//The Series of number that need to trigger the new WinTable().almost(outcome);
	public static final int[] ALMOST_SET={551,669};	
	public void generate() {
     	tries++;
		if ( tries<=SERIES.length) {
			outcome[0] = NEnArmadBandit.getNthDigit(SERIES[(tries - 1)], 10, 3);
			outcome[1] = NEnArmadBandit.getNthDigit(SERIES[(tries - 1)], 10, 2);
			outcome[2] = NEnArmadBandit.getNthDigit(SERIES[(tries - 1)], 10, 1);
			//Check of the Outcome combination belongs to Almost Set
			for (int num : ALMOST_SET) {
				if (num == SERIES[(tries - 1)]) {
					new WinTable().almost(outcome);
				}
			}
		}
		//System.out.println("Your wheels are " + outcome[0] + outcome[1] + outcome[2] + " Vinst Šr "+ new WinTable().pwin(outcome));
   }


	public static void main(String[] args) {
		TestProgram et = new TestProgram();
		et.Slotmachine();
	}
}
