
public class TestProgram extends EnArmadBandit {


	int tries = 0;
	
	public void generate() {
		
		tries++;
		switch (tries){
		case 1 : outcome[0] = 9;
				 outcome[1] = 9;
				 outcome[2] = 9; 
			break;
				 
		case 2 : outcome[0] = 8;
				 outcome[1] = 8;
			  	 outcome[2] = 8;
			  	 
			break;
				
		case 3 : outcome[0] = 5;
				 outcome[1] = 5;
				 outcome[2] = 1;
				 new WinTable().almost(outcome);
				 
			break;
				
		case 4 : outcome[0] = 6;
				 outcome[1] = 6;
				 outcome[2] = 9;
				 new WinTable().almost(outcome);
			break;
			
		default :
				break;
			
		}
		
		//System.out.println("Your wheels are " + outcome[0] + outcome[1] + outcome[2] + " Vinst Šr "+ new WinTable().pwin(outcome));
		}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProgram et = new TestProgram();
		et.Slotmachine();
	}

}
