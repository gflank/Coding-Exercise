// union find, still slow
public class Solution { 
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        
        int[] lineage = new int[n + 1];
        for (int[] edge : edges) {
            int root1 = getRoot(edge[0] + 1, lineage);
            int root2 = getRoot(edge[1] + 1, lineage);
            // union two sets
            if (root1 != root2) {
                lineage[root1] = root2;
            }
        }
        
        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            roots.add(getRoot(i + 1, lineage));
        }
        return roots.size();
    }
    
    private int getRoot(int cur, int[] lineage) {
        if (lineage[cur] == 0) {
            return cur;
        }
        // go up two levels at one time for speeding up
        lineage[cur] = getRoot(lineage[cur], lineage);
        return getRoot(lineage[cur], lineage);
    }
}


// union find, another version
public class Solution { 
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        
        int[] lineage = new int[n + 1];
        for (int[] edge : edges) {
            int root1 = getRoot(edge[0] + 1, lineage);
            int root2 = getRoot(edge[1] + 1, lineage);
            // union two sets
            lineage[root1] = root2;
        }
        
        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            roots.add(getRoot(i + 1, lineage));
        }
        return roots.size();
    }
    
    private int getRoot(int cur, int[] lineage) {
        if (lineage[cur] == 0 || lineage[cur] == cur) {
            return cur;
        }
        lineage[cur] = getRoot(lineage[cur], lineage);
        return getRoot(lineage[cur], lineage);
    }
}


// DFS
public class Solution {
    private int count;
    
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        
        // store whole graph info
        List<HashSet<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    
        count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(i)) {
                ++count;
                visited.add(i);
                dfs(i, visited, adjList);
            }
        }
        return count;
    }
    
    private void dfs(int cur, HashSet<Integer> visited, List<HashSet<Integer>> adjList) {
        for (int nei : adjList.get(cur)) {
            if (!visited.contains(nei)) {
                visited.add(nei);
                adjList.get(nei).remove(cur);
                dfs(nei, visited, adjList);
            }
        }
    }
}


// BFS
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        
        // store whole graph info
        List<HashSet<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(i)) {
                ++count;
                visited.add(i);
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int nei : adjList.get(cur)) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.offer(nei);
                            adjList.get(nei).remove(cur);
                        }
                    }
                }
            }
        }
        return count;
    }
}