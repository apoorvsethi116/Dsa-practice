class Solution {
    public boolean found(char[][] board, int i, int j, String word, int idx) {
        // 1. Success Check: If idx matches word length, we found the whole word!
        if (idx == word.length()) {
            return true;
        }

        // 2. Failure Check: Out of bounds, wrong character, or already visited ('#')
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // 3. Commitment: Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // 4. Exploration: Check all 4 directions for the NEXT character (idx + 1)
        // If ANY of these return true, result becomes true
        boolean result = found(board, i + 1, j, word, idx + 1) ||
                         found(board, i - 1, j, word, idx + 1) ||
                         found(board, i, j + 1, word, idx + 1) ||
                         found(board, i, j - 1, word, idx + 1);

        // 5. Backtrack: Put the original character back so other paths can use it
        board[i][j] = temp;

        return result;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // We start the DFS at every cell to see if the word begins there
                if (found(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}