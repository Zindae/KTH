
public class TärningsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tärning [] minaTärningar = {new T6(), new T10(), new T20()};
		
		for (Tärning t : minaTärningar) {
			System.out.println("Kastar " + t + " och slår " + t.kasta());
		}
	}

}
