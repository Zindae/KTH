
public class MinaT�rningar {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		T�rning [] minaT�rningar = {new T6(), new T10(), new T20()}; //G�r en ny Array och l�gger till MinaT�rningar, new T
	
		for (T�rning t : minaT�rningar){//Anropar minaT�rningar, genom T�rning t.
			System.out.println("Kastar" + t + " och sl�r " + t.kasta());
		}

	}

}
