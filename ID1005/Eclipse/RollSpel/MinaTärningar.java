
public class MinaTärningar {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Tärning [] minaTärningar = {new T6(), new T10(), new T20()}; //Gör en ny Array och lägger till MinaTärningar, new T
	
		for (Tärning t : minaTärningar){//Anropar minaTärningar, genom Tärning t.
			System.out.println("Kastar" + t + " och slår " + t.kasta());
		}

	}

}
