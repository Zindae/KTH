import java.io.*;
import java.util.*;

/**
 * Creates a Labyrinth with generates a solution for it.
 * 
 */
public class Labyrinth
{
	private static final String MAZE_FILE = "maze.txt";
	public static void main(String[] args) throws IOException
	{
		// The top left is considered as start point and the bottom right is
		// considered as the end point.
		// Create the Maze.
		MazeGenerator.generateMaze(MAZE_FILE, 10, 10);
		// Solves the Maze.
		MazeSolver.solveMaze(MAZE_FILE);
	}
	/**
	 * 
	 * This class generates a Random maze of given size and writes the Maze to a
	 * Text file.
	 * 
	 */
	public static class MazeGenerator
	{
		// The size of maze in X direction.
		private final int x;
		// The size of maze in Y direction.
		private final int y;
		// The maze data is stored in this array.
		private final int[][] maze;

		private MazeGenerator(int x, int y)
		{
			this.x = x;
			this.y = y;
			maze = new int[this.x][this.y];
			generateMaze(0, 0);
		}
		
		/**
		 * Writes the Maze to the given file.
		 * 
		 * @param file
		 * @throws IOException
		 */
		
		public void writeMazeToFile(String file) throws IOException
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					file)));
			for (int i = 0; i < y; i++)
			{
				// draw the north edge
				for (int j = 0; j < x; j++)
				{
					writer.append((maze[j][i] & 1) == 0 ? "+---" : "+   ");
				}
				writer.append("+\n");
				// draw the west edge
				for (int j = 0; j < x; j++)
				{
					writer.append((maze[j][i] & 8) == 0 ? "|   " : "    ");
				}
				writer.append("|\n");
			}
			// draw the bottom line
			for (int j = 0; j < x; j++)
			{
				writer.append("+---");
			}
			writer.append("+\n");
			writer.flush();
			writer.close();
		}
		
		/**
		 * Generates a random Maze using recursion.
		 * 
		 * @param cx
		 * @param cy
		 */
		private void generateMaze(int cx, int cy)
		{
			DIR[] dirs = DIR.values();
			// The directions are randomized here.
			Collections.shuffle(Arrays.asList(dirs));
			for (DIR dir : dirs)
			{
				int nx = cx + dir.dx;
				int ny = cy + dir.dy;
				if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0))
				{ // The condition to move forward.
					maze[cx][cy] |= dir.bit;
					maze[nx][ny] |= dir.opposite.bit;
					generateMaze(nx, ny);
				}
			}
		}
		/**
		 * Returns true if the value of v is in between 0 and upper.
		 * 
		 * @param v
		 * @param upper
		 * @return
		 */
		private static boolean between(int v, int upper)
		{
			return (v >= 0) && (v < upper);
		}
		// The direction information is held here.
		private enum DIR
		{
			N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
			// A unique indicator for the direction.
			private final int bit;
			// The direction in x coordinate
			private final int dx;
			// The direction in y coordinate
			private final int dy;
			// The opposite direction.
			private DIR opposite;

			// use the static initializer to resolve forward references
			static
			{
				N.opposite = S;
				S.opposite = N;
				E.opposite = W;
				W.opposite = E;
			}

			private DIR(int bit, int dx, int dy)
			{
				this.bit = bit;
				this.dx = dx;
				this.dy = dy;
			}
		};
		/**
		 * Generates Maze to the given file.
		 * 
		 * @param file
		 *            The file to which the Maze is drawn.
		 * @param x
		 *            The size along x direction
		 * @param y
		 *            The size along y direction.
		 * @throws IOException
		 */
		public static void generateMaze(String file, int x, int y)
				throws IOException
		{
			MazeGenerator maze = new MazeGenerator(x, y);
			// Writes the Maze to the text file.
			maze.writeMazeToFile(file);
		}
	}
	/**
	 * This class implements the MazeSolver.
	 * 
	 */
	public static class MazeSolver
	{

		/**
		 * Reads a file into an array of strings, one per line.
		 */
		private static String[] readLines(InputStream f) throws IOException
		{
			BufferedReader r = new BufferedReader(new InputStreamReader(f,
					"US-ASCII"));
			ArrayList<String> lines = new ArrayList<String>();
			String line;
			while ((line = r.readLine()) != null)
				lines.add(line);
			return lines.toArray(new String[0]);
		}

		/**
		 * Makes the maze half as wide (i. e. "+---+" becomes "+-+"), so that
		 * each cell in the maze is the same size horizontally as vertically.
		 * (Versus the expanded version, which looks better visually.) Also,
		 * converts each line of the maze from a String to a char[], because
		 * we'll want mutability when drawing the solution later.
		 */
		private static char[][] decimateHorizontally(String[] lines)
		{
			final int width = (lines[0].length() + 1) / 2;
			char[][] c = new char[lines.length][width];
			for (int i = 0; i < lines.length; i++)
				for (int j = 0; j < width; j++)
					c[i][j] = lines[i].charAt(j * 2);
			return c;
		}

		/**
		 * Given the maze, the x and y coordinates (which must be odd), and the
		 * direction we came from, return true if the maze is solvable, and draw
		 * the solution if so.
		 */
		private static boolean solveMazeRecursively(char[][] maze, int x,
				int y, int d)
		{
			boolean ok = false;
			for (int i = 0; i < 4 && !ok; i++)
				if (i != d)
					switch (i)
					{
					// 0 = up, 1 = right, 2 = down, 3 = left
						case 0 :
							if (maze[y - 1][x] == ' ')
								ok = solveMazeRecursively(maze, x, y - 2, 2);
							break;
						case 1 :
							if (maze[y][x + 1] == ' ')
								ok = solveMazeRecursively(maze, x + 2, y, 3);
							break;
						case 2 :
							if (maze[y + 1][x] == ' ')
								ok = solveMazeRecursively(maze, x, y + 2, 0);
							break;
						case 3 :
							if (maze[y][x - 1] == ' ')
								ok = solveMazeRecursively(maze, x - 2, y, 1);
							break;
					}
			// check for end condition
			if (x == 1 && y == 1)
				ok = true;
			// once we have found a solution, draw it as we unwind the recursion
			if (ok)
			{
				maze[y][x] = '*';
				switch (d)
				{
					case 0 :
						maze[y - 1][x] = '*';
						break;
					case 1 :
						maze[y][x + 1] = '*';
						break;
					case 2 :
						maze[y + 1][x] = '*';
						break;
					case 3 :
						maze[y][x - 1] = '*';
						break;
				}
			}
			return ok;
		}

		/**
		 * Solve the maze and draw the solution. For simplicity, assumes the
		 * starting point is the lower right, and the ending point is the upper
		 * left.
		 */
		private static void solveMaze(char[][] maze)
		{
			solveMazeRecursively(maze, maze[0].length - 2, maze.length - 2, -1);
		}

		/**
		 * Opposite of decimateHorizontally(). Adds extra characters to make the
		 * maze "look right", and converts each line from char[] to String at
		 * the same time.
		 */
		private static String[] expandHorizontally(char[][] maze)
		{
			char[] tmp = new char[3];
			String[] lines = new String[maze.length];
			for (int i = 0; i < maze.length; i++)
			{
				StringBuilder sb = new StringBuilder(maze[i].length * 2);
				for (int j = 0; j < maze[i].length; j++)
					if (j % 2 == 0)
						sb.append(maze[i][j]);
					else
					{
						tmp[0] = tmp[1] = tmp[2] = maze[i][j];
						if (tmp[1] == '*')
							tmp[0] = tmp[2] = ' ';
						sb.append(tmp);
					}
				lines[i] = sb.toString();
			}
			return lines;
		}

		/**
		 * Solves the Maze.
		 */
		public static void solveMaze(String mazeFile) throws IOException
		{
			InputStream f = new FileInputStream(new File(mazeFile));
			//Copy the file contents into string array.
			String[] lines = readLines(f);
			char[][] maze = decimateHorizontally(lines);
			//Solve the Maze.
			solveMaze(maze);
			//Solved lines.
			String[] solvedLines = expandHorizontally(maze);
			for (int i = 0; i < solvedLines.length; i++)
				System.out.println(solvedLines[i]);
			f.close();
		}

	}

}