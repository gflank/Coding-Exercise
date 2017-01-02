public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (dis != 0 && (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] <= dis)) {
            return;
        }

        rooms[i][j] = dis;
        // visit four neighbours
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
    }
}