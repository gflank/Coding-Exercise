import java.util.*;

// priority: ^, >, v, <
// X = extraction node, o = open node, F = failed node

// methodology: bfs from every o node to gain the shortest distance

public class SensorNetwork {
	public static void network(char[][] input) {
		if (input.length == 0) {
			return;
		}

		int[][] dis = new int[input.length][input[0].length];

		for (int i = 0; i < input.length; ++i) {
			for (int j = 0; j < input[0].length; ++j) {
				if (input[i][j] == 'o') {
					bfs(input, dis, i, j);
				}
			}
		}
	}

	private static void bfs(char[][] input, int[][] dis, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		int level = 0;
		int[][] shift = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		char[] dirs = {'v', '>', '^', '<'};
		boolean[][] visited = new boolean[input.length][input[0].length];
		queue.offer(new int[] {i, j, 0});
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int n = 0; n < levelSize; ++n) {
				int[] cur = queue.poll();
				int curi = cur[0];
				int curj = cur[1];
				// mark as visited
				visited[curi][curj] = true;
				// direction points to previous
				if (level != 0) {
					char dir = (char)('^' + cur[2]);
					if (input[curi][curj] == 'o' || input[curi][curj] == 'F') {
						continue;
					}
					if (dis[curi][curj] == level) {
						input[curi][curj] = judge(input[curi][curj], dir);
						continue;
					}
					else if (dis[curi][curj] == 0 || dis[curi][curj] > level) {
						// use the smaller distance
						dis[curi][curj] = level;
						input[curi][curj] = dir;
					}
				}

				// put neighbours into queue
				for (int nei = 0; nei < 4; ++nei) {
					int nexti = curi + shift[nei][0];
					int nextj = curj + shift[nei][1];
					// out of bound detection
					if (nexti >= 0 && nexti < input.length && nextj >= 0 && nextj < input[0].length && !visited[nexti][nextj]) {
						queue.offer(new int[] {nexti, nextj, dirs[nei] - '^'});
					}
				}
			}
			++level;
		}
	}

	// judge the direction based on priority
	private static char judge(char c1, char c2) {
		if (c1 == '^' || c2 == '^') {
			return '^';
		}
		else if (c1 == '>' || c2 == '>') {
			return '>';
		}
		else if (c1 == 'v' || c2 == 'v') {
			return 'v';
		}
		return '<';
	}

	public static void main(String[] args) {
		char[][] test1 = new char[][] {{'X', 'o', 'X'}, {'X', 'F', 'X'}, {'X', 'F', 'o'}};
		System.out.println("test1 input:");
		for (int i = 0; i < test1.length; ++i) {
			for (int j = 0; j < test1[0].length; ++j) {
				System.out.printf("%c ", test1[i][j]);
			}
			System.out.println("");
		}
		System.out.println("test1 output:");
		SensorNetwork.network(test1);
		for (int i = 0; i < test1.length; ++i) {
			for (int j = 0; j < test1[0].length; ++j) {
				System.out.printf("%c ", test1[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");

		/* --------------------------------------------------*/

		char[][] test2 = new char[][] {{'X', 'o', 'X', 'o'}, {'X', 'F', 'X', 'X'}, {'X', 'F', 'o', 'o'}, {'X', 'X', 'X', 'F'}};
		System.out.println("test2 input:");
		for (int i = 0; i < test2.length; ++i) {
			for (int j = 0; j < test2[0].length; ++j) {
				System.out.printf("%c ", test2[i][j]);
			}
			System.out.println("");
		}
		System.out.println("test2 output:");
		SensorNetwork.network(test2);
		for (int i = 0; i < test2.length; ++i) {
			for (int j = 0; j < test2[0].length; ++j) {
				System.out.printf("%c ", test2[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");

	}
}