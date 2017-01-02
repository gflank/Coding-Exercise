// constant space version
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }

        for (int i = 0; i <  board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        // if visited or not match
        if (board[i][j] == '*' || word.charAt(index) != board[i][j]) {
            return false;
        }
        // if reach the end
        if (index == word.length() - 1) {
            return true;
        }
        
        // mark as visited
        char temp = board[i][j];
        board[i][j] = '*';
        if (dfs(board, i - 1, j, word, index + 1)
            || dfs(board, i, j - 1, word, index + 1)
            || dfs(board, i + 1, j, word, index + 1)
            || dfs(board, i, j + 1, word, index + 1)) {
            return true;
        }
        // unmark
        board[i][j] = temp;
        return false;
    }
}

// public class Solution {
//     public boolean exist(char[][] board, String word) {
//         if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
//             return false;
//         }
        
//         boolean[][] visit = new boolean[board.length][board[0].length];
//         for (int i = 0; i <  board.length; ++i) {
//             for (int j = 0; j < board[0].length; ++j) {
//                 if (board[i][j] == word.charAt(0)) {
//                     if (dfs(board, visit, i, j, word, 0)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
    
//     private boolean dfs(char[][] board, boolean[][] visit, int i, int j, String word, int index) {
//         if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
//             return false;
//         }
//         // if visited or not match
//         if (visit[i][j] == true || word.charAt(index) != board[i][j]) {
//             return false;
//         }
//         // if reach the end
//         if (index == word.length() - 1) {
//             return true;
//         }
        
//         // mark as visited
//         visit[i][j] = true;
//         if (dfs(board, visit, i - 1, j, word, index + 1)
//             || dfs(board, visit, i, j - 1, word, index + 1)
//             || dfs(board, visit, i + 1, j, word, index + 1)
//             || dfs(board, visit, i, j + 1, word, index + 1)) {
//             return true;
//         }
//         // unmark
//         visit[i][j] = false;
//         return false;
//     }
// }