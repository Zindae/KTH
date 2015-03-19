/**
 * The Graph implementation class.
 * 
 */
public class Graph1 {
	// The Graph nodes
	private int graph[][][];
	/**
	 * Default constructor.
	 */
	public Graph1() {
		graph = new int[10][10][2];
	}
	/**
	 * The Default constructor.
	 * 
	 * @param u
	 * @param v
	 */
	public Graph1(int u, int v) {
		graph = new int[u][v][2];
	}
	/**
	 * Returns true if the Edge is Valid.
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean IsValidEdge(int u, int v) {
		return (u >= 0 && v >= 0 && u < graph.length && v < graph[0].length);
	}
	/**
	 * Adds the Edge
	 * 
	 * @param u
	 * @param v
	 * @param w
	 */
	public void addEdge(int u, int v, int w) {
		if (IsValidEdge(u, v)) {
			graph[u][v][0] = 1;
			graph[u][v][1] = w;
		}
	}
	/**
	 * Removes the given edge.
	 * 
	 * @param u
	 * @param v
	 */
	public void removeEdge(int u, int v) {
		if (IsValidEdge(u, v)) {
			graph[u][v][0] = 0;
			graph[u][v][1] = 0;
		}
	}
	/**
	 * Returns the String representation.
	 */
	public String toString() {
		String retVal = "    ";

		for (int i = 0; i < graph[0].length; i++) {
			retVal += ((i + 1) + " ");
		}
		retVal += "\n   ";
		for (int i = 0; i < graph[0].length; i++) {
			retVal += "__";
		}
		retVal += "\n";
		for (int i = 0; i < graph.length; i++) {
			retVal += ((i + 1) + " | ");
			for (int j = 0; j < graph[0].length; j++) {
				retVal += (graph[i][j][0] + " ");
			}
			retVal += "\n";
		}

		return retVal;
	}
	/**
	 * Travels to the given node.
	 * 
	 * @param node
	 */
	public void travel(int node) {
		System.out.print("-> " + node);
		for (int i = node; i < 4; ++i) {
			if (i == node)
				continue;
			if (graph[node][i][0] > 0)
				travel(i);
		}
	}
	/**
	 * The Main Launch class.
	 * 
	 * @param arg
	 */
	public static void main(String arg[]) {
		Graph1 graph = new Graph1(4, 4);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 0, 3);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 0, 3);
		graph.addEdge(2, 1, 3);

		System.out.println(graph.toString());

		graph.travel(1);

	}
}