public class Solution {
    // o(1) space version
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        // below all indicate the max profit in corresponding states
        int haveStock = -prices[0];
        int justSold = Integer.MIN_VALUE;
        int noStock = 0;
        
        for (int i = 1; i < prices.length; ++i) {
            // already have a stock or buy a stock
            int curHaveStock = Math.max(haveStock, noStock - prices[i]);
            // do nothing after sold a stock or already no stock
            int curNoStock = Math.max(noStock, justSold);
            // sell a stock
            int curJustSold = haveStock + prices[i];
            
            haveStock = curHaveStock;
            justSold = curJustSold;
            noStock = curNoStock;
        }
        
        return Math.max(noStock, justSold);
    }
    
    // passed, o(n) space version
    // public int maxProfit(int[] prices) {
    //     if (prices.length == 0) {
    //         return 0;
    //     }
        
    //     // below all indicate the max profit in corresponding states
    //     int[] haveStock = new int[prices.length];
    //     int[] justSold = new int[prices.length];
    //     int[] noStock = new int[prices.length];
        
    //     // initially no profit
    //     haveStock[0] = -prices[0];
    //     justSold[0] = Integer.MIN_VALUE;
    //     noStock[0] = 0;
        
    //     for (int i = 1; i < prices.length; ++i) {
    //         // already have a stock or buy a stock
    //         haveStock[i] = Math.max(haveStock[i - 1], noStock[i - 1] - prices[i]);
    //         // do nothing after sold a stock or already no stock
    //         noStock[i] = Math.max(noStock[i - 1], justSold[i - 1]);
    //         // sell a stock
    //         justSold[i] = haveStock[i - 1] + prices[i];
    //     }
        
    //     return Math.max(noStock[prices.length - 1], justSold[prices.length - 1]);
    // }
    
    // wrong version
    // public int maxProfit(int[] prices) {
    //     if (prices.length == 0) {
    //         return 0;
    //     }
        
    //     int[] dp = new int[prices.length];
    //     dp[0] = 0;
    //     for (int i = 1; i < prices.length; ++i) {
    //         if (prices[i] <= prices[i - 1]) {
    //             dp[i] = dp[i - 1];
    //         }
    //         else {
    //             // if satisfied special trend, need to judge
    //             if (i >= 3 && dp[i - 3] < dp[i - 2]) {
    //                 dp[i] = Math.max(dp[i - 3] + prices[i] - prices[i - 1], dp[i - 1]);                    
    //             }
    //             else {
    //                 dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
    //             }
    //         }
    //     }
    //     return dp[prices.length - 1];
    // }
}