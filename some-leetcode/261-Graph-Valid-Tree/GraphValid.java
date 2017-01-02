// union find
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] union = new int[n + 1];
        for (int[] edge : edges) {
            int u1 = find(edge[0] + 1, union);
            int u2 = find(edge[1] + 1, union);
            // if an edge occur within one union, cycle
            if (u1 == u2) {
                return false;
            }
            union[u1] = u2;
        }
        return true;
    }
    
    private int find(int n, int[] union) {
        if (union[n] == 0) {
            return n;
        }
        return find(union[n], union);
    }
}


// DFS
public class Solution {
    private List<HashSet<Integer>> adjList;
    private HashSet<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // store all graph infomation
        adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        visited = new HashSet<>();
        if(!dfs(0)) return false;
        return visited.size() == n;
    }
    
    private boolean dfs(int cur) {
        if (visited.contains(cur)) {
            return false;
        }
        visited.add(cur);
        for (int nei : adjList.get(cur)) {
            adjList.get(nei).remove(cur);
            if (!dfs(nei)) return false;
        }
        return true;
    }
}

// BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // store all graph infomation
        List<HashSet<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited.contains(cur)) {
                return false;
            }
            else {
                visited.add(cur);
            }
            // add neighbours into queue and remove itself
            for (int nei : adjList.get(cur)) {
                queue.offer(nei);
                adjList.get(nei).remove(cur);
            }
        }
        return visited.size() == n;
    }
}