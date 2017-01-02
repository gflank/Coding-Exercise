// Medium Coins in a Line Show result 

// 40% Accepted
// There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

// Could you please decide the first play will win or lose?

// Have you met this question in a real interview? Yes
// Example
// n = 1, return true.

// n = 2, return true.

// n = 3, return false.

// n = 4, return true.

// n = 5, return true.

// Challenge
// O(n) time and O(1) memory

// Tags Expand 
// Greedy Dynamic Programming Array Game Theory


// Related Problems Expand 
// Hard Coins in a Line III 30 %
// Medium Coins in a Line II 29 %

public class Coins1 {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return n % 3 != 0;
    }
}
