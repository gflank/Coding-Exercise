// Best Time to Buy and Sell Stock Total Accepted: 53461 Total Submissions: 163853 My Submissions Question Solution 
// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Hide Tags Array Dynamic Programming

public class BestTime {
    // public int maxProfit(int[] prices) {
    //     if (prices == null || prices.length == 0) {
    //     	return 0;
    //     }

    //     int min = Integer.MAX_VALUE;
    //     int profit = 0;
    //     for (int i = 0; i < prices.length; ++i) {
    //     	if (prices[i] < min) {
    //     		min = prices[i];
    //     	}
    //     	if (prices[i] - min > profit) {
    //     		profit = prices[i] - min;
    //     	}
    //     }

    //     return profit;
    // }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < len; ++i) {
            min = Math.min(min, prices[i]);
            int curProfit = prices[i] - min;
            maxProfit = Math.max(maxProfit, curProfit);
        }
        
        return maxProfit;
    }
}