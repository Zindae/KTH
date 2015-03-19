/**
 * The Painting class.
 * 
 * 
 */
class Painting {
	// The name of the painting
	private String name;
	// The value of the painting.
	private float value;

	/**
	 * Default NoArgs constructor.
	 * 
	 * @param name
	 * @param value
	 */
	public Painting(String name, float value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}
}

/**
 * 
 * Main Launch class.
 * 
 */
public class Assignment3 {
	public static void main(String[] args) {
		System.out.println("Painiting collection!\n");
		// Painting collection.
		PainitingCollection collection = new PainitingCollection();
		// Add paintings.
		Painting drawing1 = new Painting("first drawing", 23.00f);
		Painting drawing2 = new Painting("second drawing", 12.00f);
		Painting drawing3 = new Painting("third drawing", 2.00f);
		Painting drawing4 = new Painting("forth drawing", 9.00f);
		Painting drawing5 = new Painting("fifth drawing", 19.00f);
		collection.add(drawing1);
		collection.add(drawing2);
		collection.add(drawing3);
		collection.add(drawing4);
		collection.add(drawing5);
		// Display the Max value painting info.
		System.out.println("\nPainiting with maximum value : Name ="
				+ collection.getMaxValueDrawing().getName() + " Value ="
				+ collection.getMaxValueDrawing().getValue());
		// Display all the painting.
		System.out.println("\nPainting Collection data");
		for (int i = 0; i < collection.size(); i++) {
			System.out.print(collection.getDrawings()[i].getName() + "--"
					+ collection.getDrawings()[i].getValue() + "\n");
		}
	}
}

/**
 * 
 * Represents a collection of paintings.
 * 
 */
class PainitingCollection {
	// The set of all paintings.
	Painting[] painitings = new Painting[100];
	// The counter for the painting.
	int c = 0;

	/**
	 * No Args constructor.
	 */
	public PainitingCollection() {
		super();
	}

	/**
	 * Adds the painting.
	 * 
	 * @param painting
	 */
	public void add(Painting painting) {
		painitings[c++] = painting;
		System.out.println("Painting added to collection . Name = "
				+ painting.getName() + " Value = " + painting.getValue());
	}

	/**
	 * The size of the painting.
	 * 
	 * @return
	 */
	public int size() {
		return c;
	}

	/**
	 * Gets the array of all painting.
	 * 
	 * @return
	 */
	public Painting[] getDrawings() {
		return painitings;
	}

	/**
	 * Gets the painting with maximum value.
	 * 
	 * @return
	 */
	public Painting getMaxValueDrawing() {
		float max = Float.MIN_VALUE;
		Painting result = null;
		for (int i = 0; i < c; i++) {
			if (painitings[i].getValue() > max) {
				result = painitings[i];
				max=painitings[i].getValue();
			}
		}
		return result;
	}

}
