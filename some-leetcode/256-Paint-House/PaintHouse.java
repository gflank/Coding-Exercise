public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        if (costs[0].length == 0) {
            return 0;
        }
        
        for (int house = 1; house < costs.length; ++house) {
            // the min cost depend on costs from two others color one step before
            costs[house][0] = costs[house][0] + Math.min(costs[house - 1][1], costs[house - 1][2]);
            costs[house][1] = costs[house][1] + Math.min(costs[house - 1][0], costs[house - 1][2]);
            costs[house][2] = costs[house][2] + Math.min(costs[house - 1][0], costs[house - 1][1]);
        }
        
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}