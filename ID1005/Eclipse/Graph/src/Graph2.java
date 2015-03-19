import java.util.Random;
/**
 * The Graph Implementation.
 * 
 */
public class Graph2 { // Graph data structure
	private int graph[][][];
	/**
	 * Default Constructor
	 */
	public Graph2() {
		graph = new int[10][10][2];
	}
	/**
	 * Default Args Constructor.
	 * 
	 * @param u
	 * @param v
	 */
	public Graph2(int u, int v) {
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
	 * Adds a Edge
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
	 * Removes the edge.
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
	 * Returns the string representation.
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
	 * Returns the Node count.
	 * 
	 * @return
	 */
	public int getNodeCount() {
		return graph.length;
	}
	/**
	 * Returns the Number of Edges.
	 * 
	 * @return
	 */
	public int getEdgesCount() {
		int edges = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				edges += graph[i][j][0];
			}
		}

		return edges;
	}
    /**
     * The Main Launch method.
     * @param arg
     */
	public static void main(String arg[]) {
		Random rand = new Random();
		int size = Math.abs(rand.nextInt()) % 10; // max node count is 9
		if (size == 0)
			size = 2;
		//Graph Instance
		Graph2 graph = new Graph2(size, size);
     
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int edge = rand.nextInt() % 2;
				int w = 0;
				if (edge > 0) {
					w = rand.nextInt() % 20;// max weight 20
					graph.addEdge(i, j, w);
				}

			}
		}

		System.out.println(graph.toString());

		System.out.println("Node Count  : " + graph.getNodeCount());

		System.out.println("Edges Count : " + graph.getEdgesCount());

	}
}