
public class T�rningsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		T�rning [] minaT�rningar = {new T6(), new T10(), new T20()};
		
		for (T�rning t : minaT�rningar) {
			System.out.println("Kastar " + t + " och sl�r " + t.kasta());
		}
	}

}
