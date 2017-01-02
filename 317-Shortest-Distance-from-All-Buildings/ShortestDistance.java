// starting from 1s, still slow (74ms, 31.16%)
public class Solution {
    private int[][] shifts = {{-1, 0}, {0, -1}, {1,0}, {0, 1}};
    
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] dis = new int[grid.length][grid[0].length];
        int[][] reached = new int[grid.length][grid[0].length];
        int buildings = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ++buildings;
                    bfs(grid, dis, reached, i, j);
                }
            }
        }

        // now scan through all empty places to check the shortest distance
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0 && reached[i][j] == buildings) {
                    shortest = Math.min(shortest, dis[i][j]);
                }
            }
        }
        // in case no building or no path
        if (shortest == Integer.MAX_VALUE || shortest == 0) {
            return -1;
        }
        return shortest;
    }
    
    private void bfs(int[][] grid, int[][] dis, int[][] reached, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int curDis = 1;
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int num = 0; num < levelNum; ++num) {
                int[] cur = queue.poll();

                // add all neighbours into queue
                for (int[] shift : shifts) {
                    int nextI = cur[0] + shift[0];
                    int nextJ = cur[1] + shift[1];
                    if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && grid[nextI][nextJ] == 0 && !visited[nextI][nextJ]) {
                        dis[nextI][nextJ] += curDis;
                        ++reached[nextI][nextJ];
                        visited[nextI][nextJ] = true;
                        queue.offer(new int[] {nextI, nextJ});
                    }
                }
            }
            ++curDis;
        }
    }
}


// starting from 0s, accepted but super slow
public class Solution {
    private class Position {
        int i;
        int j;
        
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int count = 0;
        // first count how many buildings we have
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // do dfs if reach an empty land
                if (grid[i][j] == 0) {
                    // now do bfs starting from current position
                    int buildingCount = 0, dis = 0, curDis = 0;
                    // visited table
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    Queue<Position> queue = new LinkedList<>();
                    queue.offer(new Position(i, j));
                    while (!queue.isEmpty()) {
                        int levelNum = queue.size();
                        for (int num = 0; num < levelNum; ++num) {
                            Position cur = queue.poll();
                            // out of bound detection
                            if (cur.i < 0 || cur.i >= grid.length || cur.j < 0 || cur.j >= grid[0].length) {
                                continue;
                            }
                            // check and mark visited
                            if (visited[cur.i][cur.j]) {
                                continue;
                            }
                            else {
                                visited[cur.i][cur.j] = true;
                            }
                            
                            if (grid[cur.i][cur.j] == 1) {
                                ++buildingCount;
                                dis += curDis;
                                if (dis >= shortest) {
                                    break;
                                }
                                continue;
                            }
                            else if (grid[cur.i][cur.j] == 2) {
                                continue;
                            }
                            
                            // if empty land, adding all neighbours into queue
                            queue.offer(new Position(cur.i - 1, cur.j));
                            queue.offer(new Position(cur.i, cur.j - 1));
                            queue.offer(new Position(cur.i + 1, cur.j));
                            queue.offer(new Position(cur.i, cur.j + 1));
                        }
                        // early pruing
                        if (dis >= shortest) {
                            break;
                        }
                        ++curDis;
                    }
                    
                    // dis is valid only if touched all buildings
                    if (buildingCount == count) {
                        shortest = Math.min(shortest, dis);
                    }
                }
            }
        }
        // if not found
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
}

// changed Position to int[], only 10ms faster...
public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int count = 0;
        // first count how many buildings we have
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // do dfs if reach an empty land
                if (grid[i][j] == 0) {
                    // now do bfs starting from current position
                    int buildingCount = 0, dis = 0, curDis = 0;
                    // visited table
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int levelNum = queue.size();
                        for (int num = 0; num < levelNum; ++num) {
                            int[] cur = queue.poll();
                            // out of bound detection
                            if (cur[0] < 0 || cur[0] >= grid.length || cur[1] < 0 || cur[1] >= grid[0].length) {
                                continue;
                            }
                            // check and mark visited
                            if (visited[cur[0]][cur[1]]) {
                                continue;
                            }
                            else {
                                visited[cur[0]][cur[1]] = true;
                            }
                            
                            if (grid[cur[0]][cur[1]] == 1) {
                                ++buildingCount;
                                dis += curDis;
                                if (dis >= shortest) {
                                    break;
                                }
                                continue;
                            }
                            else if (grid[cur[0]][cur[1]] == 2) {
                                continue;
                            }
                            
                            // if empty land, adding all neighbours into queue
                            queue.offer(new int[] {cur[0] - 1, cur[1]});
                            queue.offer(new int[] {cur[0], cur[1] - 1});
                            queue.offer(new int[] {cur[0] + 1, cur[1]});
                            queue.offer(new int[] {cur[0], cur[1] + 1});
                        }
                        // early pruing
                        if (dis >= shortest) {
                            break;
                        }
                        ++curDis;
                    }
                    
                    // dis is valid only if touched all buildings
                    if (buildingCount == count) {
                        shortest = Math.min(shortest, dis);
                    }
                }
            }
        }
        // if not found
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
}


[[0,0,0,0,2,2,0],[2,0,2,0,0,2,2],[0,2,0,0,0,0,0],[2,2,0,2,0,0,0],[0,0,0,2,2,2,0],[0,0,0,0,2,2,0],[2,0,0,0,0,0,0],[0,0,0,0,2,2,2],[0,2,0,0,0,2,2],[2,2,2,2,0,0,0],[2,0,2,0,2,2,2],[0,2,2,0,0,0,0],[2,2,0,2,0,0,2],[0,2,0,0,0,0,2],[0,2,0,0,0,0,2],[0,0,2,0,2,0,0],[2,2,2,0,2,0,0],[2,0,0,2,2,2,0],[0,0,0,0,2,1,0],[2,0,0,0,0,0,2],[0,0,2,0,0,0,2],[0,0,0,0,0,0,0],[2,0,0,0,0,2,0],[2,2,0,0,2,2,0],[2,0,0,2,2,2,0],[0,0,0,0,2,0,0],[0,0,0,2,1,0,0],[0,0,0,0,0,2,0],[0,2,2,0,1,2,0],[1,0,0,2,2,0,0],[0,2,2,2,1,2,0],[2,0,0,0,2,2,2],[0,2,2,2,2,2,0],[0,2,2,2,0,2,2],[2,0,0,0,0,2,0],[0,2,1,0,0,0,2],[0,2,0,0,2,2,0],[0,2,2,0,0,0,2],[0,0,0,0,2,0,0],[0,0,0,0,0,0,0],[2,0,0,2,0,0,2],[2,2,2,0,2,1,0],[0,2,0,0,2,0,0],[0,2,0,0,2,2,0],[2,0,0,0,0,2,0],[2,0,0,0,2,0,2],[2,2,0,2,2,0,2],[2,2,0,1,0,0,1],[0,0,0,0,0,2,2],[0,0,2,0,0,0,1],[2,2,0,2,2,0,2]]
