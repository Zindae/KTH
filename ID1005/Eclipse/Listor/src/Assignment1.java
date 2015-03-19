/**
 * Assignment1 Launch class.
 * 
 */
public class Assignment1 {
	
	/**
	 * Launch class.
	 * 
	 * @param arg
	 */
	
	public static void main(String arg[]) {
		Bank bankA = new Bank(); // create new account
		Bank bankB = new Bank(); // create new account

		bankA.addCoins(5, 11, 30); // add coins to new account (5->1KR, 11->5KR, 30->10KR) 
		bankA.addUnits(20, 4, 25, 2, 2); // add units to new account (20->20SEK, 4->50SEK, 25->100SEK, 2->500SEK, 2->1000SEK)

		bankB.addCoins(6, 3, 40); // add coins to new account (6->1KR, 3->5KR, 40->10KR) 
		bankB.addUnits(12, 9, 11, 6, 1); // add units to new account (12->20SEK, 9->50SEK, 11->100SEK, 6->500SEK, 1->1000SEK)

		Assignment1 association = new Assignment1(); // create new association

		System.out
				.println("Sannas Two Savings Banks Prior to the Association : \n\n");

		association.priorToAssociation(bankA, bankB);

		// association

		int totalSavnigs = bankA.getSavingsTotal() + bankB.getSavingsTotal();

		int u_1000 = totalSavnigs / 1000;// get total 1000SEK units
		int temp = totalSavnigs % 1000;// get balance

		int u_500 = temp / 500;// get total 500SEK units
		temp = temp % 500;// get balance

		int u_100 = temp / 100;// get total 100SEK units
		temp = temp % 100;// get balance

		int u_50 = temp / 50;// get total 50SEK units
		temp = temp % 50;// get balance

		int u_20 = temp / 20;// get total 20SEK units
		temp = temp % 20;// get balance

		Bank bankC = new Bank(); // create new account

		bankC.addUnits(u_20, u_50, u_100, u_500, u_1000);// ad units to new one
															// account

		int c_10 = temp / 10;// get total 10KR coins
		temp = temp % 10;// get balance

		int c_5 = temp / 5;// get total 5KR coins
		temp = temp % 10;// get balance

		int c_1 = temp / 1; // get total 1KR coins
		temp = temp % 1;// get balance

		bankC.addCoins(c_1, c_5, c_10); // add coins to new one account

		System.out.println("Savings After the Association : \n\n");
		association.afterAssociation(bankC);

	}

	public void priorToAssociation(Bank bankA, Bank bankB) {
		bankA.display();// display first bank savings
		bankB.display();// display second bank savings
	}

	public void afterAssociation(Bank bank) {
		bank.display();// display bank savings
	}
}

/**
 * Represents a Bank.
 * 
 */
class Bank {
	// Denominations.
	private int coins_1KR, coins_5KR, coins_10KR;
	// The units.
	private int units_20SEK, units_50SEK, units_100SEK, units_500SEK,
			units_1000SEK;

	/**
	 * Adds coins to the bank.
	 * 
	 * @param c_1
	 * @param c_5
	 * @param c_10
	 */
	public void addCoins(int c_1, int c_5, int c_10) {
		coins_1KR += c_1;
		coins_5KR += c_5;
		coins_10KR += c_10;
	}

	/**
	 * Add units to the bank.
	 * 
	 * @param u_20
	 * @param u_50
	 * @param u_100
	 * @param u_500
	 * @param u_1000
	 */
	public void addUnits(int u_20, int u_50, int u_100, int u_500, int u_1000) {
		units_20SEK += u_20;
		units_50SEK += u_50;
		units_100SEK += u_100;
		units_500SEK += u_500;
		units_1000SEK += u_1000;
	}

	/**
	 * Returns the Savings total.
	 * 
	 * @return
	 */
	public int getSavingsTotal() {
		int savingsTotal = (coins_1KR) + (coins_5KR * 5) + (coins_10KR * 10)
				+ (units_20SEK * 20) + (units_50SEK * 50)
				+ (units_100SEK * 100) + (units_500SEK * 500)
				+ (units_1000SEK * 1000);
		return savingsTotal;
	}

	/**
	 * Display info.
	 */
	public void display() {
		System.out.println("Savings ------\n\n\tcoins 1KR : " + coins_1KR
				+ "\n\tcoins 5KR : " + coins_5KR + "\n\tcoins 10KR : "
				+ coins_10KR);
		System.out.println("\n\tunits 20SEK : " + units_20SEK
				+ "\n\tunits 50SEK : " + units_50SEK + "\n\tunits 100SEK : "
				+ units_100SEK + "\n\tunits 500SEK : " + units_500SEK
				+ "\n\tunits 1000SEK : " + units_1000SEK);
		System.out.println("\n\tTotal Savings : " + this.getSavingsTotal()
				+ "\n\n");
	}
}
