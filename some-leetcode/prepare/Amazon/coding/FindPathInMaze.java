import java.util.*;

public class FindPathInMaze {
	public static boolean findPath(int[][] maze) {
		if (maze.length == 0 || maze[0].length == 0) {
			return false;
		}
		return dfs(maze, 0, 0);
	}

	public static boolean dfs(int[][] maze, int row, int col) {
		// check with boundary
		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
			return false;
		}
		// if reach the goal
		if (maze[row][col] == 9) {
			return true;
		}
		// if blocked or visited, go back
		else if (maze[row][col] != 1) {
			return false;
		}

		// 0 -> blocked
		// 1 -> can go
		// 9 -> goal
		// 2 -> visited
		// mark this block as visited
		maze[row][col] = 2;
		if (dfs(maze, row - 1, col)
			|| dfs(maze, row, col - 1)
			|| dfs(maze, row + 1, col)
			|| dfs(maze, row, col + 1)) {
			return true;
		}
		// no path found
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = new int[4][4];
		maze[0] = new int[] {1, 1, 1, 0};
		maze[1] = new int[] {1, 0, 1, 1};
		maze[2] = new int[] {0, 1, 1, 0};
		maze[3] = new int[] {9, 1, 0, 9};
		System.out.println(FindPathInMaze.findPath(maze));
	}
}