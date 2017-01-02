public class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        // get states
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = nextValue(i, j, board);
            }
        }
        
        // get results
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int countNeighbors(int nodei, int nodej, int[][] board) {
        int count = 0;
        for (int i = nodei - 1; i <= nodei + 1 && i < board.length; ++i) {
            if (i < 0) {
                continue;
            }
            for (int j = nodej - 1; j <= nodej + 1 && j < board[0].length; ++j) {
                if (j < 0) {
                    continue;
                }
                if ((i != nodei || j != nodej) && (board[i][j] == 1 || board[i][j] == 3)) {
                    ++count;
                }
            }
        }
        return count;
    }
    
    private boolean checkAlive(int i, int j, int[][] board) {
        int count = countNeighbors(i, j, board);
        if (count < 2) {
            return false;
        }
        else if (count > 3) {
            return false;
        }
        else if ((board[i][j] == 1 || board[i][j] == 3) && (count == 2 || count == 3)) {
            return true;
        }
        else if ((board[i][j] == 0 || board[i][j] == 2) && (count == 3)) {
            return true;
        }
        return false;
    }
    
    private int nextValue(int i, int j, int[][] board) {
        int curState = 0, nextState = 0;
        if (checkAlive(i, j, board)) {
            nextState = 1;
        }
        if (board[i][j] == 1 || board[i][j] == 3) {
            curState = 1;
        }
        return curState + nextState * 2;
    }
}