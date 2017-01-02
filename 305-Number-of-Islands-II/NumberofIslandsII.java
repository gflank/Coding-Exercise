public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
        
        // table to store the relationship between cells
        int[] lineage = new int[n * m + 1];
        int[][] neighbors = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;
        
        for (int[] pos : positions) {
            // if already turned to island, skip
            int posIndex = n* pos[0] + pos[1] + 1;
            if (lineage[posIndex] != 0) {
                continue;
            }
            // mark current position's root parent as itself
            lineage[posIndex] = posIndex;
            ++count;
            
            // check neighors' roots
            for (int[] nei : neighbors) {
                int neiX = pos[0] + nei[0];
                int neiY = pos[1] + nei[1];
                int neiRoot = n * neiX + neiY + 1;
                // if neighbor is water, skip
                if (neiX < 0 || neiX >= m || neiY < 0 || neiY >= n || lineage[neiRoot] == 0) {
                    continue;
                }
                
                // get root
                while (neiRoot != lineage[neiRoot]) {
                    // skip one level for speed up
                    neiRoot = lineage[lineage[neiRoot]];
                }
                // if root is different, set current pos's root the same as neighbor's
                if (posIndex != neiRoot) {
                    lineage[posIndex] = neiRoot;
                    --count;
                    // modify current root to the new one and continue check remaining neighbors
                    posIndex = neiRoot;
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
}